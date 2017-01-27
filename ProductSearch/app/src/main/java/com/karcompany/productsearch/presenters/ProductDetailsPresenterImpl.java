package com.karcompany.productsearch.presenters;

import com.karcompany.productsearch.models.ProductSearchApiResponse;
import com.karcompany.productsearch.models.Result;
import com.karcompany.productsearch.models.productdetailsresponse.ProductDetails;
import com.karcompany.productsearch.networking.ApiRepo;
import com.karcompany.productsearch.networking.NetworkError;
import com.karcompany.productsearch.views.ProductDetailsView;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * Presenter implementation which handles core features (shows selected product caption).
 */

public class ProductDetailsPresenterImpl implements ProductDetailsPresenter, ApiRepo.ProductDetailsApiCallback {

	private ProductDetailsView mView;
	private BrowseProductsPresenter mBrowseProductsPresenter;

	@Inject
	ApiRepo mApiRepo;

	private boolean mIsLoading;
	private CompositeSubscription subscriptions;

	private ProductDetails mCurrentProduct;

	@Inject
	public ProductDetailsPresenterImpl(ApiRepo apiRepo, BrowseProductsPresenter browseProductsPresenter) {
		mApiRepo = apiRepo;
		mBrowseProductsPresenter = browseProductsPresenter;
	}

	@Override
	public void setView(ProductDetailsView browseUsersView) {
		mView = browseUsersView;
		subscriptions = new CompositeSubscription();
	}

	@Override
	public void onStart() {
		loadProductDetails();
	}

	@Override
	public void onResume() {

	}

	@Override
	public void onPause() {

	}

	@Override
	public void onStop() {
	}

	@Override
	public void onDestroy() {
		mView = null;
		if(subscriptions != null) {
			subscriptions.unsubscribe();
		}
	}

	private void loadProductDetails() {
		Result product = mBrowseProductsPresenter.getSelectedProduct();
		if(product != null) {
			mIsLoading = true;
			Subscription subscription = mApiRepo.getProductDetails(product.getId(), this);
			subscriptions.add(subscription);
		}
	}

	@Override
	public void onSuccess(ProductDetails response) {
		mIsLoading = false;
		mCurrentProduct = response;
		if (mView != null) {
			mView.updateProductDetails(response);
		}
	}

	@Override
	public void onError(NetworkError networkError) {
		mIsLoading = false;
		if (mView != null) {
			mView.onFailure(networkError.getAppErrorMessage());
		}
	}

	@Override
	public ProductDetails getCurrentProduct() {
		return mCurrentProduct;
	}
}
