package com.image.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static final String basePath = "C:\\Users\\round\\code\\ImageApp\\src\\main\\resources\\images\\";
    private static final String sourcePath = basePath + "image3.jpg";
    private static final String targetPath = basePath + "image3Test.jpg";


    @Override
    public void start(Stage stage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main-view.fxml"));
        stage.setTitle("Image App");
        Scene scene = new Scene(fxmlLoader.load(), 300, 275);
        stage.setScene(scene);
        stage.show();

//        ImageUtil.copyFile(sourcePath, targetPath);

//        File file1 = new File (sourcePath);
//        File file2 = new File (targetPath);
//
//        List<String> newKeywords = new ArrayList<>();
//        newKeywords.add("success");
//        newKeywords.add("help");

//        AttributeHandler.getKeywords(targetPath);
//        ImageController.addKeywords(newKeywords, file1, file2);

//        ImageTags tags = new ImageTags("C:\\Users\\round\\code\\ImageApp\\src\\main\\resources\\images\\image3.jpg");

//        MetadataExample.metadataExample(new File("C:\\Users\\round\\code\\ImageApp\\src\\main\\resources\\images\\image1.jpg"));

//        Label greeting = new Label(tags.toString());
//        greeting.setTextFill(Color.BLUE);
//        root.getChildren().add(greeting);


    }


    public static void main(String[] args) {
        launch(args);
    }
}
