package com.project.calculadora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controlador {

    @FXML
    private Button btn0;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btnC;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnDiv;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnEqual;

    @FXML
    private Button btnMult;

    @FXML
    private Button btnOpen;

    @FXML
    private Button btnPlus;

    @FXML
    private Button btnRaise;

    @FXML
    private Button btnSub;

    @FXML
    private Label txtOperation;

    @FXML
    private Label txtResult;

    @FXML
    void addValue(ActionEvent e) {
        System.out.println(e.getSource());

    }

    @FXML
    void onClickC(ActionEvent e) {

    }

    @FXML
    void onClickEqual(ActionEvent e) {

    }

}
