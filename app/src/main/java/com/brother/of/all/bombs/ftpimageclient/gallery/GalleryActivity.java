package com.brother.of.all.bombs.ftpimageclient.gallery;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.brother.of.all.bombs.ftpimageclient.MainApplication;
import com.brother.of.all.bombs.ftpimageclient.R;

import java.util.List;

import javax.inject.Inject;

import easymvp.annotation.ActivityView;
import easymvp.annotation.Presenter;

@ActivityView(presenter = GalleryPresenter.class, layout = R.layout.activity_gallery)
public class GalleryActivity extends AppCompatActivity implements GalleryPresenter.GalleryView {

    private static final String TAG = GalleryActivity.class.getName();
    public static final int REQUEST_CODE_GALLERY = 1;
    private static final int REQUEST_CODE_CAMERA = 2;
    @Inject
    @Presenter
    GalleryPresenter presenter;

    private RecyclerView recyclerViewGallery;
    private Button buttonOpenCamera, buttonOpenGallery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((MainApplication)getApplication()).getGalleryComponent().inject(this);
        super.onCreate(savedInstanceState);
        setupRecyclerView();

        buttonOpenGallery = (Button) findViewById(R.id.activity_gallery_buttonOpenGallery);
        buttonOpenCamera = (Button) findViewById(R.id.activity_gallery_buttonOpenCamera);

        buttonOpenGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Choose Picture"), REQUEST_CODE_GALLERY);
            }
        });
    }

    private void setupRecyclerView() {
        recyclerViewGallery = (RecyclerView) findViewById(R.id.activity_gravity_recyclerView);

        recyclerViewGallery.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerViewGallery.setLayoutManager(layoutManager);
    }

    @Override
    public void setImages(List<String> names) {
        recyclerViewGallery.setAdapter(new GalleryAdapter(this, names));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode==RESULT_CANCELED)
        {
            // action cancelled
        }
        if(resultCode==RESULT_OK)
        {
            Uri selectedimg = data.getData();
            Log.d(TAG, selectedimg.toString());
        }
    }
}
