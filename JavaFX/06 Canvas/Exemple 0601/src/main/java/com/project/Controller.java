package com.project;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.project.GameObjAgulles;
import com.project.GameObjNumeros;
import com.project.GameObjWatch;
import com.project.GameTimer;

public class Controller implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    public Canvas canvas;

    private static GameData data = new GameData();

    private GraphicsContext gc;
    private GameTimer animationTimer = new GameTimer();

    private boolean showFps = true; 
    private double fps = 0;

    public ArrayList<GameObj> drawingList = new ArrayList<>();
    public GameObjNumeros numeros = new GameObjNumeros();
    public GameObjAgulles agulles = new GameObjAgulles();
    public GameObjWatch watch = new GameObjWatch();

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
        double width = UtilsViews.parentContainer.getWidth();
        double height = UtilsViews.parentContainer.getHeight();
        canvas.setWidth(width);
        canvas.setHeight(height);
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
        animationTimer.startWith(this::run, this::draw);
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

        data.run();
        this.fps = fps;
        for (GameObj obj : drawingList) {
            obj.run(canvas, fps, data);
        }
    }

    // Dibuixar
    private void draw() {
        // Esborrar l'area de dibuix
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Dibuixar tots els objectes de la 'drawingList'
        for (GameObj obj : drawingList) {
            obj.draw(gc, data);
        }

        // Dibuixar els FPS si està indicat
        if (showFps) {
            gc.setFill(Color.RED);
            gc.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            gc.fillText(String.format("FPS: %.2f", fps), 8, 20);
        }       
    }
}
