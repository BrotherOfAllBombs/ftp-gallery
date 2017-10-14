package com.brother.of.all.bombs.ftpimageclient.usecases;

import java.util.List;

import io.reactivex.Single;

/**
 *
 */

public interface ILoadImagesUseCase {
    Single<List<String>> requestImageNames();
}
