package com.karcompany.productsearch.presenters;

import com.karcompany.productsearch.views.ProductDetailsView;

import javax.inject.Inject;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * Presenter implementation which handles core features (shows selected product caption).
 */

public class ProductDetailsPresenterImpl implements ProductDetailsPresenter {

	private ProductDetailsView mView;
	private BrowseProductsPresenter mBrowseProductsPresenter;

	@Inject
	public ProductDetailsPresenterImpl(BrowseProductsPresenter browseProductsPresenter) {
		mBrowseProductsPresenter = browseProductsPresenter;
	}

	@Override
	public void setView(ProductDetailsView browseUsersView) {
		mView = browseUsersView;
	}

	@Override
	public void onStart() {
		loadImageDetails();
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
	}

	private void loadImageDetails() {
		/*Image selectedImage = mBrowseImagesPresenter.getSelectedProduct();
		if(selectedImage != null) {
			if(mView != null) {
				mView.updateImageDetails(selectedImage);
			}
		}*/
	}
}
