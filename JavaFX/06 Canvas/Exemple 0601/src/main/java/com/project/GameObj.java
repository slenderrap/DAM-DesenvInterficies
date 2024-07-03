package com.project;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

interface GameObj {
    void run(Canvas cnv, double fps, GameData data);
    void draw(GraphicsContext gc, GameData data);
}
