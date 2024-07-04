package com.project;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

interface GameObj {
    void run(GameController controller);
    void draw(GameController controller);
}
