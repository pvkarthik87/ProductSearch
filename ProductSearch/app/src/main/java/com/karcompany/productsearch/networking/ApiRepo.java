package com.karcompany.productsearch.networking;

import com.karcompany.productsearch.logging.DefaultLogger;
import com.karcompany.productsearch.models.ProductSearchApiResponse;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * REST Client which communicates to server to perform some operations
 */

public class ApiRepo {

	private static final String TAG = DefaultLogger.makeLogTag(ApiRepo.class);

	public interface GetImagesApiCallback {
		void onSuccess(ProductSearchApiResponse response);

		void onError(NetworkError networkError);
	}

	private final RestService mRestService;

	public ApiRepo(RestService restService) {
		this.mRestService = restService;
	}

	/*
	    Retrives images from server
	 */
	public Subscription getProducts(long pageNo, String searchTerm, final GetImagesApiCallback callback) {
		return mRestService.getProducts(pageNo, searchTerm)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribeOn(Schedulers.newThread())
				.onErrorResumeNext(new Func1<Throwable, Observable<? extends ProductSearchApiResponse>>() {
					@Override
					public Observable<? extends ProductSearchApiResponse> call(Throwable throwable) {
						return Observable.error(throwable);
					}
				})
				.subscribe(new Subscriber<ProductSearchApiResponse>() {
					@Override
					public void onCompleted() {
						DefaultLogger.d(TAG, "onCompleted");
					}

					@Override
					public void onError(Throwable e) {
						NetworkError ne = new NetworkError(e);
						callback.onError(ne);
						DefaultLogger.d(TAG, "onError "+ne.getAppErrorMessage());
					}

					@Override
					public void onNext(ProductSearchApiResponse response) {
						DefaultLogger.d(TAG, "onNext");
						callback.onSuccess(response);
					}
				});
	}

}
