package com.brother.of.all.bombs.ftpimageclient.editor;

import com.brother.of.all.bombs.ftpimageclient.TestSchedulerProvider;
import com.brother.of.all.bombs.ftpimageclient.model.IEditorFileModel;
import com.brother.of.all.bombs.ftpimageclient.rx.ISchedulerProvider;
import com.brother.of.all.bombs.ftpimageclient.usecases.ISubmitImageUseCase;

import org.junit.Test;

import io.reactivex.Single;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 */
public class EditorPresenterTest {
    @Test
    public void testInitialSetup() throws Exception {
        //PREPARE
        final String URI_TO_TEST = "uri";

        EditorPresenter.EditorView view = mock(EditorPresenter.EditorView.class);

        IEditorFileModel model = new IEditorFileModel() {
            @Override
            public String getEditorFileUri() {
                return URI_TO_TEST;
            }
        };

        EditorPresenter presenter = new EditorPresenter(getSchedulerProvider(), model, null);

        //PERFORM
        presenter.onViewAttached(view);

        //CHECK
        verify(view).setImage(URI_TO_TEST);
    }

    @Test
    public void testSubmittingResult() throws Exception {
        //PREPARE
        final String URI_TO_TEST = "uri";

        EditorPresenter.EditorView view = mock(EditorPresenter.EditorView.class);

        IEditorFileModel model = new IEditorFileModel() {
            @Override
            public String getEditorFileUri() {
                return URI_TO_TEST;
            }
        };
        ISubmitImageUseCase submitUseCase = mock(ISubmitImageUseCase.class);
        when(submitUseCase.submitImage(model.getEditorFileUri())).thenReturn(Single.just(true));

        EditorPresenter presenter = new EditorPresenter(getSchedulerProvider(), model, submitUseCase);
        presenter.onViewAttached(view);

        //PERFORM
        presenter.submitClicked();

        //CHECK
        verify(submitUseCase).submitImage(model.getEditorFileUri());
    }

    @Test
    public void testSubmitSuccess() throws Exception {
        //PREPARE
        final String URI_TO_TEST = "uri";

        EditorPresenter.EditorView view = mock(EditorPresenter.EditorView.class);

        IEditorFileModel model = new IEditorFileModel() {
            @Override
            public String getEditorFileUri() {
                return URI_TO_TEST;
            }
        };
        ISubmitImageUseCase submitUseCase = mock(ISubmitImageUseCase.class);
        when(submitUseCase.submitImage(model.getEditorFileUri())).thenReturn(Single.just(true));

        ISchedulerProvider provider = getSchedulerProvider();

        EditorPresenter presenter = new EditorPresenter(provider, model, submitUseCase);
        presenter.onViewAttached(view);

        //PERFORM
        presenter.submitClicked();
        ((TestScheduler)provider.getBackgroundThread()).triggerActions();
        ((TestScheduler)provider.getMainThread()).triggerActions();

        //CHECK
        verify(view).close();
    }

    @Test
    public void testSubmitError() throws Exception {
        //PREPARE
        final String URI_TO_TEST = "uri";

        EditorPresenter.EditorView view = mock(EditorPresenter.EditorView.class);

        IEditorFileModel model = new IEditorFileModel() {
            @Override
            public String getEditorFileUri() {
                return URI_TO_TEST;
            }
        };
        ISubmitImageUseCase submitUseCase = mock(ISubmitImageUseCase.class);
        when(submitUseCase.submitImage(model.getEditorFileUri())).thenReturn(Single.error(new Throwable()));

        ISchedulerProvider provider = getSchedulerProvider();

        EditorPresenter presenter = new EditorPresenter(provider, model, submitUseCase);
        presenter.onViewAttached(view);

        //PERFORM
        presenter.submitClicked();
        ((TestScheduler)provider.getBackgroundThread()).triggerActions();
        ((TestScheduler)provider.getMainThread()).triggerActions();

        //CHECK
        verify(view).showSubmitError();
    }

    private ISchedulerProvider getSchedulerProvider() {
        return new TestSchedulerProvider();
    }
}