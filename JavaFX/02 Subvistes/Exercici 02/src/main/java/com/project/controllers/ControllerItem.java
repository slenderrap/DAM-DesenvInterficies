package com.project.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ControllerItem implements Initializable {
    @FXML
    private Label titol;
    @FXML
    private ImageView imatge;

    @FXML
    HBox root; // Asegúrate de que el HBox principal tenga fx:id="root" en layoutItem.fxml

    public void setTitol(Label titol) {
        this.titol = titol;
    }

    public Label getTitol() {
        return titol;
    }

    public void setImatge(String imagePath) {
        try {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
            this.imatge.setImage(image);
        } catch (NullPointerException e) {
            System.err.println("Error carregant la imatge: " + imagePath);
            e.printStackTrace();
        }
    }

    public ImageView getImatge() {
        return imatge;
    }

    // Método para configurar el cambio de color al pasar el cursor
    public void setupHoverEffect() {
        // Estilo base al cargar el elemento
        root.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5, 0.0, 0, 1);");

        root.setOnMouseEntered(event -> {
            root.setStyle("-fx-background-color: #e0e0e0; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5, 0.0, 0, 1);");
        });

        root.setOnMouseExited(event -> {
            root.setStyle("-fx-background-color: white; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 5, 0.0, 0, 1);");
        });

        // Evento de clic
        root.setOnMouseClicked(event -> {
            // Aquí puedes lanzar la pantalla de detalle
            // Por ahora, solo mostramos un mensaje en la terminal
            System.out.println("Elemento seleccionado: " + titol.getText());
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Inicialización si es necesario
    }
}