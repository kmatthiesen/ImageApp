package com.image.app;

import com.image.app.controller.ImageController;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;

import java.util.ArrayList;
import java.util.List;

public class Image {

    private final JpegImageMetadata jpegImageMetadata;
    private final List<String> keywords = new ArrayList<>();

    public static Image createImage(String path) {

        JpegImageMetadata jpegImageMetadata = ImageController.getMetaData(path);

        Image newImage = new Image(jpegImageMetadata);

        return newImage;
    }

    public Image () throws Exception {
        throw new Exception("Use the static factory method, createImage, to create an instance of the Image class");
    }

    private Image(JpegImageMetadata jpegImageMetadata) {
        this.jpegImageMetadata = jpegImageMetadata;

        keywords.addAll(ImageController.parseKeywords(jpegImageMetadata));

    }



}
