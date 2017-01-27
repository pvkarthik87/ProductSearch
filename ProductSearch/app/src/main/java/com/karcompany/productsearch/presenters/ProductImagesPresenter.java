package com.karcompany.productsearch.presenters;

import com.karcompany.productsearch.mvputils.Presenter;
import com.karcompany.productsearch.views.ProductImagesView;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * Presenter interface.
 *
 */

public interface ProductImagesPresenter extends Presenter {

	void setView(ProductImagesView productImagesView);

}
