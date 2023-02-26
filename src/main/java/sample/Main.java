package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

        Label greeting = new Label("Welcome to the image app");
        greeting.setTextFill(Color.BLUE);
        root.getChildren().add(greeting);

        primaryStage.setTitle("Image App");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
