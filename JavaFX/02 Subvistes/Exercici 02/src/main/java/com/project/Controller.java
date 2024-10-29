package com.project;

/*import org.json.JSONArray;
import org.json.JSONObject;*/
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //private JSONArray jsonInfo;
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

        }
    }

}
