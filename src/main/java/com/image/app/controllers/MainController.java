package com.image.app.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    private SplitPane splitPane;

    @FXML
    private Node leftPane;
    private boolean isLeftPaneVisible = true;
    private double firstDivider;
    private double secondDivider;

    @FXML
    private AnchorPane detailsPane;

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



        if (isLeftPaneVisible) {

            firstDivider = splitPane.getDividers().get(0).getPosition();
            secondDivider = splitPane.getDividers().get(1).getPosition();
            splitPane.getItems().removeAll(leftPane);
            splitPane.setDividerPosition(0, secondDivider);
//            leftPane.setVisible(false);
//            leftPane.setManaged(false);

            isLeftPaneVisible = !isLeftPaneVisible;
        } else {
//            leftPane.setVisible(true);
//            leftPane.setManaged(true);
            splitPane.getItems().add(0, leftPane);
            splitPane.setDividerPosition(0, firstDivider);
            isLeftPaneVisible = !isLeftPaneVisible;
        }

    }

    @FXML
    private void toggleDetailsPane() {

    }

    private void setDividers(int x1, double x2) {
        splitPane.setDividerPosition(x1, x2);
    }
}
