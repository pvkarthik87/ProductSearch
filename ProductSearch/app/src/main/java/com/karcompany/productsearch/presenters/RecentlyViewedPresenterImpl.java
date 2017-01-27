package com.karcompany.productsearch.presenters;

import com.karcompany.productsearch.config.AppConfig;
import com.karcompany.productsearch.models.Result;
import com.karcompany.productsearch.models.productdetailsresponse.ProductDetails;
import com.karcompany.productsearch.views.ProductImagesView;
import com.karcompany.productsearch.views.RecentlyViewedView;

import javax.inject.Inject;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * Presenter implementation which handles core features (show Recently viewed products).
 */

public class RecentlyViewedPresenterImpl implements RecentlyViewedPresenter {

	private RecentlyViewedView mView;
	private AppConfig mAppConfig;

	@Inject
	public RecentlyViewedPresenterImpl(AppConfig appConfig) {
		mAppConfig = appConfig;
	}

	@Override
	public void setView(RecentlyViewedView recentlyViewedView) {
		mView = recentlyViewedView;
	}

	@Override
	public void onStart() {
		loadRecentlyViewed();
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


	private void loadRecentlyViewed() {
		Result[] recentProducts = mAppConfig.getRecentProducts();
		if(recentProducts != null) {
			if(mView != null) {
				mView.updateRecentItems(recentProducts);
			}
		}
	}
}
