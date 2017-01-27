package com.karcompany.productsearch.views.fragments;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * Recently viewed products fragment in recycler view.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.karcompany.productsearch.R;
import com.karcompany.productsearch.config.ViewType;
import com.karcompany.productsearch.di.components.ApplicationComponent;
import com.karcompany.productsearch.events.BusEvents;
import com.karcompany.productsearch.events.RxBus;
import com.karcompany.productsearch.logging.DefaultLogger;
import com.karcompany.productsearch.models.Result;
import com.karcompany.productsearch.presenters.BrowseProductsPresenter;
import com.karcompany.productsearch.presenters.RecentlyViewedPresenter;
import com.karcompany.productsearch.views.RecentlyViewedView;
import com.karcompany.productsearch.views.activities.ProductDetailsActivity;
import com.karcompany.productsearch.views.adapters.BrowseProductsAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class RecentlyViewedFragment extends BaseFragment implements RecentlyViewedView {

	private static final String TAG = DefaultLogger.makeLogTag(RecentlyViewedFragment.class);

	@Bind(R.id.product_list)
	RecyclerView mProductsRecyclerView;

	@Inject
	RecentlyViewedPresenter mRecentlyViewedPresenter;

	@Inject
	BrowseProductsPresenter mBrowseProductsPresenter;

	private BrowseProductsAdapter mAdapter;

	@Inject
	RxBus mEventBus;

	private Subscription mBusSubscription;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_recently_viewed, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setUpUI(savedInstanceState);
	}

	private void setUpUI(Bundle savedInstanceState) {
		setUpPresenter();
		mAdapter = new BrowseProductsAdapter(this);
		setUpRecyclerView();
	}

	private void setUpPresenter() {
		mRecentlyViewedPresenter.setView(this);
	}

	private void setUpRecyclerView() {
		LinearLayoutManager layoutManager = new LinearLayoutManager(
				getActivity(), LinearLayoutManager.VERTICAL, false);
		mProductsRecyclerView.setLayoutManager(layoutManager);
		mProductsRecyclerView.setAdapter(mAdapter);
		mAdapter.setViewMode(ViewType.LIST);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getComponent(ApplicationComponent.class).inject(this);
	}

	@Override
	public void onStart() {
		super.onStart();
		mRecentlyViewedPresenter.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
		mRecentlyViewedPresenter.onResume();
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
		mRecentlyViewedPresenter.onPause();
		autoUnsubBus();
	}

	@Override
	public void onStop() {
		super.onStop();
		mRecentlyViewedPresenter.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mRecentlyViewedPresenter.onDestroy();
		mAdapter.clearData();
	}

	@Override
	public void onDestroyView() {
		mProductsRecyclerView.setAdapter(null);
		super.onDestroyView();
	}

	private void onProductClicked(Result product) {
		mBrowseProductsPresenter.setSelectedProduct(product);
		Intent intent = new Intent(getActivity(), ProductDetailsActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		startActivity(intent);
	}

	@Override
	public void updateRecentItems(Result[] results) {
		if(results != null) {
			List<Result> productList = new ArrayList<>();
			for(Result result:results) {
				productList.add(result);
			}
			mAdapter.addData(productList);
		}
	}
}
