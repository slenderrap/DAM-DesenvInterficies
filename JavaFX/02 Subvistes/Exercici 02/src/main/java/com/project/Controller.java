package com.project;

import jakarta.json.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Controller() {
    }

    @FXML
    private Label text;
    @FXML
    private Pane panel;
    @FXML
    private ChoiceBox<String> seleccion;

    //private ObjectProperty<ChoiceBox<String>> seleccion = new ObjectProperty<>(this, "seleccion");
//
//
    private final String[] opciones = {"Jocs", "Personatges", "Consola"};

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
        if (opcion.equals("Jocs")) {
            System.out.println("dentro");
            ArrayList<ArrayList<Object>> jocs = new ArrayList<>();
            File arxiu = new File(System.getProperty("user.dir"), "/JavaFX/02 Subvistes/Exercici 02/src/main/resources/assets/data/jocs.json");
            if (arxiu.exists() && arxiu.isFile()) {
                JsonReader jr = null;
                FileReader fr = null;
                try {
                    fr = new FileReader(arxiu);
                    jr = Json.createReader(fr);
                    JsonArray ja = jr.readArray();
                    System.out.println(ja.size());
                    for (JsonValue value : ja) {
                        ArrayList<Object> joc = new ArrayList<>();
                        JsonObject jo = (JsonObject) value;
                        String nom = jo.getString("nom");
                        int any = jo.getInt("any");
                        String tipus = jo.getString("tipus");
                        String descripcio = jo.getString("descripcio");
                        String rutaImatge = jo.getString("imatge");
                        joc.add(nom);
                        joc.add(any);
                        joc.add(tipus);
                        joc.add(descripcio);
                        joc.add(rutaImatge);
                        jocs.add(joc);
//
//                                                "nom": "Super Mario Bros",
//                                "any": 1985,
//                                "tipus": "Plataformes",
//                                "descripcio": "Super Mario Bros. és un icònic joc de plataformes creat per Nintendo. El jugador assumeix el paper de Mario o Luigi, i ha de recórrer nivells plens d'enemics i obstacles per rescatar la princesa Peach del malvat Bowser.",
//                                "imatge": "game_smb.png
                    }
                    URL resource = this.getClass().getResource("/assets/layoutItem.fxml");
                    for (int i = 0; i < jocs.size(); i++) {
                        FXMLLoader loader = new FXMLLoader(resource);
                        Parent itemTemplate = loader.load();


                    }
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
        }
    }
}
