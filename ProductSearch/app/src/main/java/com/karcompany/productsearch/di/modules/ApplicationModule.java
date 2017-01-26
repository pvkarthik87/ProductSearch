package com.karcompany.productsearch.di.modules;

import android.content.Context;

import com.karcompany.productsearch.ProductSearchApplication;
import com.karcompany.productsearch.events.RxBus;
import com.karcompany.productsearch.networking.ApiRepo;
import com.karcompany.productsearch.presenters.BrowseProductsPresenter;
import com.karcompany.productsearch.presenters.BrowseProductsPresenterImpl;
import com.karcompany.productsearch.presenters.ProductDetailsPresenter;
import com.karcompany.productsearch.presenters.ProductDetailsPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {
	private final ProductSearchApplication application;

	public ApplicationModule(ProductSearchApplication application) {
		this.application = application;
	}

	@Provides @Singleton
	Context provideApplicationContext() {
		return this.application;
	}

	@Provides @Singleton
	BrowseProductsPresenter provideBrowseProductsPresenter(ApiRepo apiRepo) {
		return new BrowseProductsPresenterImpl(apiRepo);
	}

	@Provides @Singleton
	RxBus provideRxBus() {
		return new RxBus();
	}

	@Provides @Singleton
	ProductDetailsPresenter provideProductDetailsPresenter(BrowseProductsPresenter browseProductsPresenter) {
		return new ProductDetailsPresenterImpl(browseProductsPresenter);
	}
}
