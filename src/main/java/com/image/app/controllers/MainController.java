package com.image.app.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class MainController {

    @FXML
    private SplitPane splitPane;

    @FXML
    private Node leftPane;
    @FXML
    private Node rightPane;

    @FXML
    private ToggleButton navButton;
    @FXML
    private ToggleButton previewButton;
    @FXML
    private ToggleButton detailsButton;

    @FXML
    private ToggleGroup rightPaneGroup;


    public void initialize() {


//        final Image image1 = new Image(Main.class.getResourceAsStream("/images/Image1.jpeg"));
//        final ImageView imv1 = new ImageView();
//        imv1.setPreserveRatio(true);
//        imv1.setFitHeight(100);
//        imv1.setImage(image1);
//
//        final Image image2 = new Image(Main.class.getResourceAsStream("/images/Image2.jpeg"));
//        final ImageView imv2 = new ImageView();
//        imv2.setPreserveRatio(true);
//        imv2.setFitHeight(100);
//        imv2.setImage(image2);
//
//        final Image image3 = new Image(Main.class.getResourceAsStream("/images/Image3.jpeg"));
//        final ImageView imv3 = new ImageView();
//        imv3.setPreserveRatio(true);
//        imv3.setFitHeight(100);
//        imv3.setImage(image3);
//
//        centerTilePane.getChildren().add(imv1);
//        centerTilePane.getChildren().add(imv2);
//        centerTilePane.getChildren().add(imv3);


    }

    @FXML
    private void toggleLeftPane() {

        if (navButton.isSelected()) {
            splitPane.getItems().add(0, leftPane);
        } else {
            splitPane.getItems().remove(leftPane);
        }
    }

    @FXML
    private void toggleRightPane() {

        if (rightPaneGroup.getSelectedToggle() != null) {

            if (((ToggleButton) rightPaneGroup.getSelectedToggle()).getText().contains("Details")) {
                splitPane.getItems().add(rightPane);
            } else {

                splitPane.getItems().remove(rightPane);
            }

        } else {

            splitPane.getItems().remove(rightPane);

        }

    }



}
