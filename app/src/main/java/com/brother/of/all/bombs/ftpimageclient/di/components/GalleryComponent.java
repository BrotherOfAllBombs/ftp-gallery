package com.brother.of.all.bombs.ftpimageclient.di.components;

import com.brother.of.all.bombs.ftpimageclient.di.components.scopes.GalleryScope;
import com.brother.of.all.bombs.ftpimageclient.gallery.GalleryActivity;

import dagger.Component;
import dagger.Subcomponent;

/**
 *
 */
@GalleryScope
@Subcomponent
public interface GalleryComponent {
    void inject(GalleryActivity galleryActivity);
}
