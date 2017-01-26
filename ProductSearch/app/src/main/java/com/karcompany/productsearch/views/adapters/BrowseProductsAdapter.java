package com.karcompany.productsearch.views.adapters;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * Recycler view adapter which displays product list data.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.karcompany.productsearch.ProductSearchApplication;
import com.karcompany.productsearch.R;
import com.karcompany.productsearch.config.Constants;
import com.karcompany.productsearch.config.ViewType;
import com.karcompany.productsearch.events.BusEvents;
import com.karcompany.productsearch.events.RxBus;
import com.karcompany.productsearch.models.ProductSearchApiResponse;
import com.karcompany.productsearch.models.Result;
import com.karcompany.productsearch.presenters.BrowseProductsPresenter;
import com.karcompany.productsearch.utils.GlideUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.inject.Inject;

public class BrowseProductsAdapter extends RecyclerView.Adapter<ProductListItemViewHolder> {

	private Fragment mFragment;
	private Context mContext;
	private Map<String, Result> mProductsDataMap;
	private List<String> mProductIdList;
	private ViewType mCurrentViewType;
	private Random mRandom = new Random();

	private long mTotalListCount = 0;
	private String mSearchTerm;

	@Inject
	RxBus mEventBus;

	@Inject
	BrowseProductsPresenter mBrowseProductsPresenter;

	private int VIEW_TYPE_ITEM = 1;
	private int VIEW_TYPE_PROGRESS = 2;

	private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			int itemPosition = (Integer) view.getTag();
			String id = mProductIdList.get(itemPosition);
			BusEvents.ProductClicked event =  new BusEvents.ProductClicked();
			event.product = mProductsDataMap.get(id);
			mEventBus.send(event);
		}
	};

	public BrowseProductsAdapter(Fragment fragment) {
		ProductSearchApplication.getApplicationComponent().inject(this);
		mFragment = fragment;
		mContext = fragment.getContext();
		mProductsDataMap = new LinkedHashMap<>();
		mProductIdList = new ArrayList<>(4);
	}

	@Override
	public ProductListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = null;
		if(viewType == VIEW_TYPE_ITEM) {
			switch (mCurrentViewType) {
				case LIST: {
					view = LayoutInflater.from(mContext).inflate(R.layout.view_image_row_item_list, parent, false);
				}
				break;

				case GRID: {
					view = LayoutInflater.from(mContext).inflate(R.layout.view_image_row_item_grid, parent, false);
				}
				break;

				case STAGGERED: {
					view = LayoutInflater.from(mContext).inflate(R.layout.view_image_row_item_staggered, parent, false);
				}
				break;
			}
		} else {
			view = LayoutInflater.from(mContext).inflate(R.layout.loading_progress, parent, false);
		}
		return new ProductListItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ProductListItemViewHolder holder, int position) {
		if(getItemViewType(position) == VIEW_TYPE_ITEM) {
			if (mCurrentViewType == ViewType.STAGGERED) {
				holder.imageImgView.getLayoutParams().height = getRandomIntInRange(300, 200);
			}
			holder.titleTxtView.setText("");
			holder.priceTxtView.setText("");
			Glide.clear(holder.imageImgView);
			holder.imageImgView.setImageDrawable(null);
			if (position < mProductIdList.size()) {
				Result product = mProductsDataMap.get(mProductIdList.get(position));
				if (product != null) {
					if (!TextUtils.isEmpty(product.getTitle())) {
						holder.titleTxtView.setText(product.getTitle());
					}
					holder.priceTxtView.setText(String.format(Locale.getDefault(), "%.2f", product.getPrice()));
					GlideUtils.loadImage(mFragment, product.getThumbnail(), holder.imageImgView);
				}
				holder.itemView.setTag(position);
				holder.itemView.setOnClickListener(mOnClickListener);
			}
		}
	}

	// Custom method to get a random number between a range
	private int getRandomIntInRange(int max, int min){
		return mRandom.nextInt((max-min)+min)+min;
	}

	@Override
	public void onViewRecycled(ProductListItemViewHolder holder) {
		if(holder.imageImgView != null) {
			Glide.clear(holder.imageImgView);
			holder.imageImgView.setImageDrawable(null);
		}
		super.onViewRecycled(holder);
	}

	@Override
	public int getItemCount() {
		if(isDataLoadCompleted()) {
			return mProductIdList.size();
		} else {
			return mProductIdList.size() + 1;
		}
	}

	public void clearData() {
		mProductIdList.clear();
		mProductsDataMap.clear();
	}

	public void setViewMode(ViewType viewType) {
		mCurrentViewType = viewType;
	}

	public ArrayList<Result> getImageList() {
		ArrayList<Result> imageList = new ArrayList<>();
		Iterator<Map.Entry<String, Result>> iterator = mProductsDataMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Result> entry = iterator.next();
			imageList.add(entry.getValue());
		}
		return imageList;
	}

	public void loadData(String searchTerm) {
		if(!TextUtils.isEmpty(searchTerm)) {
			clearData();
			mTotalListCount = -1;
			mSearchTerm = searchTerm;
			notifyDataSetChanged();
			loadMore();
		}
	}

	public void addData(ProductSearchApiResponse response) {
		if(response != null) {
			mTotalListCount = response.getPaging().getTotal();
			if(response.getResults() != null) {
				int oldSize = mProductIdList.size();
				for (Result image : response.getResults()) {
					mProductsDataMap.put(image.getId(), image);
					mProductIdList.add(image.getId());
				}
				int newSize = mProductIdList.size();
				if (oldSize > 0) {
					notifyItemRangeInserted(oldSize, newSize - oldSize);
					if(newSize >= mTotalListCount) {
						notifyItemRemoved(mProductIdList.size());
					}
				} else {
					notifyDataSetChanged();
				}

			}
		}
	}

	public void addData(ArrayList<Result> imageList) {

	}

	private long getNextPageNumber() {
		return (mProductIdList.size() / Constants.NUM_ITEMS_IN_PAGE);
	}

	private boolean isDataLoadCompleted() {
		if(mTotalListCount == -1) return false;
		return mProductIdList.size() >= mTotalListCount;
	}

	public void loadMore() {
		if(!isDataLoadCompleted()) {
			mBrowseProductsPresenter.loadImages(getNextPageNumber(), mSearchTerm);
		}
	}

	@Override
	public int getItemViewType(int position) {
		if(mTotalListCount == -1 && position == 0)
			return VIEW_TYPE_PROGRESS;
		if(mTotalListCount > mProductIdList.size() && position == mProductIdList.size()){
			return VIEW_TYPE_PROGRESS;
		}
		return VIEW_TYPE_ITEM;
	}

	public boolean isLoadingPos(int position) {
		return getItemViewType(position) == VIEW_TYPE_PROGRESS;
	}
}
