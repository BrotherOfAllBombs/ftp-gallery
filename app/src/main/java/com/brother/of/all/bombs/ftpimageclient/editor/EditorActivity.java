package com.brother.of.all.bombs.ftpimageclient.editor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.brother.of.all.bombs.ftpimageclient.MainApplication;
import com.brother.of.all.bombs.ftpimageclient.R;

import javax.inject.Inject;

import easymvp.annotation.ActivityView;
import easymvp.annotation.Presenter;

/**
 *
 */
@ActivityView(presenter = EditorPresenter.class, layout = R.layout.activity_editor)
public class EditorActivity extends AppCompatActivity implements EditorPresenter.EditorView {

    @Inject
    @Presenter
    EditorPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        ((MainApplication)getApplication()).getEditorComponent().inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setImage(String uri) {

    }

    @Override
    public void close() {

    }

    @Override
    public void showSubmitError() {

    }
}
