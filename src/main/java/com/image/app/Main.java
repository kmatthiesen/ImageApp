package com.image.app;

import com.image.app.util.AttributeHandler;
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

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

//        ImageTags tags = new ImageTags("C:\\Users\\round\\code\\ImageApp\\src\\main\\resources\\images\\image1.png");

        MetadataExample.metadataExample(new File("C:\\Users\\round\\code\\ImageApp\\src\\main\\resources\\images\\file_example_PNG_500kb.png"));

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
