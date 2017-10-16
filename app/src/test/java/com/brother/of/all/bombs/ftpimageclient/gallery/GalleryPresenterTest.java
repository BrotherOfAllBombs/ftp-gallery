package com.brother.of.all.bombs.ftpimageclient.gallery;

import com.brother.of.all.bombs.ftpimageclient.TestSchedulerProvider;
import com.brother.of.all.bombs.ftpimageclient.rx.ISchedulerProvider;
import com.brother.of.all.bombs.ftpimageclient.usecases.ILoadImagesUseCase;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 */
public class GalleryPresenterTest {
    @Test
    public void testGalleryLoadsDataOnStartup() throws Exception {
        //PREPARE
        GalleryPresenter.GalleryView view = mock(GalleryPresenter.GalleryView.class);

        ILoadImagesUseCase loadImagesUseCase = mock(ILoadImagesUseCase.class);
        when(loadImagesUseCase.requestImageNames()).thenReturn(Single.<List<String>>just(new ArrayList<String>()));

        GalleryPresenter presenter = new GalleryPresenter(getSchedulerProvider(), loadImagesUseCase);

        //PERFORM
        presenter.onViewAttached(view);

        //CHECK
        verify(loadImagesUseCase).requestImageNames();
    }

    @Test
    public void testImageNamesArePassedToView() throws Exception {
        //PREPARE
        GalleryPresenter.GalleryView view = mock(GalleryPresenter.GalleryView.class);

        List<String> names = getImageNames();

        ILoadImagesUseCase loadImagesUseCase = mock(ILoadImagesUseCase.class);
        when(loadImagesUseCase.requestImageNames()).thenReturn(Single.just(names));

        GalleryPresenter presenter = new GalleryPresenter(getSchedulerProvider(), loadImagesUseCase);

        //PERFORM
        presenter.onViewAttached(view);

        //CHECK
        verify(view).setImages(names);
    }

    private List<String> getImageNames() {
        List<String> result = new ArrayList<>();
        result.add("File name 1");
        result.add("File name 2");
        return result;
    }

    private ISchedulerProvider getSchedulerProvider() {
        return new TestSchedulerProvider();
    }
}