package com.project.controllers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerItem implements Initializable {
    @FXML
    private Label titol;
    @FXML
    private ImageView imatge;

    public void setTitol(Label titol) {
        this.titol = titol;
    }

    public Label getTitol() {
        return titol;
    }

    public void setImatge(String imagePath) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            this.imatge.setImage(image); // Assigna la imatge al ImageView ja definit al FXML
        } catch (NullPointerException e) {
            System.err.println("Error carregant la imatge: " + imagePath);
            e.printStackTrace();
        }
    }


    public ImageView getImatge() {
        return imatge;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
