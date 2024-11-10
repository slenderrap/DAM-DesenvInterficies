package com.project;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ControllerItem {
    @FXML
    private Label titol;
    @FXML
    private ImageView imatge;

    public void setTitol(Label titol) {
        this.titol = titol;
    }

    public void setImatge(ImageView imatge) {
        this.imatge = imatge;
    }
}
