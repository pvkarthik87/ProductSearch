package com.karcompany.productsearch;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * Android Application.
 */

import android.app.Application;

import com.karcompany.productsearch.di.components.ApplicationComponent;
import com.karcompany.productsearch.di.components.DaggerApplicationComponent;
import com.karcompany.productsearch.di.modules.ApplicationModule;
import com.karcompany.productsearch.networking.NetworkModule;


public class ProductSearchApplication extends Application {

	private static ApplicationComponent applicationComponent;

	@Override
	public void onCreate() {
		super.onCreate();
		initializeInjector();
	}

	private void initializeInjector() {
		applicationComponent = DaggerApplicationComponent.builder()
				.applicationModule(new ApplicationModule(this))
				.networkModule(new NetworkModule(this))
				.build();
		applicationComponent.inject(this);
	}

	public static ApplicationComponent getApplicationComponent() {
		return applicationComponent;
	}
}

