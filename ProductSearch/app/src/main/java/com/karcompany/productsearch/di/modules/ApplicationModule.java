package com.karcompany.productsearch.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.karcompany.productsearch.ProductSearchApplication;
import com.karcompany.productsearch.config.AppConfig;
import com.karcompany.productsearch.events.RxBus;
import com.karcompany.productsearch.networking.ApiRepo;
import com.karcompany.productsearch.presenters.BrowseProductsPresenter;
import com.karcompany.productsearch.presenters.BrowseProductsPresenterImpl;
import com.karcompany.productsearch.presenters.ProductDetailsPresenterImpl;
import com.karcompany.productsearch.presenters.ProductDetailsPresenter;
import com.karcompany.productsearch.presenters.ProductImagesPresenter;
import com.karcompany.productsearch.presenters.ProductImagesPresenterImpl;
import com.karcompany.productsearch.presenters.RecentlyViewedPresenter;
import com.karcompany.productsearch.presenters.RecentlyViewedPresenterImpl;

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
	BrowseProductsPresenter provideBrowseProductsPresenter(ApiRepo apiRepo, AppConfig appConfig) {
		return new BrowseProductsPresenterImpl(apiRepo, appConfig);
	}

	@Provides @Singleton
	RxBus provideRxBus() {
		return new RxBus();
	}

	@Provides @Singleton
	ProductDetailsPresenter provideProductDetailsPresenter(ApiRepo apiRepo, BrowseProductsPresenter browseProductsPresenter) {
		return new ProductDetailsPresenterImpl(apiRepo, browseProductsPresenter);
	}

	@Provides @Singleton
	ProductImagesPresenter provideProductImagesPresenter(ProductDetailsPresenter productDetailsPresenter) {
		return new ProductImagesPresenterImpl(productDetailsPresenter);
	}

	@Provides @Singleton
	SharedPreferences providesSharedPreferences() {
		return PreferenceManager.getDefaultSharedPreferences(this.application);
	}

	@Provides @Singleton
	AppConfig provideAppConfig(SharedPreferences sharedPreferences) {
		return new AppConfig(sharedPreferences);
	}

	@Provides @Singleton
	RecentlyViewedPresenter provideRecentlyViewedPresenter(AppConfig appConfig) {
		return new RecentlyViewedPresenterImpl(appConfig);
	}
}
