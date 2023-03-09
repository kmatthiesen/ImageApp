package com.image.app.util;


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


public class AttributeHandler {

    public static ArrayList<String> getKeywords(String filePath) {
        ArrayList<String> keywords = new ArrayList<>();

        try {
            File image = new File(filePath);
            final ImageMetadata metadata = Imaging.getMetadata(image);

            if (metadata instanceof JpegImageMetadata) {

                final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
                final List<ImageMetadata.ImageMetadataItem> items = jpegMetadata.getItems();

                for (final ImageMetadata.ImageMetadataItem item : items) {
                    if (item.toString().contains(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS.name) && item instanceof GenericImageMetadata.GenericImageMetadataItem) {
                        GenericImageMetadata.GenericImageMetadataItem tags = (GenericImageMetadata.GenericImageMetadataItem) item;
//                        System.out.println(tags);
                        String replaced = tags.getText().replace("'", "");
                        keywords.addAll(Arrays.asList(replaced.split(";")));
                    }
                }
            }
        } catch (ImageReadException | IOException e) {
            e.printStackTrace();
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

            final TiffOutputDirectory rootDir = outputSet.getOrCreateRootDirectory();

            StringBuilder newKeywords = new StringBuilder();

            for (String keyword: keywords) {
                newKeywords.append(keyword).append(";");
            }

            rootDir.removeField(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS);
            rootDir.add(MicrosoftTagConstants.EXIF_TAG_XPKEYWORDS, newKeywords.toString());

            new ExifRewriter().updateExifMetadataLossy(source, os, outputSet);

        } catch (IOException | ImageReadException | ImageWriteException e) {
            e.printStackTrace();
        }
    }


}
