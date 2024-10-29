package com.project;

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

        if (!txtOperation.getText().equals("0")){
            txtOperation.setText(txtOperation.getText()+e.getSource().toString().charAt(e.getSource().toString().length()-2));
        }
        else if (txtOperation.getText().equals("0")){
            if (e.getSource()!=btnDot){
                txtOperation.setText(String.valueOf(e.getSource().toString().charAt(e.getSource().toString().length()-2)));
            }
            else{
                txtOperation.setText("0.");
            }
        }

    }

    @FXML
    void onClickC(ActionEvent e) {
        txtOperation.setText("0");
        txtResult.setText("0");
    }

    @FXML
    void onClickEqual(ActionEvent e) {
        String cadena = txtOperation.getText();
        String operador ="";
        int num1=0;
        int num2=0;
        boolean negative=false;
        if (!cadena.equals("0")){
            String numbers = "0123456789";
            for (int i =0;cadena.length()>i; i++){
                try{
                    if (numbers.contains(String.valueOf(cadena.charAt(i)))) {
                        if (operador.isBlank()){
                            num1=Integer.parseInt(String.valueOf(num1)+String.valueOf(cadena.charAt(i)));
                            System.out.println(num1);
                        }
                        else{
                            num2=Integer.parseInt(String.valueOf(num2)+String.valueOf(cadena.charAt(i)));
                            System.out.println(num2);
                        }
                    }
                    else {
                        if (operador.isBlank()){
                            operador= String.valueOf(cadena.charAt(i));
                        }else {

                            switch (operador){
                                case "+":
                                    num1=num1+num2;
                                    break;
                                case "-":

                                    num1=num1-num2;
                                    break;
                                case "*":
                                    num1=num1*num2;
                                    break;
                                case "/":
                                    num1=num1/num2;
                                    break;
                                case "^":
                                    num1=Integer.parseInt(String.valueOf(Math.pow(num1,num2)));
                                    break;

                            }
                            operador="";
                            num2=0;
                        }
                        System.out.println(operador);
                    }
                } catch (Exception ex) {
                    txtResult.setText("Error");
                }
            }
            System.out.println(num1+ operador+ num2);
            if (!operador.isEmpty()){

                try {
                    switch (operador) {
                        case "+":
                            num1 = num1 + num2;
                            break;
                        case "-":
                            num1 = num1 - num2;
                            break;
                        case "*":
                            num1 = num1 * num2;
                            break;
                        case "/":
                            num1 = (int) (num1 / num2);
                            break;
                        case "^":
                            num1 = (int) (Math.pow(num1, num2));
                            break;
                    }
                    if (!txtResult.getText().equals("Error")){
                        txtResult.setText(String.valueOf(num1));
                    }
                } catch (Exception ex) {
                    txtResult.setText("Error");
                }
            }
        }

    }

}
