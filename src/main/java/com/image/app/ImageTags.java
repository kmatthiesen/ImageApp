package com.image.app;

import com.drew.metadata.Tag;
import com.image.app.util.AttributeHandler;

import java.util.ArrayList;
import java.util.List;

public class ImageTags {

    private ArrayList<String> tagList;

    public ImageTags () {
        this(new ArrayList<>());
    }

    public ImageTags (ArrayList<String> tags) {
        this.tagList = tags;
    }

    public ImageTags (String filePath) {
        this.tagList = AttributeHandler.getKeywords(filePath);
    }

    public ArrayList<String> addTags (List<String> newTags) {
        this.tagList.addAll(newTags);
        return this.tagList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (String tag: this.tagList) {
            builder.append(tag);
        }
        return builder.toString();
    }
}
