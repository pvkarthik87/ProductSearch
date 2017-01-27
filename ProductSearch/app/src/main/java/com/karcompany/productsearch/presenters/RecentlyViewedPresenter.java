package com.karcompany.productsearch.presenters;

import com.karcompany.productsearch.mvputils.Presenter;
import com.karcompany.productsearch.views.ProductImagesView;
import com.karcompany.productsearch.views.RecentlyViewedView;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * Presenter interface.
 *
 */

public interface RecentlyViewedPresenter extends Presenter {

	void setView(RecentlyViewedView recentlyViewedView);

}
