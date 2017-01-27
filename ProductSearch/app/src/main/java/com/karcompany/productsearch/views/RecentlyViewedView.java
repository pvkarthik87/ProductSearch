package com.karcompany.productsearch.views;

import com.karcompany.productsearch.models.Result;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * View interface which notifies presenter to perform some operations.
 */

public interface RecentlyViewedView {

	void updateRecentItems(Result[] results);

}
