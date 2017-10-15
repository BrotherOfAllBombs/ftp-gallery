package com.brother.of.all.bombs.ftpimageclient.di.components;

import com.brother.of.all.bombs.ftpimageclient.di.SchedulerModule;
import com.brother.of.all.bombs.ftpimageclient.di.UseCasesModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 */
@Singleton
@Component(modules = {SchedulerModule.class, UseCasesModule.class})
public interface AppComponent {
    GalleryComponent getGalleryComponent();
}
