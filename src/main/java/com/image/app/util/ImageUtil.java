package com.image.app.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Utility class for development.
 */
public class ImageUtil {

    public static void copyFile(String source, String target) {

        deleteFile(target);

        File sourceFile = new File(source);
        File targetFile = new File(target);

        try {
            Files.copy(sourceFile.toPath(),targetFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void deleteFile(String target) {

        try {
            Files.delete(new File(target).toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
