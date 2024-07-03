package com.project;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Canvas canvas;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonClear;

    private GraphicsContext gc;
    private Random random;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        gc = canvas.getGraphicsContext2D();
        random = new Random();

        firstDrawing();
    }

    @FXML
    private void addAction(ActionEvent event) {
        // Generar una posició i mida aleatòria per a la forma
        double size = 20 + random.nextInt(31); // Mida entre 20 i 50
        double x = random.nextDouble() * (canvas.getWidth() - size);
        double y = random.nextDouble() * (canvas.getHeight() - size);

        // Generar un color aleatori
        Color color = getRandomColor();

        // Decidir aleatòriament si dibuixar un quadrat o un cercle
        if (random.nextBoolean()) {
            // Dibuixar un quadrat
            gc.setFill(color);
            gc.fillRect(x, y, size, size);
        } else {
            // Dibuixar un cercle
            gc.setFill(color);
            gc.fillOval(x, y, size, size);
        }
    }

    @FXML
    private void clearAction(ActionEvent event) {
        // Netejar tot el Canvas
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private Color getRandomColor() {
        Color[] colors = { Color.RED, Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.ORANGE, Color.BLACK, Color.WHITE };
        return colors[random.nextInt(colors.length)];
    }

    private void firstDrawing() {
        // Dibuixar sobre el Canvas
        gc.setFill(Color.BLUE);
        gc.fillRect(75, 75, 250, 250);

        gc.setStroke(Color.RED);
        gc.strokeLine(50, 50, 350, 350);

        gc.setFill(Color.GREEN);
        gc.fillOval(100, 100, 200, 200);
    }
}
