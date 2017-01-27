package com.karcompany.productsearch.di.components;

import android.content.Context;

import com.karcompany.productsearch.ProductSearchApplication;
import com.karcompany.productsearch.di.modules.ApplicationModule;
import com.karcompany.productsearch.networking.NetworkModule;
import com.karcompany.productsearch.views.activities.BaseActivity;
import com.karcompany.productsearch.views.activities.ProductSearchActivity;
import com.karcompany.productsearch.views.adapters.BrowseProductsAdapter;
import com.karcompany.productsearch.views.adapters.ProductImagesAdapter;
import com.karcompany.productsearch.views.fragments.BrowseProductsFragment;
import com.karcompany.productsearch.views.fragments.ProductDetailsFragment;
import com.karcompany.productsearch.views.fragments.ProductImagesFragment;
import com.karcompany.productsearch.views.fragments.RecentlyViewedFragment;

import javax.inject.Singleton;

import dagger.Component;


/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

	void inject(ProductSearchApplication productSearchApplication);

	void inject(BaseActivity baseActivity);

	void inject(BrowseProductsAdapter browseProductsAdapter);

	void inject(BrowseProductsFragment browseProductsFragment);

	void inject(ProductSearchActivity productSearchActivity);

	void inject(ProductDetailsFragment productDetailsFragment);

	void inject(ProductImagesAdapter productImagesAdapter);

	void inject(ProductImagesFragment productImagesFragment);

	void inject(RecentlyViewedFragment recentlyViewedFragment);

	//Exposed to sub-graphs.
	Context context();
}
