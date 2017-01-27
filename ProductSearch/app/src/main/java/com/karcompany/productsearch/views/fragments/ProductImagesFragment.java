package com.karcompany.productsearch.views.fragments;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * displays product images in fullscreen mode.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.karcompany.productsearch.R;
import com.karcompany.productsearch.di.components.ApplicationComponent;
import com.karcompany.productsearch.events.BusEvents;
import com.karcompany.productsearch.events.RxBus;
import com.karcompany.productsearch.logging.DefaultLogger;
import com.karcompany.productsearch.models.productdetailsresponse.Picture;
import com.karcompany.productsearch.models.productdetailsresponse.ProductDetails;
import com.karcompany.productsearch.presenters.ProductImagesPresenter;
import com.karcompany.productsearch.views.ProductImagesView;
import com.karcompany.productsearch.views.adapters.ProductImagesAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class ProductImagesFragment extends BaseFragment implements ProductImagesView {

	private static final String TAG = DefaultLogger.makeLogTag(ProductImagesFragment.class);

	@Inject
	ProductImagesPresenter mProductImagesPresenter;

	@Bind(R.id.product_image_list)
	RecyclerView mHotelImagesRecyclerView;

	private ProductImagesAdapter mAdapter;

	@Inject
	RxBus mEventBus;

	private Subscription mBusSubscription;

	private LinearLayoutManager mLayoutManager;
	private ProductDetails mCurrentHotel;

	@Bind(R.id.hotelImagesView)
	RelativeLayout mHotelImagesLyt;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_product_images, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setUpUI(savedInstanceState);
	}

	private void setUpUI(Bundle savedInstanceState) {
		setUpPresenter();
		setUpRecyclerView();
	}

	private void setUpPresenter() {
		mProductImagesPresenter.setView(this);
	}

	private void setUpRecyclerView() {
		mLayoutManager = new LinearLayoutManager(
				getActivity(), LinearLayoutManager.HORIZONTAL, false);
		mHotelImagesRecyclerView.setLayoutManager(mLayoutManager);
		mAdapter = new ProductImagesAdapter(this);
		mAdapter.setFullScreenMode(true);
		mHotelImagesRecyclerView.setAdapter(mAdapter);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getComponent(ApplicationComponent.class).inject(this);
	}

	@Override
	public void onStart() {
		super.onStart();
		mProductImagesPresenter.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
		mProductImagesPresenter.onResume();
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
		if (o instanceof BusEvents.ProductImageClickedEvent) {
			onHotelImageClicked();
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		mProductImagesPresenter.onPause();
		autoUnsubBus();
	}

	@Override
	public void onStop() {
		super.onStop();
		mProductImagesPresenter.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mProductImagesPresenter.onDestroy();
		mAdapter.clearData();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}

	@Override
	public void updateImages(ProductDetails hotel) {
		if(hotel != null) {
			mCurrentHotel = hotel;
			List<Picture> hotelImages = hotel.getPictures();
			mAdapter.addImages(hotelImages);
		}
	}

	@OnClick(R.id.fullScreenBtn)
	public void onFullScreenBtnClicked() {
		onHotelImageClicked();
	}

	private void onHotelImageClicked() {
		getActivity().finish();
	}
}
