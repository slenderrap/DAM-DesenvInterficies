package com.project;

import javafx.scene.canvas.Canvas;
import javafx.geometry.VPos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.image.Image;

public class GameObjTexts implements GameObj {

    final static Image imgMario = new Image("assets/mario.png");

    @Override
    public void run(Canvas cnv, double fps, GameData data) {
        // Update object attributes if any
    }

    @Override
    public void draw(GraphicsContext gc, GameData data) {
        
        // 0
        gc.setStroke(Color.RED);
        gc.strokeLine(50, 50, 100, 50);
        gc.strokeLine(50, 30, 50, 50);

        gc.save();
        gc.setFont(new Font("Arial", 25));
        gc.setFill(Color.BLUE);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.setTextBaseline(VPos.BASELINE);
        gc.fillText("Agc", 50, 50);
        gc.restore();

        String codi = """
            gc.setStroke(Color.RED);
            gc.strokeLine(50, 50, 100, 50);
            gc.strokeLine(50, 30, 50, 50);
    
            gc.save();
            gc.setFont(new Font(\"Arial\", 25));
            gc.setFill(Color.BLUE);
            gc.setTextAlign(TextAlignment.LEFT);
            gc.setTextBaseline(VPos.BASELINE);
            gc.fillText(\"Agc\", 50, 50);

            // Baseline alinea pel cos de la lletra
                """;
        Controller.drawCodi(gc, codi, 150, 30);

        // 1
        gc.setStroke(Color.RED);
        gc.strokeLine(50, 250, 100, 250);
        gc.strokeLine(100, 230, 100, 250);

        gc.save();
        gc.setFont(new Font("Verdana", 25));
        gc.setFill(Color.BLUE);
        gc.setTextAlign(TextAlignment.RIGHT);
        gc.setTextBaseline(VPos.BOTTOM);
        gc.fillText("Agc", 100, 250);
        gc.restore();

        codi = """
            gc.setStroke(Color.RED);
            gc.strokeLine(50, 250, 100, 250);
            gc.strokeLine(100, 230, 100, 250);
            
            gc.setFont(new Font(\"Verdana\", 25));
            gc.setFill(Color.BLUE);
            gc.setTextAlign(TextAlignment.RIGHT);
            gc.setTextBaseline(VPos.BOTTOM);
            gc.fillText(\"Agc\", 100, 250);

            // Bottom alinea pel peu de la lletra
                """;
        Controller.drawCodi(gc, codi, 150, 230);

        // 2
        gc.setStroke(Color.RED);
        gc.strokeLine(450, 50, 500, 50);
        gc.strokeLine(450, 50, 450, 80);

        gc.save();
        gc.setFont(new Font("Arial", 25));
        gc.setFill(Color.BLUE);
        gc.setTextAlign(TextAlignment.LEFT);
        gc.setTextBaseline(VPos.TOP);
        gc.fillText("Àgc", 450, 50);
        gc.restore();

        codi = """
            gc.setStroke(Color.RED);
            gc.strokeLine(450, 50, 500, 50);
            gc.strokeLine(450, 50, 450, 80);
    
            gc.save();
            gc.setFont(new Font(\"Arial\", 25));
            gc.setFill(Color.BLUE);
            gc.setTextAlign(TextAlignment.LEFT);
            gc.setTextBaseline(VPos.TOP);
            gc.fillText(\"Àgc\", 450, 50);
            gc.restore();
            
            // Top alinear pel cap de la lletra
                """;
        Controller.drawCodi(gc, codi, 520, 30);

        // 3
        gc.setStroke(Color.RED);
        gc.strokeLine(450, 250, 500, 250);
        gc.strokeLine(475, 240, 475, 260);

        gc.save();
        gc.setFont(new Font("Verdana", 25));
        gc.setFill(Color.BLUE);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.fillText("Agc", 475, 250);
        gc.restore();

        codi = """
            gc.setStroke(Color.RED);
            gc.strokeLine(450, 250, 500, 250);
            gc.strokeLine(475, 240, 475, 260);
    
            gc.save();
            gc.setFont(new Font(\"Verdana\", 25));
            gc.setFill(Color.BLUE);
            gc.setTextAlign(TextAlignment.CENTER);
            gc.setTextBaseline(VPos.CENTER);
            gc.fillText(\"Agc\", 475, 250);
            gc.restore();

            // Center alinea pel mig de la lletra
                """;
        Controller.drawCodi(gc, codi, 520, 230);
    }
}