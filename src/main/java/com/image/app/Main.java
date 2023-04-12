package com.image.app;

import com.image.app.controllers.ImageController;
import com.image.app.util.ImageUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{



        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view2.fxml"));
        stage.setTitle("Image App");
        Scene scene = new Scene(fxmlLoader.load(), 1280, 1024);
        stage.setMinWidth(900);
        stage.setMinHeight(700);
        stage.setScene(scene);
        stage.show();

        // TODO: Uncomment for attribute testing
//        runTests();

    }

    /**
     * Consolidated attribute testing code, so it's quick to comment out for other testing
     */
    private static void runTests() {

        URL sourcePath = Main.class.getResource("../../../images/image3.jpg");
        URL targetPath = Main.class.getResource("../../../images/image3Test.jpg");

        ImageUtil.copyFile(sourcePath.getPath(), targetPath.getPath());

        File file1 = new File (sourcePath.getPath());
        File file2 = new File (targetPath.getPath());

        List<String> newKeywords = new ArrayList<>();
        newKeywords.add("success");
        newKeywords.add("help");

//        ImageController.getKeywords(targetPath.getPath());
        ImageController.addKeywords(newKeywords, file1, file2);
    }

    public static void main(String[] args) {
        launch();
    }
}
