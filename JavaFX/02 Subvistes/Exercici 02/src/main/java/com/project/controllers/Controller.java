package com.project.controllers;

import com.project.models.Consoles;
import com.project.models.Jocs;
import com.project.models.Personatge;
import jakarta.json.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.function.Function;

public class Controller implements Initializable {

    public Controller() {
    }

    @FXML
    private Label text;
    @FXML
    private Pane panel;
    @FXML
    private ChoiceBox<String> seleccion;
    @FXML
    private VBox itemContainer;

    //private ObjectProperty<ChoiceBox<String>> seleccion = new ObjectProperty<>(this, "seleccion");
//
//
    private final String[] opciones = {"Jocs", "Personatges", "Consoles"};

    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if (seleccion != null) {
            seleccion.getItems().addAll(opciones);
            seleccion.setValue(opciones[0]);
            seleccion.setOnAction(this::cambiarVista);

        }


    }

    //
    private void cambiarVista(ActionEvent event) {
        String opcion = seleccion.getValue();
        switch (opcion) {
            case "Jocs":
                ArrayList<Jocs> jocs = carregarJSON("/assets/data/jocs.json", Jocs::fromJson);
                mostrarItems(jocs);
                break;
            case "Personatges":
                ArrayList<Personatge> personatges = carregarJSON("/assets/data/personatges.json", Personatge::fromJson);
                mostrarItems(personatges);
                break;
            case "Consoles":
                ArrayList<Consoles> consoles = carregarJSON("/assets/data/consoles.json", Consoles::fromJson);
                mostrarItems(consoles);
                break;
            default:
                System.out.println("Opció no reconeguda.");
        }
    }

    private <T> ArrayList<T> carregarJSON(String ruta, Function<JsonObject, T> deserializer) {
        ArrayList<T> items = new ArrayList<>();
        try (InputStream inputStream = getClass().getResourceAsStream(ruta)) {
            if (inputStream == null) {
                System.out.println("Archivo no encontrado: " + ruta);
                return items;
            }

            JsonReader jr = Json.createReader(inputStream);
            JsonArray ja = jr.readArray();
            for (JsonValue value : ja) {
                JsonObject jo = (JsonObject) value;
                items.add(deserializer.apply(jo));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }
    private <T> void mostrarItems(ArrayList<T> items) {
        itemContainer.getChildren().clear();
        URL resource = getClass().getResource("/assets/layoutItem.fxml");

        for (T item : items) {
            try {
                FXMLLoader loader = new FXMLLoader(resource);
                Parent itemNode = loader.load();
                ControllerItem controllerItem = loader.getController();

                if (item instanceof Jocs joc) {
                    controllerItem.getTitol().setText(joc.getNom());
                    String imgPath = "/assets/images/" + joc.getImatge();
                    controllerItem.setImatge(imgPath);
                } else if (item instanceof Personatge personatge) {
                    controllerItem.getTitol().setText(personatge.getNom());
                    String imgPath = "/assets/images/" + personatge.getImatge();
                    controllerItem.setImatge(imgPath);
                } else if (item instanceof Consoles consola) {
                    controllerItem.getTitol().setText(consola.getNom());
                    String imgPath = "/assets/images/" + consola.getImatge();
                    controllerItem.setImatge(imgPath);
                }

                // Configurar el efecto hover
                controllerItem.setupHoverEffect();

                // Asignar evento de clic para abrir la pantalla de detalle
                // Asignar evento de clic para abrir la pantalla de detalle
                controllerItem.root.setOnMouseClicked(event -> {
                    try {
                        // Cargar la pantalla de detalle
                        FXMLLoader detailLoader = new FXMLLoader(getClass().getResource("/assets/layoutDetailsItem.fxml")); // Cambio aquí
                        Parent detailView = detailLoader.load();
                        DetailController detailController = detailLoader.getController();

                        // Pasar los datos del personaje seleccionado
                        detailController.showDetails(item);

                        // Mostrar la pantalla de detalle
                        Stage stage = new Stage();
                        stage.setTitle("Detalles del Elemento");
                        stage.setScene(new Scene(detailView));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                // Agregar el elemento al contenedor
                itemContainer.getChildren().add(itemNode);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
