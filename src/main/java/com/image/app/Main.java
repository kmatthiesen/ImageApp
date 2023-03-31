package com.image.app;

import com.image.app.controller.ImageController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

        URL sourcePath = Main.class.getResource("../../../images/image3.jpg");
        URL targetPath = Main.class.getResource("../../../images/image3Test.jpg");

//        ImageUtil.copyFile(sourcePath, targetPath);

        File file1 = new File (sourcePath.getPath());
        File file2 = new File (targetPath.getPath());

        List<String> newKeywords = new ArrayList<>();
        newKeywords.add("success");
        newKeywords.add("help");

//        ImageController.getKeywords(targetPath.getPath());
        ImageController.addKeywords(newKeywords, file1, file2);



    }


    public static void main(String[] args) {
        launch(args);
    }
}
