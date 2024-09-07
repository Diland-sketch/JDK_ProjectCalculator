package com.co.jdk_calculator.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ViewCalculatorController {


    @FXML
    private Button Bt_Zero;
    @FXML
    private Button Bt_One;
    @FXML
    private Button Bt_Two;
    @FXML
    private Button Bt_Three;
    @FXML
    private Button Bt_Four;
    @FXML
    private Button Bt_Five;
    @FXML
    private Button Bt_Six;
    @FXML
    private Button Bt_Seven;
    @FXML
    private Button Bt_Eigth;
    @FXML
    private Button Bt_Nine;
    @FXML
    private Text txtNumeros;

    private int suma = 0;

    @FXML
    public void onButtonNums(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
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
