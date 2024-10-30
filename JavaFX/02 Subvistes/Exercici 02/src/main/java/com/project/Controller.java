package com.project;

//import com.google.gson.JsonParser;
import jakarta.json.JsonReader;
import jakarta.json.JsonArray;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public Label text;
    @FXML
    private ChoiceBox<String> seleccion;


    private final String[] opciones = {"Jocs","Personatges","Consola"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        seleccion.getItems().addAll(opciones);
        seleccion.setOnAction(this::cambiarVista);

    }

    private void cambiarVista(ActionEvent event) {
        String opcion = seleccion.getValue();
        if (opcion.equals("Jocs")){
            File arxiu = new File(System.getProperty("user.dir"),"/src/main/resources/assets/data"+File.separator+"jocs.json");
            if (arxiu.exists() && arxiu.isFile()){
                JsonReader jr = null;
                try {
                    jr = Json.createReader(new FileReader(arxiu));
                    JsonArray ja = jr.readArray();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

}
