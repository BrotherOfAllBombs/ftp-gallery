package com.brother.of.all.bombs.ftpimageclient.editor;

import com.brother.of.all.bombs.ftpimageclient.model.IEditorFileModel;
import com.brother.of.all.bombs.ftpimageclient.rx.ISchedulerProvider;
import com.brother.of.all.bombs.ftpimageclient.usecases.ISubmitImageUseCase;

import javax.inject.Inject;

import easymvp.AbstractPresenter;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

/**
 *
 */

public class EditorPresenter extends AbstractPresenter<EditorPresenter.EditorView> {

    private ISchedulerProvider schedulerProvider;
    private IEditorFileModel editorModel;
    private ISubmitImageUseCase submitUseCase;

    @Inject
    public EditorPresenter(ISchedulerProvider schedulerProvider, IEditorFileModel editorModel, ISubmitImageUseCase submitUseCase) {
        this.schedulerProvider = schedulerProvider;
        this.editorModel = editorModel;
        this.submitUseCase = submitUseCase;
    }

    @Override
    public void onViewAttached(EditorView view) {
        super.onViewAttached(view);
        getView().setImage(editorModel.getEditorFileUri());
    }

    public void submitClicked() {
        submitUseCase.submitImage(editorModel.getEditorFileUri())
                .subscribeOn(schedulerProvider.getBackgroundThread())
                .observeOn(schedulerProvider.getMainThread())
                .subscribe(new SingleObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Object o) {
                        getView().close();
                    }

                    @Override
                    public void onError(Throwable e) {
                        getView().showSubmitError();
                    }
                });
    }

    interface EditorView {
        void setImage(String uri);
        void close();
        void showSubmitError();
    }
}
