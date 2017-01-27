package com.karcompany.productsearch.events;

import com.karcompany.productsearch.models.Result;
import com.karcompany.productsearch.models.productdetailsresponse.Picture;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * Bus Events
 */

public class BusEvents {

	public static class ProductClicked {
		public Result product;
	}

	public static class ProductImageClickedEvent {

		public Picture productImage;
	}

}
