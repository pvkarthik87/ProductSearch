package com.karcompany.productsearch.views.activities;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * BaseActivity which all other activities should inherit to simplify DI .
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.karcompany.productsearch.ProductSearchApplication;
import com.karcompany.productsearch.R;
import com.karcompany.productsearch.di.components.ApplicationComponent;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * BaseActivity will be extended by every activity in the app, and it hides
 * common logic for concrete activities, like initial dependency and view injections
 * <p/>
 */
public abstract class BaseActivity extends AppCompatActivity {

	protected boolean isActivityVisible;

	@Nullable
	@Bind(R.id.mainToolbar)
	Toolbar mToolbar;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getApplicationComponent().inject(this);
		injectComponent(getApplicationComponent());
	}

	protected void onResume() {
		super.onResume();
		isActivityVisible = true;
	}

	@Override
	protected void onPause() {
		super.onPause();
		isActivityVisible = false;
	}

	@Override
	public void setContentView(int layoutResID) {
		View view = getLayoutInflater().inflate(layoutResID, null);
		super.setContentView(view);
		bindViews(view);
		configureToolbar();
	}

	/**
	 * Get the Main Application component for dependency injection.
	 *
	 */
	protected ApplicationComponent getApplicationComponent() {
		return ((ProductSearchApplication) getApplication()).getApplicationComponent();
	}

	protected abstract void injectComponent(ApplicationComponent component);

	@Override
	protected void onDestroy() {
		unBindViews();
		super.onDestroy();
	}

	private void bindViews(View view) {
		ButterKnife.bind(this, view);
	}

	private void unBindViews() {
		ButterKnife.unbind(this);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
	}

	private void configureToolbar() {
		if (mToolbar != null) {
			setSupportActionBar(mToolbar);
			getSupportActionBar().setDisplayHomeAsUpEnabled(true);
			getSupportActionBar().setDisplayShowHomeEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home)
			finish();
		return super.onOptionsItemSelected(item);
	}
}
