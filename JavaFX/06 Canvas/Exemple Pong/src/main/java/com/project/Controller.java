package com.project;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.project.GameTimer;

public class Controller implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    public Canvas canvas;

    private static GameController gameController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // Initialize canvas responsive size
        UtilsViews.parentContainer.heightProperty().addListener((observable, oldValue, newvalue) -> { actionSetSize(); });
        UtilsViews.parentContainer.widthProperty().addListener((observable, oldValue, newvalue) -> { actionSetSize(); });

        // Initalize game controller
        gameController = new GameController(canvas);

        // Listen to key events (set when scene is available)
        Platform.runLater(() -> {
            UtilsViews.parentContainer.getScene().addEventFilter(KeyEvent.ANY, keyEvent -> { keyEvent(keyEvent); });
        });
    }

    // Define Canvas size
    public void actionSetSize() {

        double width = UtilsViews.parentContainer.getWidth();
        double height = UtilsViews.parentContainer.getHeight();
        canvas.setWidth(width);
        canvas.setHeight(height);
    }
    
    public void keyEvent (KeyEvent evt) {

        // Quan apretem una tecla
        if (evt.getEventType() == KeyEvent.KEY_PRESSED) {
            if (evt.getCode() == KeyCode.LEFT) {
                gameController.playerDirection = "left";
            }
            if (evt.getCode() == KeyCode.RIGHT) {
                gameController.playerDirection = "right";
            }
        }

        // Quan deixem anar la tecla
        if (evt.getEventType() == KeyEvent.KEY_RELEASED) {
            if (evt.getCode() == KeyCode.LEFT) {
                if (gameController.playerDirection.equals("left")) {
                    gameController.playerDirection = "none";
                }
            }
            if (evt.getCode() == KeyCode.RIGHT) {
                if (gameController.playerDirection.equals("right")) {
                    gameController.playerDirection = "none";
                }
            }
        }
    }
}
