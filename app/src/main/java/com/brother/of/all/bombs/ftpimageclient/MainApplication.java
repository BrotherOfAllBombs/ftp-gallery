package com.brother.of.all.bombs.ftpimageclient;

import android.app.Application;

import com.brother.of.all.bombs.ftpimageclient.di.components.AppComponent;
import com.brother.of.all.bombs.ftpimageclient.di.components.DaggerAppComponent;
import com.brother.of.all.bombs.ftpimageclient.di.components.GalleryComponent;

/**
 *
 */

public class MainApplication extends Application {

    private AppComponent appComponent;
    private GalleryComponent galleryComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDI();
    }

    private void setupDI() {
        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public GalleryComponent getGalleryComponent() {
        if (galleryComponent == null) {
            galleryComponent = appComponent.getGalleryComponent();
        }
        return galleryComponent;
    }
}
