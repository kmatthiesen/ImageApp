package com.image.app.util;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AttributeHandler {

    public static ArrayList<String> getKeywords(String filePath) {
        ArrayList<String> keywords = new ArrayList<>();
        Metadata metadata = null;

        try {
            File file = new File(filePath);
            metadata = ImageMetadataReader.readMetadata(file);
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (metadata != null) {
            for (Directory directory : metadata.getDirectories()) {
                for (Tag tag : directory.getTags()) {
                    if (tag.getTagName().equals("Windows XP Keywords")) {
                        String[] stringTags = tag.getDescription().split(";");
                        keywords.addAll(Arrays.asList(stringTags));
                    }
                }
            }
        }

        return keywords;
    }

}
