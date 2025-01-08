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
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
                ArrayList<Jocs> jocs = carregarJSON("/src/main/resources/assets/data/jocs.json", Jocs::fromJson);
                mostrarItems(jocs);
                break;
            case "Personatges":
                ArrayList<Personatge> personatges = carregarJSON("/src/main/resources/assets/data/personatges.json", Personatge::fromJson);
                mostrarItems(personatges);
                break;
            case "Consoles":
                ArrayList<Consoles> consoles = carregarJSON("/src/main/resources/assets/data/consoles.json", Consoles::fromJson);
                mostrarItems(consoles);
                break;
            default:
                System.out.println("Opció no reconeguda.");
        }
    }

    private <T> ArrayList<T> carregarJSON(String ruta, Function<JsonObject, T> deserializer) {
        ArrayList<T> items = new ArrayList<T>();
        File arxiu = new File(System.getProperty("user.dir"), ruta);
        System.out.println(System.getProperty("user.dir"));
        if (arxiu.exists() && arxiu.isFile()) {
            JsonReader jr = null;
            FileReader fr = null;
            try {
                fr = new FileReader(arxiu);
                jr = Json.createReader(fr);
                JsonArray ja = jr.readArray();
                System.out.println(ja.size());
                for (JsonValue value : ja) {
                    JsonObject jo = (JsonObject) value;
                    System.out.println("\nitem afegit " + jo);
                    items.add(deserializer.apply(jo));
                }
                return items;
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (fr != null) {
                        fr.close();
                    }
                    if (jr != null) {
                        jr.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        else {
            System.out.println("arxiu incorrecte");
        }
        return items;
    }

    private <T> void mostrarItems(ArrayList<T> items) {
        itemContainer.getChildren().clear();
        URL resource = getClass().getResource("/assets/layoutItem.fxml");
        System.out.print(items.size());

        for (T item : items) {
            try {
                FXMLLoader loader = new FXMLLoader(resource);
                Parent itemNode = loader.load();
                // Assigna el controlador per a cada item.
                ControllerItem controladorItem = loader.getController();
                if (item instanceof Jocs) {
                    Jocs joc = (Jocs) item;
                    controladorItem.getTitol().setText(joc.getNom());
                    ImageView image = new ImageView(getClass().getResource("/assets/images"+joc.getImatge()).toURI().toString());
                    controladorItem.setImatge(image);
                } else if (item instanceof Personatge) {
                    Personatge personatge = (Personatge) item;
                    controladorItem.getTitol().setText(personatge.getNom());
                    String imagePath = "/assets/images/" + personatge.getImatge();
                    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
                    controladorItem.setImatge(new ImageView(image));
                } else if (item instanceof Consoles) {
                    Consoles consola = (Consoles) item;
                    controladorItem.getTitol().setText(consola.getNom());
                    String imagePath = "/assets/images/" + consola.getImatge();
                    Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(imagePath)));
                    controladorItem.setImatge(new ImageView(image));
                }

                // Afegim l'item al contenidor.
                itemContainer.getChildren().add(itemNode);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
