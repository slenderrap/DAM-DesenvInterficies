package com.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.ResourceBundle;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import java.lang.classfile.Label;
import java.util.ArrayList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {

    @FXML
    private Button buttonAnimals, buttonBrands, buttonFXML;
    @FXML
    private AnchorPane container;
    @FXML
    private VBox yPane = new VBox();

    private String animals[] = { "Dog", "Cat", "Horse", "Cow", "Pig" };
    private String brands[] = { "Audi", "BMW", "Citroen", "Fiat", "Ford", "Honda", "Hyundai", "Kia", "Mazda", "Mercedes",
            "Nissan", "Opel", "Peugeot", "Renault", "Seat", "Skoda", "Suzuki", "Toyota", "Volkswagen", "Volvo" };

    private JSONArray jsonInfo;

    // Called when the FXML file is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            URL jsonFileURL = getClass().getResource("/assets/animals.json");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(jsonFileURL.openStream(), StandardCharsets.UTF_8));
            StringBuilder jsonText = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonText.append(line);
            }
            reader.close();

            // Parseja el contingut del JSON
            jsonInfo = new JSONArray(jsonText.toString());

            // Actualitza la UI amb els valors inicials dels animals
            setAnimals(null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void setAnimals(ActionEvent event) {
        ArrayList<String> list = new ArrayList<>();
        for (String name : animals) {
            list.add(name);
        }

        yPane.getChildren().clear();
        for (String s : list) {
            Label label = new Label(s);
            label.setStyle("-fx-border-color: red;");
            yPane.getChildren().add(label);
        }

    }

    @FXML
    private void setBrands(ActionEvent event) {
        // Exemple de com pots continuar utilitzant altres funcions
        String[] brands = { "Audi", "BMW", "Citroen", "Fiat", "Ford", "Honda", "Hyundai", "Kia", "Mazda", "Mercedes",
                "Nissan", "Opel", "Peugeot", "Renault", "Seat", "Skoda", "Suzuki", "Toyota", "Volkswagen", "Volvo" };

        yPane.getChildren().clear();
        for (String s : brands) {
            Label label = new Label(s);
            label.setStyle("-fx-border-color: black;");
            yPane.getChildren().add(label);
        }
    }

    @FXML
    private void setFXML(ActionEvent event) throws Exception {

        // Obtenir el recurs del template .fxml
        URL resource = this.getClass().getResource("/assets/listItem.fxml");

        // Netejar el contingut existent
        yPane.getChildren().clear();

        // Iterar sobre els elements del JSONArray 'jsonInfo' (ja carregat a initialize)
        for (int i = 0; i < jsonInfo.length(); i++) {
            // Obtenir l'objecte JSON individual (animal)
            JSONObject animal = jsonInfo.getJSONObject(i);

            // Extreure la informació necessària del JSON
            String category = animal.getString("category");
            String name = animal.getString("animal");
            String color = animal.getString("color");

            // Carregar el template de 'listItem.fxml'
            FXMLLoader loader = new FXMLLoader(resource);
            Parent itemTemplate = loader.load();
            ControllerListItem itemController = loader.getController();

            // Assignar els valors als controls del template
            itemController.setTitle(name);
            itemController.setSubtitle(category);
            itemController.setCircleColor(color);

            // Afegir el nou element a 'yPane'
            yPane.getChildren().add(itemTemplate);
        }
    }

}