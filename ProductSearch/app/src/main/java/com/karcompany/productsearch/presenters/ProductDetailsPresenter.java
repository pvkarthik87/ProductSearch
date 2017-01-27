package com.karcompany.productsearch.presenters;

import com.karcompany.productsearch.models.Result;
import com.karcompany.productsearch.models.productdetailsresponse.ProductDetails;
import com.karcompany.productsearch.mvputils.Presenter;
import com.karcompany.productsearch.views.ProductDetailsView;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * Presenter interface which helps in showing selected product caption.
 *
 */

public interface ProductDetailsPresenter extends Presenter {

	void setView(ProductDetailsView productDetailsView);

	ProductDetails getCurrentProduct();

}
