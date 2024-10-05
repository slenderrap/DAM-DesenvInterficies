package com.project;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CtrlConfig implements Initializable {

    @FXML
    public TextField txtHost;

    @FXML
    public TextField txtPort;

    @FXML
    public Label txtMessage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    private Runnable callbackConnectToServer;

    @FXML
    private void connectToServer() {
        if (callbackConnectToServer != null) {
            callbackConnectToServer.run();
        }
    }

    public void setCallbackConnectToServer(Runnable callback) {
        this.callbackConnectToServer = callback;
    }
}