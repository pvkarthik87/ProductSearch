package com.karcompany.productsearch.views;

import com.karcompany.productsearch.models.ProductSearchApiResponse;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * View interface which notifies presenter to perform some operations.
 */

public interface BrowseImagesView {

	void onDataReceived(ProductSearchApiResponse response);

	void onFailure(String errorMsg);

	void onNewSearchQuery(String searchTerm);

}
