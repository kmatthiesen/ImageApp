package com.image.app.controllers;

import com.image.app.Main;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class MainController {

    @FXML
    private TilePane centerTilePane;

    public void initialize() {


        // TODO: Add images directory to resources: resources.com.image.app.images

        final Image image1 = new Image(Main.class.getResourceAsStream("/images/Image1.jpeg"));
        final ImageView imv1 = new ImageView();
        imv1.setPreserveRatio(true);
        imv1.setFitHeight(100);
        imv1.setImage(image1);

        final Image image2 = new Image(Main.class.getResourceAsStream("/images/Image2.jpeg"));
        final ImageView imv2 = new ImageView();
        imv2.setPreserveRatio(true);
        imv2.setFitHeight(100);
        imv2.setImage(image2);

        final Image image3 = new Image(Main.class.getResourceAsStream("/images/Image3.jpeg"));
        final ImageView imv3 = new ImageView();
        imv3.setPreserveRatio(true);
        imv3.setFitHeight(100);
        imv3.setImage(image3);

        centerTilePane.getChildren().add(imv1);
        centerTilePane.getChildren().add(imv2);
        centerTilePane.getChildren().add(imv3);


    }


}
