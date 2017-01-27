package com.karcompany.productsearch.networking;

import com.karcompany.productsearch.config.Constants;
import com.karcompany.productsearch.models.ProductSearchApiResponse;
import com.karcompany.productsearch.models.productdetailsresponse.ProductDetails;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * REST service interface which Retrofit uses to communicate to a rest end point.
 */

public interface RestService {

	@GET("sites/MLU/search?limit="+ Constants.NUM_ITEMS_IN_PAGE)
	Observable<ProductSearchApiResponse> getProducts(@Query("offset") long pageNo, @Query("q") String searchTerm);

	@GET("items/{itemId}")
	Observable<ProductDetails> getProductDetails(@Path("itemId") String itemId);
}