package com.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CtrlPlay implements Initializable {

    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private Boolean showFPS = false;

    private Runnable callbackMouseTracking;

    private PlayTimer animationTimer;
    private PlayGrid playGrid;

    public PlayMousePosition lastMousePosition;
    private List<PlayMousePosition> allMousePositions = new ArrayList<>(); // All players

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        setupMouseTracking();

        UtilsViews.parentContainer.heightProperty().addListener((observable, oldValue, newvalue) -> { actionSetSize(); });
        UtilsViews.parentContainer.widthProperty().addListener((observable, oldValue, newvalue) -> { actionSetSize(); });

        this.gc = canvas.getGraphicsContext2D();

        playGrid = new PlayGrid(25, 25, 25, 10, 10);

        animationTimer = new PlayTimer(this::run, this::draw, 0);
        start();
    }

    public void setCallbackMouseTracking(Runnable callback) {
        this.callbackMouseTracking = callback;
    }

    // When window changes its size
    public void actionSetSize() {

        double width = UtilsViews.parentContainer.getWidth();
        double height = UtilsViews.parentContainer.getHeight();
        canvas.setWidth(width);
        canvas.setHeight(height);
    }

    // Start animation timer
    public void start() {
        animationTimer.start();
    }

    // Stop animation timer
    public void stop() {
        animationTimer.stop();
    }

    private void setupMouseTracking() {
        canvas.setOnMouseMoved(event -> {
            double mouseX = event.getX();
            double mouseY = event.getY();

            if (playGrid.isMouseInsideGrid(mouseX, mouseY)) {                
                lastMousePosition = new PlayMousePosition("local", mouseX, mouseY, playGrid.getRow(mouseY), playGrid.getCol(mouseX));
            } else {
                lastMousePosition = new PlayMousePosition("local", mouseX, mouseY, -1, -1);
            }
            if (callbackMouseTracking != null) {
                callbackMouseTracking.run();
            }
        });
    }

    public void setPlayersMousePositions(JSONObject positions) {

        allMousePositions.clear();
    
        // Recórrer totes les claus del JSONObject (clientIds)
        for (String clientId : positions.keySet()) {
            JSONObject pos = positions.getJSONObject(clientId);
            double x = pos.getDouble("x");
            double y = pos.getDouble("y");
            int row = pos.getInt("row");
            int col = pos.getInt("col");
    
            // Creem una nova instància de MousePosition
            PlayMousePosition mousePosition = new PlayMousePosition(clientId, x, y, row, col);
    
            // Afegim la posició a la llista nativa
            allMousePositions.add(mousePosition);
        }
    }

    // Run game (and animations)
    private void run(double fps) {

        if (animationTimer.fps < 1) { return; }

        // Update objects and animations here
    }

    // Draw game to canvas
    public void draw() {

        // Clean drawing area
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Draw colored 'over' cells
        for (PlayMousePosition mousePosition : allMousePositions) {
            int row = mousePosition.getRow();
            int col = mousePosition.getCol();

            // Comprovar si està dins dels límits de la graella
            if (row >= 0 && col >= 0) {
                if ("A".equals(mousePosition.getClientId())) {
                    gc.setFill(Color.LIGHTBLUE); 
                } else {
                    gc.setFill(Color.LIGHTGREEN); 
                }
                // Emplenar la casella amb el color clar
                gc.fillRect(playGrid.getCellX(col), playGrid.getCellY(row), playGrid.getCellSize(), playGrid.getCellSize());
            }
        }

        // Draw grid
        playGrid.draw(gc);

        // Draw mouse circles
        for (PlayMousePosition mousePosition : allMousePositions) {  
            // Dibuixar un cercle a la posició del ratolí
            if ("A".equals(mousePosition.getClientId())) {
                gc.setFill(Color.BLUE);
            } else {
                gc.setFill(Color.GREEN); 
            }
            gc.fillOval(mousePosition.getX() - 5, mousePosition.getY() - 5, 10, 10);
        }

        // Draw FPS if needed
        if (showFPS) { animationTimer.drawFPS(gc); }   
    }
}
