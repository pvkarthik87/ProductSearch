package com.karcompany.productsearch.views;

import com.karcompany.productsearch.models.productdetailsresponse.ProductDetails;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * View interface which notifies presenter to perform some operations.
 */

public interface ProductImagesView {

	void updateImages(ProductDetails hotel);

}
