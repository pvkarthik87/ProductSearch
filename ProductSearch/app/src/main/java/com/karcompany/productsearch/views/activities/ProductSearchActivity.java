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

public class ProductSearchActivity extends BaseActivity implements HasComponent<ApplicationComponent> {

	private static final String TAG = DefaultLogger.makeLogTag(ProductSearchActivity.class);

	@Inject
	BrowseProductsPresenter mBrowseProductsPresenter;

	@Override
	protected void injectComponent(ApplicationComponent component) {
		component.inject(this);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_search);
		setTitle(getString(R.string.app_name));
		handleIntent(getIntent());
	}

	@Override
	public ApplicationComponent getComponent() {
		return getApplicationComponent();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_browse_images, menu);

		MenuItem searchItem = menu.findItem(R.id.action_search);
		SearchView searchView =
				(SearchView) MenuItemCompat.getActionView(searchItem);
		SearchManager searchManager =
				(SearchManager) getSystemService(Context.SEARCH_SERVICE);
		searchView.setSearchableInfo(
				searchManager.getSearchableInfo(getComponentName()));
		return true;
	}

	@Override
	protected void onNewIntent(Intent intent) {
		handleIntent(intent);
	}

	private void handleIntent(Intent intent) {
		if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
			String query = intent.getStringExtra(SearchManager.QUERY);
			DefaultLogger.d(TAG, "User query "+query);
			mBrowseProductsPresenter.onNewSearchQuery(query);
			//use the query to search your data somehow
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == R.id.action_recent) {
			goToRecentView();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void goToRecentView() {
		Intent intent = new Intent(this, RecentlyViewedActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		startActivity(intent);
	}
}
