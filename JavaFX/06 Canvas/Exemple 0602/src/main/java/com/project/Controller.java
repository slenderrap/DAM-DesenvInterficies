package com.project;

import java.net.URL;
import java.util.ResourceBundle;

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
import javafx.scene.control.ChoiceBox;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.layout.HBox;

public class Controller implements Initializable {

    @FXML
    private AnchorPane anchor;

    @FXML
    public Canvas canvas;

    @FXML
    public HBox hbox;

    @FXML
    private ChoiceBox<String> choiceBox = new ChoiceBox<>();

    private static GameData data = new GameData();

    private GraphicsContext gc;
    private GameTimer animationTimer = new GameTimer();

    private boolean showFps = true;
    private double fps = 0;

    public GameObj drawingObj = new GameObjLinies();

    private String choiceBoxValues[] = { "Linies", "Poligons", "Poligons emplenats",
        "Quadrats i cercles", "Imatges", "Gradients lineals", "Gradients radials",
        "Transformacions", "Texts", "Text multilinia" };

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize canvas responsive size
        UtilsViews.parentContainer.heightProperty().addListener((observable, oldValue, newvalue) -> {
            updateCanvasSize();
        });
        UtilsViews.parentContainer.widthProperty().addListener((observable, oldValue, newvalue) -> {
            updateCanvasSize();
        });

        choiceBox.getItems().addAll(choiceBoxValues);
        choiceBox.setValue("Linies");
        choiceBox.setOnAction((event) -> {
            String selectedItem = choiceBox.getSelectionModel().getSelectedItem();
            switch (selectedItem) {
                case "Linies":              drawingObj = new GameObjLinies(); break;
                case "Poligons":            drawingObj = new GameObjPoligons(); break;
                case "Poligons emplenats":  drawingObj = new GameObjPoligonsEmplenats(); break;
                case "Quadrats i cercles":  drawingObj = new GameObjQuadratsCercles(); break;
                case "Imatges":             drawingObj = new GameObjImatges(); break;
                case "Gradients lineals":   drawingObj = new GameObjGradientsLineals(); break;
                case "Gradients radials":   drawingObj = new GameObjGradientsRadials(); break;
                case "Transformacions":     drawingObj = new GameObjTransformacions(); break;
                case "Texts":               drawingObj = new GameObjTexts(); break;
                case "Text multilinia":     drawingObj = new GameObjTextMultilinia(); break;
            }
        });

        start(canvas);
        updateCanvasSize();
    }

    public void updateCanvasSize() {
        // Start Canvas size
        double width = UtilsViews.parentContainer.getWidth();
        double height = UtilsViews.parentContainer.getHeight() - hbox.getHeight();
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
        drawingObj.run(canvas, fps, data);
    }

    // Dibuixar
    private void draw() {
        // Esborrar l'area de dibuix
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Dibuixar la graella de fons
        drawGrid(gc);

        // Dibuixar l'objecte de dibuix actual
        drawingObj.draw(gc, data);

        // Dibuixar els FPS si està indicat
        if (showFps) {
            gc.setFill(Color.RED);
            gc.setFont(Font.font("Arial", FontWeight.BOLD, 14));
            gc.fillText(String.format("FPS: %.2f", fps), 8, 20);
        }
    }

    // Dibuixa una graella per saber la posición dels objectes
    public void drawGrid(GraphicsContext gc) {
        Canvas cnv = gc.getCanvas();
        double cnvHeight = cnv.heightProperty().doubleValue();
        double cnvWidth = cnv.widthProperty().doubleValue();

        gc.setFill(Color.BLACK);
        gc.save();
        gc.setFont(new Font("Arial", 12));
        gc.setLineCap(StrokeLineCap.BUTT);
        for (int x = 0; x < cnvWidth; x = x + 10) {
            if (x % 50 == 0) {
                gc.setStroke(Color.LIGHTGRAY);
                gc.setLineWidth(2);
                gc.strokeLine(x, 0, x, cnvHeight);
                gc.fillText("" + x, x, 10);
            } else {
                gc.setStroke(Color.LIGHTGRAY);
                gc.setLineWidth(1);
                gc.strokeLine(x, 0, x, cnvHeight);
            }
        }

        for (int y = 0; y < cnvHeight; y = y + 10) {
            if (y % 50 == 0) {
                gc.setStroke(Color.LIGHTGRAY);
                gc.setLineWidth(2);
                gc.strokeLine(0, y, cnvWidth, y);
                gc.fillText("" + y, 0, y + 10);
            } else {
                gc.setStroke(Color.LIGHTGRAY);
                gc.setLineWidth(1);
                gc.strokeLine(0, y, cnvWidth, y);
            }
        }
        gc.restore();
    }

    public static void drawCodi(GraphicsContext gc, String codi, double x, double y) {
        gc.save();
        gc.setFont(new Font("Arial", 12));
        gc.setFill(Color.BLACK);
        gc.fillText(codi, x, y);
        gc.restore();
    }
}
