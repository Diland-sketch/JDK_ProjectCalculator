package com.co.jdk_calculator.Controllers;

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
}

