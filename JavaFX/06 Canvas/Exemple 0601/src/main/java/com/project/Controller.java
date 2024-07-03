package com.project;

import javafx.animation.AnimationTimer;
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

public class Controller implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    public Canvas canvas;

    private GraphicsContext gc;
    private AnimationTimer animationTimer;

    public static ArrayList<DrawObj> drawingList = new ArrayList<>();
    public static DrawObjNumeros numeros = new DrawObjNumeros();
    public static DrawObjAgulles agulles = new DrawObjAgulles();
    public static DrawObjWatch watch = new DrawObjWatch();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize canvas responsive size
        UtilsViews.parentContainer.heightProperty().addListener((observable, oldValue, newvalue) -> {
            updateCanvasSize();
        });
        UtilsViews.parentContainer.widthProperty().addListener((observable, oldValue, newvalue) -> {
            updateCanvasSize();
        });

        start(canvas);
    }

    public void updateCanvasSize() {
        // Start Canvas size
        canvas.setWidth(UtilsViews.parentContainer.getWidth());
        canvas.setHeight(UtilsViews.parentContainer.getHeight());
    }

    public void keyEvent(KeyEvent evt) {
        // Quan apretem una tecla
        if (evt.getEventType() == KeyEvent.KEY_PRESSED) {
            if (evt.getCode() == KeyCode.UP) {
                // Acció per la tecla amunt
            }
        }

        // Quan deixem anar la tecla
        if (evt.getEventType() == KeyEvent.KEY_RELEASED) {
            // Acció quan deixem anar la tecla
        }
    }

    // Iniciar el context i bucle de dibuix
    public void start(Canvas canvas) {
        gc = canvas.getGraphicsContext2D();
        animationTimer = new UtilsFps(this::run, this::draw);
        animationTimer.start();
        drawingList.add(numeros);
        drawingList.add(agulles);
        drawingList.add(watch);
    }

    // Aturar el bucle de dibuix
    public void stop() {
        animationTimer.stop();
    }

    // Animar
    private void run(double fps) {
        if (fps < 1)
            return;
        for (DrawObj obj : drawingList) {
            obj.run(canvas, fps);
        }
    }

    // Dibuixar
    private void draw() {
        // Esborrar l'area de dibuix
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Dibuixar tots els objectes de la 'drawingList'
        for (DrawObj obj : drawingList) {
            obj.draw(gc);
        }
    }
}
