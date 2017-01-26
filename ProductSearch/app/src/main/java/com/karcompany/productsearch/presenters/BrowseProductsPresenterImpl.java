package com.karcompany.productsearch.presenters;

import com.karcompany.productsearch.models.ProductSearchApiResponse;
import com.karcompany.productsearch.models.Result;
import com.karcompany.productsearch.networking.ApiRepo;
import com.karcompany.productsearch.networking.NetworkError;
import com.karcompany.productsearch.views.BrowseImagesView;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * Presenter implementation which handles core features (fetches images from server).
 */

public class BrowseProductsPresenterImpl implements BrowseProductsPresenter, ApiRepo.GetImagesApiCallback {

	private BrowseImagesView mView;

	@Inject
	ApiRepo mApiRepo;

	private boolean mIsLoading;
	private CompositeSubscription subscriptions;

	private Result mSelectedProduct;

	@Inject
	public BrowseProductsPresenterImpl(ApiRepo apiRepo) {
		mApiRepo = apiRepo;
	}

	@Override
	public void setView(BrowseImagesView browseUsersView) {
		mView = browseUsersView;
		subscriptions = new CompositeSubscription();
	}

	@Override
	public void onStart() {

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

	@Override
	public void loadImages(long pageNo, String searchTerm) {
		mIsLoading = true;
		Subscription subscription = mApiRepo.getProducts(pageNo, searchTerm, this);
		subscriptions.add(subscription);
	}

	@Override
	public void onSuccess(ProductSearchApiResponse response) {
		mIsLoading = false;
		if (mView != null) {
			mView.onDataReceived(response);
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
	public boolean isLoading() {
		return mIsLoading;
	}

	@Override
	public void onNewSearchQuery(String searchTerm) {
		if(mView != null) {
			mView.onNewSearchQuery(searchTerm);
		}
	}

	@Override
	public void setSelectedProduct(Result product) {
		mSelectedProduct = product;
	}

	@Override
	public Result getSelectedProduct() {
		return mSelectedProduct;
	}
}
