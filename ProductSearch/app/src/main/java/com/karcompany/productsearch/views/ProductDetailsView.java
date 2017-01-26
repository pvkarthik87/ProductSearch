package com.karcompany.productsearch.views;

import com.karcompany.productsearch.models.Result;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * View interface which notifies presenter to perform some operations.
 */

public interface ProductDetailsView {

	void updateProductDetails(Result product);

}
