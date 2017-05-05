package com.android.msqhealth.fragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.msqhealth.R;
import com.android.msqhealth.model.Product;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyProductViewAdapter extends RecyclerView.Adapter<MyProductViewAdapter.ViewHolder> {

    private final List<Product> mValues;
    private final Context context;

    public MyProductViewAdapter(List<Product> items, Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_view_products, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        Glide.with(context).load(holder.mItem.getAttributes().getImageUrl()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public ImageView image;
        public Product mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            image = (ImageView) view.findViewById(R.id.image);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + "Content View" +
                    "'";
        }
    }
}
