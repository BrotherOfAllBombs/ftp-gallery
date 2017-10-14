package com.brother.of.all.bombs.ftpimageclient.gallery;

import com.brother.of.all.bombs.ftpimageclient.rx.ISchedulerProvider;
import com.brother.of.all.bombs.ftpimageclient.usecases.ILoadImagesUseCase;

import java.util.List;

import javax.inject.Inject;

import easymvp.AbstractPresenter;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;

/**
 *
 */

public class GalleryPresenter extends AbstractPresenter<GalleryPresenter.GalleryView> {

    private ISchedulerProvider schedulers;

    private final ILoadImagesUseCase loadImagesUseCase;
    private CompositeDisposable disposable;

    @Inject
    public GalleryPresenter(ISchedulerProvider schedulers, ILoadImagesUseCase loadImagesUseCase) {
        this.schedulers = schedulers;
        this.loadImagesUseCase = loadImagesUseCase;
    }

    @Override
    public void onViewAttached(GalleryView view) {
        super.onViewAttached(view);
        disposable = new CompositeDisposable();
        DisposableSingleObserver<List<String>> namesObserver = new DisposableSingleObserver<List<String>>() {
            @Override
            public void onSuccess(List<String> fileNames) {
                getView().setImages(fileNames);
            }

            @Override
            public void onError(Throwable e) {

            }
        };
        disposable.add(namesObserver);
        loadImagesUseCase.requestImageNames()
                .subscribeOn(schedulers.getBackgroundThread())
                .observeOn(schedulers.getMainThread())
                .subscribe(namesObserver);
    }

    interface GalleryView {
        void setImages(List<String> names);
    }
}
