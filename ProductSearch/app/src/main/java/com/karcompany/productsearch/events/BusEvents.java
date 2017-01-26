package com.karcompany.productsearch.events;

import com.karcompany.productsearch.models.Result;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * Bus Events
 */

public class BusEvents {

	public static class ProductClicked {
		public Result product;
	}

}
