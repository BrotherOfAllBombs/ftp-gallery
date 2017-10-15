package com.brother.of.all.bombs.ftpimageclient.gallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

    private final Context context;
    private final List<String> data;

    public GalleryAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
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
                .resize(50, 50)
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
