package com.karcompany.productsearch.views.adapters;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * Recycler view adapter which displays hotel image data.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.karcompany.productsearch.ProductSearchApplication;
import com.karcompany.productsearch.R;
import com.karcompany.productsearch.events.BusEvents;
import com.karcompany.productsearch.events.RxBus;
import com.karcompany.productsearch.models.productdetailsresponse.Picture;
import com.karcompany.productsearch.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProductImagesAdapter extends RecyclerView.Adapter<ProductImageListItemViewHolder> {

	private List<Picture> mImageList;
	private boolean mIsFullScreen;

	@Inject
	RxBus mEventBus;

	private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			int itemPosition = (Integer) view.getTag();
			Picture pImage = mImageList.get(itemPosition);
			BusEvents.ProductImageClickedEvent event = new BusEvents.ProductImageClickedEvent();
			event.productImage = pImage;
			mEventBus.send(event);
		}
	};

	public ProductImagesAdapter(Fragment fragment) {
		ProductSearchApplication.getApplicationComponent().inject(this);
		mImageList = new ArrayList<>(4);
	}

	@Override
	public ProductImageListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = null;
		if(!mIsFullScreen) {
			view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product_image_row_item, parent, false);
		} else {
			view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_product_image_row_item_fullscreen, parent, false);
		}
		return new ProductImageListItemViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ProductImageListItemViewHolder holder, int position) {
		Glide.clear(holder.productImgview);
		holder.productImgview.setImageDrawable(null);
		if(position < mImageList.size()) {
			Picture pImage = mImageList.get(position);
			if(pImage != null) {
				GlideUtils.loadImage(holder.itemView.getContext(), pImage.getUrl(), holder.productImgview);
			}
			holder.itemView.setTag(position);
			holder.itemView.setOnClickListener(mOnClickListener);
		}
	}

	@Override
	public void onViewRecycled(ProductImageListItemViewHolder holder) {
		Glide.clear(holder.productImgview);
		holder.productImgview.setImageDrawable(null);
		super.onViewRecycled(holder);
	}

	@Override
	public int getItemCount() {
		return mImageList.size();
	}

	public void addImages(List<Picture> hotelImages) {
		clearData();
		if(hotelImages != null) {
			mImageList.addAll(hotelImages);
		}
		notifyDataSetChanged();
	}

	public void clearData() {
		mImageList.clear();
	}

	public void setFullScreenMode(boolean mode) {
		mIsFullScreen = mode;
	}
}
