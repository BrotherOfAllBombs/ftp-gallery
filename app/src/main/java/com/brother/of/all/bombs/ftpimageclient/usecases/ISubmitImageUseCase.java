package com.brother.of.all.bombs.ftpimageclient.usecases;

import io.reactivex.Single;

/**
 *
 */

public interface ISubmitImageUseCase {
    Single submitImage(String editorFilePath);
}
