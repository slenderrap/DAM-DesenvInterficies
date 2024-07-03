package com.project;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObjTransformacions implements GameObj {

    final static Image imgMario = new Image("assets/mario.png");

    @Override
    public void run(Canvas cnv, double fps, GameData data) {
        // Update object attributes if any
    }

    @Override
    public void draw(GraphicsContext gc, GameData data) {
        
        // 0
        gc.save();
        double alt = imgMario.getHeight();
        double ample = imgMario.getWidth();
        double prpAmple = 50;
        double prpAlt = prpAmple * (alt / ample);
        gc.drawImage(imgMario, 50, 50, prpAmple, prpAlt);
        gc.restore();
       
        String codi = """
            gc.save();
            double alt = imgMario.getHeight();
            double ample = imgMario.getWidth();
            double prpAmple = 50;
            double prpAlt = prpAmple * (alt / ample);
            gc.drawImage(imgMario, 50, 50, prpAmple, prpAlt);
            gc.restore();
                """;
        Controller.drawCodi(gc, codi, 150, 50);

        // 1
        gc.save();
        gc.translate(50, 200);
        gc.save();
        gc.scale(1.5, 0.5);
        gc.drawImage(imgMario, 0, 0, prpAmple, prpAlt);
        gc.restore();
        gc.restore();
       
        codi = """
            gc.save();
            gc.translate(50, 200);
            gc.save();
            gc.scale(1.5, 0.5);
            gc.drawImage(imgMario, 0, 0, prpAmple, prpAlt);
            gc.restore();
            gc.restore();
                """;
        Controller.drawCodi(gc, codi, 150, 180);

        // 2
        gc.save();
        gc.translate(50, 325);
        gc.save();
        gc.rotate(-45);
        gc.drawImage(imgMario, 0, 0, prpAmple, prpAlt);
        gc.restore();
        gc.restore();
       
        codi = """
            gc.save();
            gc.translate(50, 325);
            gc.save();
            gc.rotate(-45);
            gc.drawImage(imgMario, 0, 0, prpAmple, prpAlt);
            gc.restore();
            gc.restore();
                """;
        Controller.drawCodi(gc, codi, 150, 300);
    }
}