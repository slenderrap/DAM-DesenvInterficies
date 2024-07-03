package com.project;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class GameObjImatges implements GameObj {

    final static Image imgMario = new Image("assets/mario.png");

    @Override
    public void run(Canvas cnv, double fps, GameData data) {
        // Update object attributes if any
    }

    @Override
    public void draw(GraphicsContext gc, GameData data) {

        // 0
        gc.drawImage(imgMario, 50, 50, 50, 50);
        // imatge, x, y, ample, alt
    
        String codi = """
            gc.drawImage(imgMario, 50, 50, 50, 50);
            // imatge, x, y, ample, alt
            // no manté la proporció
                """;
        Controller.drawCodi(gc, codi, 150, 50);

        // 1
        gc.drawImage(imgMario, 50, 250, 50, 100);
       
        codi = """
            gc.drawImage(imgMario, 50, 250, 50, 100);
            // imatge, x, y, ample, alt
            // no manté la proporció
                """;
        Controller.drawCodi(gc, codi, 150, 250);

        // 2
        double alt = imgMario.getHeight();
        double ample = imgMario.getWidth();
        double prpAmple = 50;
        double prpAlt = prpAmple * (alt / ample);
        gc.drawImage(imgMario, 400, 50, prpAmple, prpAlt);
       
        codi = """
            double alt = imgMario.getHeight();
            double ample = imgMario.getWidth();
            double prpAmple = 50;
            double prpAlt = prpAmple * (alt / ample);
            gc.drawImage(imgMario, 400, 50, prpAmple, prpAlt);
            // Manté la proporció correcta amb ample = 50
                """;
        Controller.drawCodi(gc, codi, 450, 50);

        // 3
        alt = imgMario.getHeight();
        ample = imgMario.getWidth();
        prpAlt = 50;
        prpAmple = prpAlt * (ample / alt);
        gc.drawImage(imgMario, 400, 250, prpAmple, prpAlt);
       
        codi = """
            alt = imgMario.getHeight();
            ample = imgMario.getWidth();
            prpAlt = 50;
            prpAmple = prpAlt * (ample / alt);
            gc.drawImage(imgMario, 400, 250, prpAmple, prpAlt);
            // Manté la proporció correcta amb alt = 50
                """;
        Controller.drawCodi(gc, codi, 450, 250);
    }
}