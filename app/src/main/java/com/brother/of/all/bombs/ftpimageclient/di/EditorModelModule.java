package com.brother.of.all.bombs.ftpimageclient.di;

import android.content.Context;

import com.brother.of.all.bombs.ftpimageclient.model.EditorFileModel;
import com.brother.of.all.bombs.ftpimageclient.model.IEditorFileModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class EditorModelModule {

    private Context context;

    public EditorModelModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    IEditorFileModel getEditorFileModel() {
        return new EditorFileModel(context);
    }
}
