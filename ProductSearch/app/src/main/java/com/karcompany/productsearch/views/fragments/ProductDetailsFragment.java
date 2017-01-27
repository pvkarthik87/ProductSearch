package com.karcompany.productsearch.views.fragments;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * Displays detailed info about a product.
 */

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.karcompany.productsearch.R;
import com.karcompany.productsearch.di.components.ApplicationComponent;
import com.karcompany.productsearch.events.BusEvents;
import com.karcompany.productsearch.events.RxBus;
import com.karcompany.productsearch.logging.DefaultLogger;
import com.karcompany.productsearch.models.productdetailsresponse.Picture;
import com.karcompany.productsearch.models.productdetailsresponse.ProductDetails;
import com.karcompany.productsearch.models.productdetailsresponse.SellerAddress;
import com.karcompany.productsearch.presenters.ProductDetailsPresenter;
import com.karcompany.productsearch.views.ProductDetailsView;
import com.karcompany.productsearch.views.activities.ImageFullScreenActivity;
import com.karcompany.productsearch.views.adapters.ProductImagesAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class ProductDetailsFragment extends BaseFragment implements ProductDetailsView {

	private static final String TAG = DefaultLogger.makeLogTag(ProductDetailsFragment.class);

	@Inject
	ProductDetailsPresenter mHotelDetailsPresenter;

	@Bind(R.id.currentPrice)
	TextView mHotelLowPriceView;

	@Bind(R.id.actualPrice)
	TextView mHotelHighPriceView;

	@Bind(R.id.productName)
	TextView mHotelNameView;

	@Bind(R.id.productAddress)
	TextView mHotelAddressView;

	@Inject
	RxBus mEventBus;

	private Subscription mBusSubscription;

	@Bind(R.id.productImagesLyt)
	RelativeLayout mHotelImagesLyt;

	@Bind(R.id.productDetailsLyt)
	LinearLayout mHotelDetailsLyt;

	@Bind(R.id.product_image_list)
	RecyclerView mHotelImagesRecyclerView;

	private ProductImagesAdapter mAdapter;

	private LinearLayoutManager mLayoutManager;

	@Bind(R.id.priceBar)
	View mHotelPriceBar;

	private ProductDetails mCurrentHotel;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_product_details, container, false);
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
		mHotelDetailsPresenter.setView(this);
	}

	private void setUpRecyclerView() {
		mLayoutManager = new LinearLayoutManager(
				getActivity(), LinearLayoutManager.HORIZONTAL, false);
		mHotelImagesRecyclerView.setLayoutManager(mLayoutManager);
		mAdapter = new ProductImagesAdapter(this);
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
		mHotelDetailsPresenter.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
		mHotelDetailsPresenter.onResume();
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
			BusEvents.ProductImageClickedEvent event = (BusEvents.ProductImageClickedEvent) o;
			onHotelImageClicked(event.productImage);
		}
	}

	@Override
	public void onPause() {
		super.onPause();
		mHotelDetailsPresenter.onPause();
		autoUnsubBus();
	}

	@Override
	public void onStop() {
		super.onStop();
		mHotelDetailsPresenter.onStop();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mHotelDetailsPresenter.onDestroy();
		mAdapter.clearData();
	}

	@Override
	public void onDestroyView() {
		mHotelImagesRecyclerView.setAdapter(null);
		super.onDestroyView();
	}

	@Override
	public void updateProductDetails(ProductDetails productDetails) {
		if(productDetails != null) {
			mCurrentHotel = productDetails;
			if(!TextUtils.isEmpty(productDetails.getTitle())) {
				mHotelNameView.setText(productDetails.getTitle());
			}
			mHotelLowPriceView.setText(""+productDetails.getPrice());
			mHotelHighPriceView.setText(""+productDetails.getBasePrice());
			mHotelHighPriceView.setPaintFlags(mHotelHighPriceView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
			SellerAddress location = productDetails.getSellerAddress();
			if(location != null) {
				if(!TextUtils.isEmpty(location.getCity().getName())) {
					mHotelAddressView.setText(location.getCity().getName());
				}
			}
			List<Picture> hotelImages = productDetails.getPictures();
			mAdapter.addImages(hotelImages);
		}
	}

	@Override
	public void onFailure(String errorMsg) {

	}

	@OnClick(R.id.mapView)
	public void onMapViewClicked() {
		if(mCurrentHotel != null) {
			// Seller location
		}
	}

	private void onHotelImageClicked(Picture hotelImage) {
		Intent intent = new Intent(getActivity(), ImageFullScreenActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		startActivity(intent);
	}

	@OnClick(R.id.fullScreenBtn)
	public void onFullScreenBtnClicked() {
		if(mCurrentHotel != null) {
			int clickedImagePos = mLayoutManager.findFirstVisibleItemPosition();
			List<Picture> hotelImages = mCurrentHotel.getPictures();
			if(hotelImages != null && clickedImagePos < hotelImages.size()) {
				Picture hotelImage = hotelImages.get(clickedImagePos);
				BusEvents.ProductImageClickedEvent event =  new BusEvents.ProductImageClickedEvent();
				event.productImage = hotelImage;
				mEventBus.send(event);
			}
		}
	}
}
