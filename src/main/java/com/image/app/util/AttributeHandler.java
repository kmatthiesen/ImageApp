package com.image.app.util;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttributeHandler {

    public static ArrayList<String> getKeywords(String filePath) {
        ArrayList<String> keywords = new ArrayList<>();

        UserDefinedFileAttributeView view = Files.getFileAttributeView(Paths.get(filePath), UserDefinedFileAttributeView.class);

        System.out.println(view.name());
        try {
            for (String name : view.list()) {
                System.out.println(name);
                System.out.println("====");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return keywords;
    }

}
