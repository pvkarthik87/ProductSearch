package com.karcompany.productsearch.presenters;

import com.karcompany.productsearch.models.productdetailsresponse.ProductDetails;
import com.karcompany.productsearch.views.ProductImagesView;

import javax.inject.Inject;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * Presenter implementation which handles core features (Fullscreen images).
 */

public class ProductImagesPresenterImpl implements ProductImagesPresenter {

	private ProductImagesView mView;
	private ProductDetailsPresenter mProductDetailsPresenter;

	@Inject
	public ProductImagesPresenterImpl(ProductDetailsPresenter productDetailsPresenter) {
		mProductDetailsPresenter = productDetailsPresenter;
	}

	@Override
	public void setView(ProductImagesView hotelImageView) {
		mView = hotelImageView;
	}

	@Override
	public void onStart() {
		loadImages();
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


	private void loadImages() {
		ProductDetails hotel = mProductDetailsPresenter.getCurrentProduct();
		if(hotel != null) {
			if(mView != null) {
				mView.updateImages(hotel);
			}
		}
	}
}
