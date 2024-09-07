package com.co.jdk_calculator.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ViewCalculatorController {
    @FXML
    private Text txtNumeros;
    private String operator = "";
    private double firstNumber = 0;
    private boolean startNewNumber = true;


    public void onButtonNums(javafx.event.ActionEvent event){
        Button clickedButton = (Button)event.getSource();
        txtNumeros.setText(txtNumeros.getText() + clickedButton.getText());
    }

    @FXML
    private void handleOperatorClick(ActionEvent event){
        Button button = (Button) event.getSource();
        String buttonId = button.getId();

        switch (buttonId) {
            case "btSuma":
                operator = "+";
                txtNumeros.setText(txtNumeros.getText() + operator);
                break;
            case "btResta":
                operator = "-";
                txtNumeros.setText(txtNumeros.getText() + operator);
                break;
            case "btMultiply":
                operator = "*";
                txtNumeros.setText(txtNumeros.getText() + operator);
                break;
            case "btDivide":
                operator = "/";
                txtNumeros.setText(txtNumeros.getText() + operator);
                break;
        }
    }
}
