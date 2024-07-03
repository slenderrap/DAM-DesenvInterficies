package com.project;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
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

    String animals[] = { "Dog", "Cat", "Horse", "Cow", "Pig" };
    String brands[] = { "Audi", "BMW", "Citroen", "Fiat", "Ford", "Honda", "Hyundai", "Kia", "Mazda", "Mercedes",
            "Nissan", "Opel", "Peugeot", "Renault", "Seat", "Skoda", "Suzuki", "Toyota", "Volkswagen", "Volvo" };

    // Called when the FXML file is loaded
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setAnimals(null);
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
        ArrayList<String> list = new ArrayList<>();
        for (String name : brands) {
            list.add(name);
        }

        yPane.getChildren().clear();
        for (String s : list) {
            Label label = new Label(s);
            label.setStyle("-fx-border-color: black;");
            yPane.getChildren().add(label);
        }
    }

    @FXML
    private void setFXML(ActionEvent event) throws Exception {

        // List of two strings with spices and animals
        String[][] list = new String[][] {
                new String[] { "Mamals", "Dod", "black" },
                new String[] { "Mamals", "Cat", "grey" },
                new String[] { "Mamals", "Horse", "brown" },
                new String[] { "Mamals", "Cow", "white" },
                new String[] { "Mamals", "Pig", "pink" },
                new String[] { "Birds", "Pidgeon", "grey" },
                new String[] { "Birds", "Duck", "white" },
                new String[] { "Birds", "Eagle", "brown" },
                new String[] { "Birds", "Owl", "black" },
                new String[] { "Birds", "Parrot", "green" },
                new String[] { "Fish", "Goldfish", "orange" },
                new String[] { "Fish", "Shark", "grey" },
                new String[] { "Fish", "Tuna", "silver" },
                new String[] { "Fish", "Salmon", "pink" },
                new String[] { "Fish", "Cod", "white" },
                new String[] { "Reptiles", "Snake", "black" },
                new String[] { "Reptiles", "Lizard", "green" },
                new String[] { "Reptiles", "Turtle", "brown" },
                new String[] { "Reptiles", "Crocodile", "grey" },
                new String[] { "Reptiles", "Alligator", "green" },
                new String[] { "Amphibians", "Frog", "green" },
                new String[] { "Amphibians", "Toad", "brown" },
                new String[] { "Amphibians", "Salamander", "grey" },
                new String[] { "Amphibians", "Newt", "brown" },
                new String[] { "Amphibians", "Axolotl", "pink" }
        };

        // Load the .fxml template
        URL resource = this.getClass().getResource("/assets/listItem.fxml");

        // Clear the destination
        yPane.getChildren().clear();

        // For each list item
        for (String[] listElement : list) {

            // Create a new element from 'listItem.fxml'
            FXMLLoader loader = new FXMLLoader(resource);
            Parent itemTemplate = loader.load();
            ControllerListItem itemController = loader.getController();

            // Set element values with information from 'listElement'
            itemController.setTitle(listElement[1]);
            itemController.setSubtitle(listElement[0]);
            itemController.setCircleColor(listElement[2]);

            // Add the new element to 'yPane'
            yPane.getChildren().add(itemTemplate);
        }
    }
}