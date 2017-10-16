package com.brother.of.all.bombs.ftpimageclient;

import android.app.Application;

import com.brother.of.all.bombs.ftpimageclient.di.EditorModelModule;
import com.brother.of.all.bombs.ftpimageclient.di.components.AppComponent;
import com.brother.of.all.bombs.ftpimageclient.di.components.DaggerAppComponent;
import com.brother.of.all.bombs.ftpimageclient.di.components.EditorComponent;
import com.brother.of.all.bombs.ftpimageclient.di.components.GalleryComponent;

/**
 *
 */

public class MainApplication extends Application {

    private AppComponent appComponent;
    private GalleryComponent galleryComponent;
    private EditorComponent editorComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupDI();
    }

    private void setupDI() {
        appComponent = DaggerAppComponent.builder()
                .editorModelModule(new EditorModelModule(this))
                .build();
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

    public EditorComponent getEditorComponent() {
        if (editorComponent == null) {
            editorComponent = appComponent.getEditorComponent();
        }
        return editorComponent;
    }
}
