package com.karcompany.productsearch.views.activities;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * Initial launch activity which will get displayed on first launch of application.
 */

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.karcompany.productsearch.R;
import com.karcompany.productsearch.di.HasComponent;
import com.karcompany.productsearch.di.components.ApplicationComponent;
import com.karcompany.productsearch.logging.DefaultLogger;
import com.karcompany.productsearch.presenters.BrowseProductsPresenter;

import javax.inject.Inject;

public class ProductDetailsActivity extends BaseActivity implements HasComponent<ApplicationComponent> {

	private static final String TAG = DefaultLogger.makeLogTag(ProductDetailsActivity.class);

	@Override
	protected void injectComponent(ApplicationComponent component) {
		component.inject(this);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_details);
		setTitle(getString(R.string.product_details));
	}

	@Override
	public ApplicationComponent getComponent() {
		return getApplicationComponent();
	}

}
