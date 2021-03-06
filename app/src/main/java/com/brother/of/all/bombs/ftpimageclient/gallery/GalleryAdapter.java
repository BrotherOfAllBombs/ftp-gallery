package com.brother.of.all.bombs.ftpimageclient.gallery;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.brother.of.all.bombs.ftpimageclient.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 *
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    public final int IMAGE_SIZE;
    private final Activity context;
    private final List<String> data;

    public GalleryAdapter(Activity activity, List<String> data) {
        this.context = activity;
        this.data = data;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        IMAGE_SIZE = displayMetrics.widthPixels/2;
    }

    @Override
    public GalleryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_activity_gallery, parent, false);
        return new GalleryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GalleryViewHolder holder, int position) {
        Picasso.with(context)
                .load(data.get(position))
                .resize(IMAGE_SIZE, IMAGE_SIZE)
                .centerCrop()
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public GalleryViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_activity_gallery_imageVIew);
        }
    }
}
