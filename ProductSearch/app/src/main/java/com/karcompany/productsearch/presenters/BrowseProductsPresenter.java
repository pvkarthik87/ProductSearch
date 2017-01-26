package com.karcompany.productsearch.presenters;

import com.karcompany.productsearch.models.Result;
import com.karcompany.productsearch.mvputils.Presenter;
import com.karcompany.productsearch.views.BrowseImagesView;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * Presenter interface which helps in getting images from server.
 *
 */

public interface BrowseProductsPresenter extends Presenter {

	void setView(BrowseImagesView browseImagesView);

	void loadImages(long pageNo, String searchTerm);

	boolean isLoading();

	void onNewSearchQuery(String searchTerm);

	Result getSelectedProduct();

	void setSelectedProduct(Result product);

}
