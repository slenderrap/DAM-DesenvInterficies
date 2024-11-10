package com.project;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    final int WINDOW_WIDTH = 700;
    final int WINDOW_HEIGHT = 500;
    final int MIN_WIDTH = 400;
    final int MIN_HEIGHT = 400;

    @Override
    public void start(Stage stage) throws Exception {

        // Carrega la vista inicial des del fitxer FXML
        UtilsViews.parentContainer.setStyle("-fx-font: 14 arial;");
        UtilsViews.addView(getClass(), "Desktop", "/assets/layoutDesktop.fxml");
        UtilsViews.addView(getClass(), "Mobile", "/assets/layoutMobile.fxml");
        //UtilsViews.addView(getClass(), "Item", "/assets/layoutItem.fxml");


        Scene scene = new Scene(UtilsViews.parentContainer);

        scene.widthProperty().addListener((ChangeListener<? super Number>) new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                _setLayout(t1.intValue());
            }
        });

        stage.setScene(scene);
        stage.setTitle("JavaFX App");
        stage.setMinWidth(MIN_WIDTH);
        stage.setWidth(WINDOW_WIDTH);
        stage.setMinHeight(MIN_HEIGHT);
        stage.setHeight(WINDOW_HEIGHT);
        stage.show();



        stage.widthProperty().addListener((observableValue, number, t1) ->
                //observableValue es l'objecte observer, number la mida antiga i la t1 es la nova
                        System.out.println("Amplada: "+t1 )
                );


        // Afegeix una icona només si no és un Mac
        if (!System.getProperty("os.name").contains("Mac")) {
            Image icon = new Image("file:icons/icon.png");
            stage.getIcons().add(icon);
        }
    }

    public void _setLayout(int width){
        if (width<600){
            System.err.println("cambia a mobil");
            UtilsViews.setView("Mobile");
        }else {
            System.err.println("Cambia a desktop");
            UtilsViews.setView("Desktop");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }



}
