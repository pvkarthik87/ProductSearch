package com.karcompany.productsearch.config;

import android.content.SharedPreferences;
import android.text.TextUtils;

import com.karcompany.productsearch.models.Result;
import com.karcompany.productsearch.utils.json.JSONParser;

import java.util.ArrayList;
import java.util.List;

import static com.karcompany.productsearch.config.Constants.MAX_RECENT_ITEMS;

/**
 * Created by pvkarthik on 2017-01-26.
 */

public class AppConfig {

	private SharedPreferences mSharedPreferences;

	public AppConfig(SharedPreferences sharedPreferences) {
		mSharedPreferences = sharedPreferences;
	}

	public Result[] getRecentProducts() {
		String recentJson =  mSharedPreferences.getString(Constants.KEY_RECENT_VIEWED, "");
		if(!TextUtils.isEmpty(recentJson)) {
			return JSONParser.parse(recentJson, Result[].class);
		}
		return null;
	}

	public void addToRecent(Result product) {
		String recentJson =  mSharedPreferences.getString(Constants.KEY_RECENT_VIEWED, "");
		List<Result> productList = new ArrayList<>();
		if(!TextUtils.isEmpty(recentJson)) {
			Result[] products = JSONParser.parse(recentJson, Result[].class);
			for(Result result:products) {
				productList.add(result);
			}
			int index = productList.indexOf(product);
			if(index >= 0) {
				productList.remove(index);
				productList.add(0, product);
			} else {
				productList.add(0, product);
			}
			while(productList.size() > MAX_RECENT_ITEMS) {
				productList.remove(MAX_RECENT_ITEMS);
			}
		} else {
			productList.add(product);
		}
		mSharedPreferences.edit().putString(Constants.KEY_RECENT_VIEWED, JSONParser.toJSON(productList)).apply();
	}
}
