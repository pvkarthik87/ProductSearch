package com.karcompany.productsearch.views.fragments;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * Images fragment which displays server data in a recycler view.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karcompany.productsearch.R;
import com.karcompany.productsearch.config.ViewType;
import com.karcompany.productsearch.di.components.ApplicationComponent;
import com.karcompany.productsearch.events.BusEvents;
import com.karcompany.productsearch.events.RxBus;
import com.karcompany.productsearch.logging.DefaultLogger;
import com.karcompany.productsearch.models.ProductSearchApiResponse;
import com.karcompany.productsearch.models.Result;
import com.karcompany.productsearch.presenters.BrowseProductsPresenter;
import com.karcompany.productsearch.views.BrowseImagesView;
import com.karcompany.productsearch.views.adapters.BrowseProductsAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class BrowseProductsFragment extends BaseFragment implements BrowseImagesView {

	private static final String TAG = DefaultLogger.makeLogTag(BrowseProductsFragment.class);

	private static final String CURRENT_VIEW_TYPE = "CURRENT_VIEW_TYPE";
	private static final String CURRENT_IMAGE_LIST = "CURRENT_IMAGE_LIST";

	@Bind(R.id.product_list)
	RecyclerView mProductsRecyclerView;

	@Inject
	BrowseProductsPresenter mBrowseProductsPresenter;

	@Bind(R.id.fabbutton)
	FloatingActionButton mFabBtn;

	private BrowseProductsAdapter mAdapter;
	private ViewType mCurrentViewType = ViewType.LIST;

	private LinearLayoutManager mLayoutManager;
	private GridLayoutManager mGridLayoutManager;
	private StaggeredGridLayoutManager mStaggeredGridLayoutManager;

	@Inject
	RxBus mEventBus;

	private Subscription mBusSubscription;
	private long mVisibleThreshold = 5;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_browse_products, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setUpUI(savedInstanceState);
	}

	private void setUpUI(Bundle savedInstanceState) {
		if (savedInstanceState != null) {
			if(savedInstanceState.containsKey(CURRENT_VIEW_TYPE)) {
				mCurrentViewType = ViewType.get(savedInstanceState.getString(CURRENT_VIEW_TYPE, ViewType.LIST.toString()));
			}
		}
		setUpPresenter();
		setUpFabBtn();
		mAdapter = new BrowseProductsAdapter(this);
		setUpRecyclerView();
		if (savedInstanceState != null) {
			if(savedInstanceState.containsKey(CURRENT_IMAGE_LIST)) {
				ArrayList<Result> imageList = savedInstanceState.getParcelableArrayList(CURRENT_IMAGE_LIST);
				mAdapter.addData(imageList);
			}
		}
		mProductsRecyclerView.addOnScrollListener(mScrollListener);
	}

	private void setUpPresenter() {
		mBrowseProductsPresenter.setView(this);
	}

	private void setUpRecyclerView() {
		switch(mCurrentViewType) {
			case LIST: {
				mLayoutManager = new LinearLayoutManager(
						getActivity(), LinearLayoutManager.VERTICAL, false);
				mProductsRecyclerView.setLayoutManager(mLayoutManager);
			}
			break;

			case GRID: {
				mGridLayoutManager = new GridLayoutManager(
						getActivity(), 2);
				mProductsRecyclerView.setLayoutManager(mGridLayoutManager);
				mGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
					@Override
					public int getSpanSize(int position) {
						return (mAdapter.isLoadingPos(position)) ? mGridLayoutManager.getSpanCount() : 1;
					}
				});
			}
			break;

			case STAGGERED: {
				mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
				mProductsRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
			}
			break;
		}
		mProductsRecyclerView.setAdapter(mAdapter);
		mAdapter.setViewMode(mCurrentViewType);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getComponent(ApplicationComponent.class).inject(this);
	}

	@Override
	public void onStart() {
		super.onStart();
		mBrowseProductsPresenter.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
		mBrowseProductsPresenter.onResume();
		autoUnsubBus();
		subscribeBus();
	}

	private void subscribeBus() {
		mBusSubscription = mEventBus.toObserverable()
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(
						new Action1<Object>() {
							@Override
							public void call(Object o) {
								handlerBus(o);
							}
						}
				);
	}

	private void autoUnsubBus() {
		if (mBusSubscription != null && !mBusSubscription.isUnsubscribed()) {
			mBusSubscription.unsubscribe();
		}
	}

	private void handlerBus(Object o) {
		if(o instanceof BusEvents.ProductClicked) {
			BusEvents.ProductClicked event = (BusEvents.ProductClicked)o;
			onProductClicked(event.product);
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		mBrowseProductsPresenter.onPause();
		autoUnsubBus();
	}

	@Override
	public void onStop() {
		super.onStop();
		mBrowseProductsPresenter.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mBrowseProductsPresenter.onDestroy();
		mAdapter.clearData();
	}

	@Override
	public void onDestroyView() {
		mProductsRecyclerView.setAdapter(null);
		mProductsRecyclerView.removeOnScrollListener(mScrollListener);
		super.onDestroyView();
	}

	@Override
	public void onDataReceived(ProductSearchApiResponse response) {
		mAdapter.addData(response);
		if(response != null && response.getResults() != null && response.getResults().size() > 0) {
			mFabBtn.setVisibility(View.VISIBLE);
		} else {
			mFabBtn.setVisibility(View.GONE);
		}
	}

	@Override
	public void onFailure(String errorMsg) {

	}

	@OnClick(R.id.fabbutton)
	public void onToogleViewClicked() {
		switch(mCurrentViewType) {
			case LIST: {
				mCurrentViewType = ViewType.GRID;
			}
			break;

			case GRID: {
				mCurrentViewType = ViewType.STAGGERED;
			}
			break;

			case STAGGERED: {
				mCurrentViewType = ViewType.LIST;
			}
			break;
		}
		setUpRecyclerView();
		setUpFabBtn();
	}

	private void setUpFabBtn() {
		switch(mCurrentViewType) {
			case LIST: {
				mFabBtn.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_grid_on_white_36dp));
			}
			break;

			case GRID: {
				mFabBtn.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_dashboard_white_36dp));
			}
			break;

			case STAGGERED: {
				mFabBtn.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.ic_view_list_white_36dp));
			}
			break;
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString(CURRENT_VIEW_TYPE, mCurrentViewType.getCode());
		outState.putParcelableArrayList(CURRENT_IMAGE_LIST, mAdapter.getImageList());
	}

	private RecyclerView.OnScrollListener mScrollListener = new RecyclerView.OnScrollListener() {
		@Override
		public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
			super.onScrolled(recyclerView, dx, dy);
			int totalItemCount = 0;
			int lastVisibleItem = 0;
			switch (mCurrentViewType) {
				case LIST: {
					totalItemCount = mLayoutManager.getItemCount();
					lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
				}
				break;

				case GRID: {
					totalItemCount = mGridLayoutManager.getItemCount();
					lastVisibleItem = mGridLayoutManager.findLastVisibleItemPosition();
				}
				break;

				case STAGGERED: {
					totalItemCount = mStaggeredGridLayoutManager.getItemCount();
					int[] positions = new int[2];
					positions = mStaggeredGridLayoutManager.findLastVisibleItemPositions(positions);
					lastVisibleItem = positions[1] > positions[0] ? positions[1] : positions[0];
				}
				break;
			}
			if (!mBrowseProductsPresenter.isLoading()
					&& totalItemCount <= (lastVisibleItem + mVisibleThreshold)) {
				//End of the items
				mAdapter.loadMore();
			}
		}
	};

	@Override
	public void onNewSearchQuery(String searchTerm) {
		mAdapter.loadData(searchTerm);
	}

	private void onProductClicked(Result image) {
		mBrowseProductsPresenter.setSelectedProduct(image);
	}
}
