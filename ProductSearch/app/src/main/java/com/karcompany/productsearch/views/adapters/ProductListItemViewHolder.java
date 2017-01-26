package com.karcompany.productsearch.views.adapters;

/**
 * Created by pvkarthik on 2017-01-23.
 *
 * View holder.
 */

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.karcompany.productsearch.R;

public class ProductListItemViewHolder extends RecyclerView.ViewHolder {

	public TextView titleTxtView;
	public ImageView imageImgView;
	public TextView priceTxtView;

	public ProductListItemViewHolder(View itemView) {
		super(itemView);
		titleTxtView = (TextView) itemView.findViewById(R.id.name);
		imageImgView = (ImageView) itemView.findViewById(R.id.image);
		priceTxtView = (TextView) itemView.findViewById(R.id.price);
	}

}
