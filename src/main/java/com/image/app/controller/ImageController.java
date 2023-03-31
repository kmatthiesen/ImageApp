package com.image.app.controller;


import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;
import org.apache.commons.imaging.common.GenericImageMetadata;
import org.apache.commons.imaging.common.ImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.jpeg.exif.ExifRewriter;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;
import org.apache.commons.imaging.formats.tiff.constants.MicrosoftTagConstants;
import org.apache.commons.imaging.formats.tiff.write.TiffOutputDirectory;
import org.apache.commons.imaging.formats.tiff.write.TiffOutputSet;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ImageController {

    public static JpegImageMetadata getMetaData(String path) {
        File image = new File(path);

        try {
            final ImageMetadata metadata = Imaging.getMetadata(image);

            if (metadata instanceof JpegImageMetadata jpegImageMetadata) {

                return jpegImageMetadata;
            }

        } catch (ImageReadException | IOException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public static List<String> getKeywords(String filePath) {
        ArrayList<String> keywords = new ArrayList<>();

        try {
            File image = new File(filePath);
            final ImageMetadata metadata = Imaging.getMetadata(image);

            if (metadata instanceof JpegImageMetadata jpegImageMetadata) {

                return parseKeywords(jpegImageMetadata);
            }
        } catch (ImageReadException | IOException e) {
            e.printStackTrace();
        }

        return keywords;
    }

    public static List<String> parseKeywords (JpegImageMetadata jpegImageMetadata) {
        List<String> keywords = new ArrayList<>();

        final List<ImageMetadata.ImageMetadataItem> items = jpegImageMetadata.getItems();

        for (final ImageMetadata.ImageMetadataItem item : items) {
//                    System.out.println(item);
            if (item.toString().contains(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS.name) && item instanceof GenericImageMetadata.GenericImageMetadataItem tags) {
//                System.out.println(tags);
                String replaced = tags.getText().replace("'", "");
                keywords.addAll(Arrays.asList(replaced.split(";")));
            }
        }

        return keywords;
    }

    public static void addKeywords(List<String> keywords, File source, File dst) {

        try (FileOutputStream fos = new FileOutputStream(dst); OutputStream os = new BufferedOutputStream(fos)) {

            TiffOutputSet outputSet = null;

            final ImageMetadata metadata = Imaging.getMetadata(source);
            final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
            if (jpegMetadata != null) {

                // note that exif might be null if no Exif metadata is found.
                final TiffImageMetadata exif = jpegMetadata.getExif();
                if (null != exif) {
                    outputSet = exif.getOutputSet();
                }
            }

            if (outputSet == null) {
                outputSet = new TiffOutputSet();
            }

            final TiffOutputDirectory rootDir = outputSet.getExifDirectory();

            StringBuilder newKeywords = new StringBuilder();

            for (String keyword: keywords) {
                newKeywords.append(keyword).append(";");
            }

            outputSet.removeField(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS);

//            rootDir.removeField(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS);
            System.out.println(rootDir.findField(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS));
            System.out.println(outputSet.findField(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS));
            rootDir.add(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS, newKeywords.toString());
            System.out.println(rootDir.findField(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS));
            System.out.println(outputSet.findField(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS));

            new ExifRewriter().updateExifMetadataLossy(source, os, outputSet);

        } catch (IOException | ImageReadException | ImageWriteException e) {
            e.printStackTrace();
        } finally {
            getKeywords(dst.getPath().toString());
        }
    }

}
