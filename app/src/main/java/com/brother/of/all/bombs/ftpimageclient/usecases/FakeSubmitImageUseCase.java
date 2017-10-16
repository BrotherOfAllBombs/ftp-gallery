package com.brother.of.all.bombs.ftpimageclient.usecases;

import io.reactivex.Single;

/**
 *
 */

public class FakeSubmitImageUseCase implements ISubmitImageUseCase {
    @Override
    public Single submitImage(String editorFilePath) {
        return Single.just(true);
    }
}
