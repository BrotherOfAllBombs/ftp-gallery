package com.brother.of.all.bombs.ftpimageclient.di.components;

import com.brother.of.all.bombs.ftpimageclient.di.components.scopes.EditorScope;
import com.brother.of.all.bombs.ftpimageclient.editor.EditorActivity;

import dagger.Subcomponent;

/**
 *
 */
@EditorScope
@Subcomponent
public interface EditorComponent {
    void inject(EditorActivity editorActivity);
}
