package com.project;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PlayGrid {

    private final double startX;
    private final double startY;
    private final double cellSize;
    private final int rows;
    private final int cols;

    public PlayGrid(double startX, double startY, double cellSize, int rows, int cols) {
        this.startX = startX;
        this.startY = startY;
        this.cellSize = cellSize;
        this.rows = rows;
        this.cols = cols;
    }

    public boolean isMouseInsideGrid(double mouseX, double mouseY) {
        return mouseX >= startX && mouseX < startX + cols * cellSize &&
               mouseY >= startY && mouseY < startY + rows * cellSize;
    }  

    public double getStartX() {
        return startX;
    }

    public double getStartY() {
        return startY;
    }

    public double getCellSize() {
        return cellSize;
    }

    public int getRow(double mouseY) {
        if (mouseY < startY || mouseY >= startY + rows * cellSize) {
            return -1; // Fora de la graella
        }
        return (int) ((mouseY - startY) / cellSize);
    }
    
    public int getCol(double mouseX) {
        if (mouseX < startX || mouseX >= startX + cols * cellSize) {
            return -1; // Fora de la graella
        }
        return (int) ((mouseX - startX) / cellSize);
    }
    
    public void draw(GraphicsContext gc) {
        gc.setStroke(Color.BLACK);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                double x = startX + col * cellSize;
                double y = startY + row * cellSize;
                gc.strokeRect(x, y, cellSize, cellSize);
            }
        }
    }
}
