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
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
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

        // Dibuixar un marc a l'area de dibuix
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        gc.strokeRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private static class DrawObjAgulles implements DrawObj {
        private double hores = 0;
        private double minuts = 0;
        private double segons = 0;
        private double millis = 0;

        public void setHores(double hores) {
            this.hores = hores;
        }

        public void setMinuts(double minuts) {
            this.minuts = minuts;
        }

        public void setSegons(double segons) {
            this.segons = segons;
        }

        public void run(Canvas cnv, double fps) {
            Calendar cal = Calendar.getInstance();
            hores = cal.get(Calendar.HOUR_OF_DAY);
            minuts = cal.get(Calendar.MINUTE);
            segons = cal.get(Calendar.SECOND);
            millis = cal.get(Calendar.MILLISECOND);
        }

        public void draw(GraphicsContext gc) {
            int canvasHeight = (int) gc.getCanvas().getHeight();
            int canvasWidth = (int) gc.getCanvas().getWidth();
            int diameter = Math.min(canvasWidth, canvasHeight) - 25;
            int x = canvasWidth / 2;
            int y = canvasHeight / 2;
            int radius = diameter / 2;
            int radiusHalf = radius / 2;
            double sub = Math.PI / 2;
            double radians;

            // Dibuixar les hores
            radians = Math.toRadians((hores + minuts / 60) * 30) - sub;
            drawCircleLine(gc, Color.WHITE, 3, x, y, 0, 25, radians);
            drawCircleLine(gc, Color.WHITE, 8, x, y, 20, radiusHalf, radians);

            // Dibuixar els minuts
            radians = Math.toRadians((minuts + segons / 60) * 6) - sub;
            drawCircleLine(gc, Color.WHITE, 3, x, y, 0, 25, radians);
            drawCircleLine(gc, Color.WHITE, 8, x, y, 20, radius - 25, radians);

            // Dibuixar els segons
            radians = Math.toRadians(segons * 6) + Math.toRadians(millis * 0.006) - sub;
            drawCircleLine(gc, Color.RED, 2, x, y, -20, radius, radians);

            // Dibuixar el cercle dels segons
            int radiusCS = 6;
            gc.setFill(Color.RED);
            gc.fillOval(x - radiusCS, y - radiusCS, radiusCS * 2, radiusCS * 2);

            // Dibuixar el centre
            int radiusCT = 3;
            gc.setFill(Color.BLACK);
            gc.fillOval(x - radiusCT, y - radiusCT, radiusCT * 2, radiusCT * 2);
        }

        private void drawCircleLine(GraphicsContext gc, Color color, double size, int x, int y, int radiusMin,
                int radiusMax, double radians) {
            gc.setStroke(color);
            gc.setLineWidth(size);
            gc.setLineCap(StrokeLineCap.ROUND);
            gc.beginPath();
            gc.moveTo(x + radiusMin * Math.cos(radians), y + radiusMin * Math.sin(radians));
            gc.lineTo(x + radiusMax * Math.cos(radians), y + radiusMax * Math.sin(radians));
            gc.stroke();
            gc.setLineCap(StrokeLineCap.SQUARE);
        }
    }
}
