package com.brother.of.all.bombs.ftpimageclient.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.io.IOException;

/**
 *
 */

public class EditorFileModel implements IEditorFileModel {

    private Context context;

    public EditorFileModel(Context context) {
        this.context = context;
    }

    @Override
    public String getEditorFileUri() {
        String imageFileName = "editor_file";
        File storageDir = context.getFilesDir();
        try {
            File image = getExistingTempFile(imageFileName, storageDir);
            if (!image.exists()) {
                image.createNewFile();
            }
            return getUriString(image);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String getUriString(File image) {
        return FileProvider
                .getUriForFile(context,
                        "com.brother.of.all.bombs.ftpimageclient",
                        image)
                .toString();
    }

    @NonNull
    private File getExistingTempFile(String imageFileName, File storageDir) {
        return new File(storageDir, imageFileName + ".jpg");
    }
}
