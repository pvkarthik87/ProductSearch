package com.karcompany.productsearch.views.activities;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * Initial launch activity which will get displayed on first launch of application.
 */

import android.os.Bundle;

import com.karcompany.productsearch.R;
import com.karcompany.productsearch.di.HasComponent;
import com.karcompany.productsearch.di.components.ApplicationComponent;
import com.karcompany.productsearch.logging.DefaultLogger;

public class RecentlyViewedActivity extends BaseActivity implements HasComponent<ApplicationComponent> {

	private static final String TAG = DefaultLogger.makeLogTag(RecentlyViewedActivity.class);

	@Override
	protected void injectComponent(ApplicationComponent component) {
		component.inject(this);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recently_viewed_products);
		setTitle(getString(R.string.view_history));
	}

	@Override
	public ApplicationComponent getComponent() {
		return getApplicationComponent();
	}

}
