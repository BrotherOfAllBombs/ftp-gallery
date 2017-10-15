package com.brother.of.all.bombs.ftpimageclient.gallery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.brother.of.all.bombs.ftpimageclient.MainApplication;
import com.brother.of.all.bombs.ftpimageclient.R;

import java.util.List;

import javax.inject.Inject;

import easymvp.annotation.ActivityView;
import easymvp.annotation.Presenter;

@ActivityView(presenter = GalleryPresenter.class, layout = R.layout.activity_gallery)
public class GalleryActivity extends AppCompatActivity implements GalleryPresenter.GalleryView {

    @Inject
    @Presenter
    GalleryPresenter presenter;

    private RecyclerView recyclerViewGallery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((MainApplication)getApplication()).getGalleryComponent().inject(this);
        super.onCreate(savedInstanceState);
        recyclerViewGallery = (RecyclerView) findViewById(R.id.activity_gravity_recyclerView);

        recyclerViewGallery.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerViewGallery.setLayoutManager(layoutManager);

    }

    @Override
    public void setImages(List<String> names) {
        recyclerViewGallery.setAdapter(new GalleryAdapter(getApplicationContext(), names));
    }
}
