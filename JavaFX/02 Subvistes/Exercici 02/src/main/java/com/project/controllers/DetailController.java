package com.project.controllers;

import com.project.models.Consoles;
import com.project.models.Jocs;
import com.project.models.Personatge;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class DetailController {

    @FXML
    private VBox contenidor;
    @FXML
    private ImageView imatge;

    @FXML
    private Label nom;

    @FXML
    private Text descripcio;

    @FXML
    private VBox detallsAdicionals; // Contenedor dinámico


    public void showDetails(Object item) {
        // Limpiar el contenedor de detalles adicionales
        detallsAdicionals.getChildren().clear();

        // Cargar la imagen
        String imgPath = "/assets/images/";
        if (item instanceof Jocs joc) {
            imgPath += joc.getImatge();
            nom.setText(joc.getNom());
            descripcio.setText(joc.getDescripcio());
            detallsAdicionals.widthProperty().addListener((obs, oldVal, newVal) -> {
                // Ajustar el wrappingWidth del texto al ancho del contenedor menos un margen
                descripcio.setWrappingWidth(newVal.doubleValue() - 50); // Restar margen
            });

            detallsAdicionals.getChildren().addAll(
                    createField("Tipus", joc.getTipus()),
                    createField("Any", String.valueOf(joc.getAny()))
            );

        } else if (item instanceof Consoles consola) {
            imgPath += consola.getImatge();
            nom.setText(consola.getNom());
            detallsAdicionals.getChildren().addAll(
                    createField("Procesador", consola.getProcesador()),
                    createField("Ventas", String.valueOf(consola.getVenudes())),
                    createField("data", consola.getData())
            );

        } else if (item instanceof Personatge personatge) {
            imgPath += personatge.getImatge();
            nom.setText(personatge.getNom());
            detallsAdicionals.getChildren().addAll(
                    createField("Color", personatge.getColor()),
                    createField("Joc", personatge.getNomVideojoc()));
            applyBackgroundColor(personatge.getColor());
        }

        // Cargar la imagen
        Image image = new Image(getClass().getResource(imgPath).toExternalForm());
        imatge.setImage(image);
    }

    // Método auxiliar para crear un campo con formato "clave: valor"
    private HBox createField(String key, String value) {
        // Crear la clave (en negrita)
        Label keyLabel = new Label(key + ": ");
        keyLabel.setStyle("-fx-alignment: center; -fx-font-weight: bold; -fx-font-size: 14px; ");

        // Crear el valor
        Label valueLabel = new Label(value);
        valueLabel.setStyle("-fx-font-size: 14px; -fx-alignment: CENTER; ");

        // Crear un HBox para contener ambos labels
        HBox hbox = new HBox(5); // Espaciado de 5px entre los elementos
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(keyLabel, valueLabel);

        return hbox;
    }

    private void applyBackgroundColor(String color) {
        // Convertir el color a un formato compatible con JavaFX
        try {

            contenidor.setStyle("-fx-background-color: " + color + ";");
        } catch (IllegalArgumentException e) {
            System.err.println("Color no válido: " + color);
        }
    }
}