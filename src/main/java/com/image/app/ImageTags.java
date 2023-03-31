package com.image.app;

import com.image.app.ImageController;

import java.util.ArrayList;
import java.util.List;

public class ImageTags {

    private List<String> tagList;

    public ImageTags () {
        this(new ArrayList<>());
    }

    public ImageTags (ArrayList<String> tags) {
        this.tagList = tags;
    }

    public ImageTags (String filePath) {
        this.tagList = ImageController.getKeywords(filePath);
    }

//    public ArrayList<String> addTags (List<String> newTags) {
//        this.tagList.addAll(newTags);
//        return this.tagList;
//    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String tag: this.tagList) {
            builder.append(tag);
        }
        return builder.toString();
    }
}
