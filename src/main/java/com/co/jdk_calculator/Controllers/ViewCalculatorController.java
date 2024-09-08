package com.co.jdk_calculator.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class ViewCalculatorController {

    @FXML
    private Text txtNumeros;
    private String operator = "";
    private double primerNumber = 0;
    private boolean nuevoNumero = true;


    public void onButtonNums(javafx.event.ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        if (nuevoNumero) {
            txtNumeros.setText("");
            nuevoNumero = false;
        }
        txtNumeros.setText(txtNumeros.getText() + clickedButton.getText());

    }

    public void clearAllButton(javafx.event.ActionEvent event) {
        txtNumeros.setText("");
        operator = "";
        primerNumber = 0;
        nuevoNumero = true;

    }

    public void clearButton(javafx.event.ActionEvent event) {
        String currentText = txtNumeros.getText();
        if (currentText != null && currentText.length() > 0) {
            txtNumeros.setText(currentText.substring(0, currentText.length() - 1));
        }
    }

    @FXML
    private void handleOperatorClick(ActionEvent event) {
        Button button = (Button) event.getSource();
        String buttonId = button.getId();
        String currentText = txtNumeros.getText();

        if (!currentText.isEmpty()) {
            try {
                primerNumber = Double.parseDouble(currentText);
                nuevoNumero = true;
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir numero");
            }
        }

        switch (buttonId) {
            case "btSuma":
                operator = "+";
                break;
            case "btResta":
                operator = "-";
                break;
            case "btMultiply":
                operator = "x";
                break;
            case "btDivide":
                operator = "/";
                break;
            default:
                operator = "";
                break;
        }

        if (!operator.isEmpty()) {
            txtNumeros.setText(currentText + "" + operator + "");
        }
    }

    public void igualButton(ActionEvent event) {
        System.out.println("Estoy funcionando");
        String currentText = txtNumeros.getText().trim();

        if (!currentText.isEmpty() && !operator.isEmpty()) {

                try {
                    double secondNumber = Double.parseDouble(
                            currentText.substring(currentText.indexOf(operator) + 1));
                    double result = 0.0;
                    switch (operator) {
                        case "+":
                            result = primerNumber + secondNumber;
                            break;
                        case "-":
                            result = primerNumber - secondNumber;
                            break;
                        case "x":
                            result = primerNumber * secondNumber;
                            break;
                        case "/":
                            if (secondNumber != 0) {
                                result = primerNumber / secondNumber;
                            } else {
                                txtNumeros.setText("Error: División por 0");
                                return;
                            }
                            break;
                    }
                    txtNumeros.setText(String.valueOf(result));
                    System.out.println(String.valueOf(result));
                    operator = "";
                    nuevoNumero = true;
                } catch (NumberFormatException e) {
                    txtNumeros.setText("Error: No se pudo realizar la operación");
                }

        }
    }


}

