package com.brother.of.all.bombs.ftpimageclient.di;

import com.brother.of.all.bombs.ftpimageclient.usecases.FakeSubmitImageUseCase;
import com.brother.of.all.bombs.ftpimageclient.usecases.ILoadImagesUseCase;
import com.brother.of.all.bombs.ftpimageclient.usecases.FakeLoadImagesUseCase;
import com.brother.of.all.bombs.ftpimageclient.usecases.ISubmitImageUseCase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module
public class UseCasesModule {
    @Provides
    @Singleton
    ILoadImagesUseCase getLoadImagesUseCase() {
        return new FakeLoadImagesUseCase();
    }

    @Provides
    @Singleton
    ISubmitImageUseCase getSubmitImageUseCase() {
        return new FakeSubmitImageUseCase();
    }
}
