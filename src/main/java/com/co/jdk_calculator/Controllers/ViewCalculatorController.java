package com.co.jdk_calculator.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ViewCalculatorController {

    @FXML
    private Text txtNumeros;
    private String operator = "";


    public void onButtonNums(javafx.event.ActionEvent event){
        Button clickedButton = (Button)event.getSource();
        txtNumeros.setText(txtNumeros.getText() + clickedButton.getText());
        System.out.println(txtNumeros.getText());
        try {
            int numero = Integer.parseInt(txtNumeros.getText());
            System.out.println("Número convertido: " + numero);
        } catch (NumberFormatException e) {
            System.out.println("Error");
        }
    }
    public void clearAllButton(javafx.event.ActionEvent event) {
        txtNumeros.setText("");

    }
    public void clearButton(javafx.event.ActionEvent event) {
        String currentText = txtNumeros.getText();
        if (currentText!=null && currentText.length() > 0){
            txtNumeros.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    @FXML
    private void handleOperatorClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonId = button.getId();
        String currentText = txtNumeros.getText();

        if (!currentText.isEmpty() && isOperatorWithSpaces(currentText.trim())) {
            return;
        }

        switch (buttonId) {
            case "btSuma":
                operator = " + ";
                break;
            case "btResta":
                operator = " - ";
                break;
            case "btMultiply":
                operator = " x ";
                break;
            case "btDivide":
                operator = " / ";
                break;
            default:
                operator = "";
                break;
        }

        if (!operator.isEmpty()) {
            txtNumeros.setText(currentText + operator);
        }
    }

    private boolean isOperatorWithSpaces(String text) {

        String[] parts = text.split(" ");
        if (parts.length == 0) {
            return false;
        }

        String lastSegment = parts[parts.length - 1];
        return lastSegment.equals("+") || lastSegment.equals("-") ||
                lastSegment.equals("x") || lastSegment.equals("/");
    }

}

