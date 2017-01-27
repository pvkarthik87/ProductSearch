package com.karcompany.productsearch.views.adapters;

/**
 * Created by pvkarthik on 2017-01-26.
 *
 * View holder.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.karcompany.productsearch.R;

public class ProductImageListItemViewHolder extends RecyclerView.ViewHolder {

	public ImageView productImgview;

	public ProductImageListItemViewHolder(View itemView) {
		super(itemView);
		productImgview = (ImageView) itemView.findViewById(R.id.productImage);
	}

}
