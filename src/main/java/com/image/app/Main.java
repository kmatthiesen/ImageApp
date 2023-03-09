package com.image.app;

import com.image.app.util.AttributeHandler;
import com.image.app.util.ImageUtil;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.commons.imaging.formats.jpeg.exif.ExifRewriter;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private static final String basePath = "C:\\Users\\round\\code\\ImageApp\\src\\main\\resources\\images\\";
    private static final String sourcePath = basePath + "image3.jpg";
    private static final String targetPath = basePath + "image3Test.jpg";


    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

//        ImageUtil.copyFile(sourcePath, targetPath);

        File file1 = new File (sourcePath);
        File file2 = new File (targetPath);

        List<String> newKeywords = new ArrayList<>();
        newKeywords.add("success");
        newKeywords.add("help");

//        AttributeHandler.getKeywords(targetPath);
        AttributeHandler.addKeywords(newKeywords, file1, file2);

//        ImageTags tags = new ImageTags("C:\\Users\\round\\code\\ImageApp\\src\\main\\resources\\images\\image3.jpg");

//        MetadataExample.metadataExample(new File("C:\\Users\\round\\code\\ImageApp\\src\\main\\resources\\images\\image1.jpg"));

//        Label greeting = new Label(tags.toString());
//        greeting.setTextFill(Color.BLUE);
//        root.getChildren().add(greeting);

        primaryStage.setTitle("Image App");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
