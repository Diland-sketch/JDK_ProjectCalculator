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

    public void onButtonNums(Button button){
        txtNumeros.setText(txtNumeros.getText() + Bt_Five.getText());
    }

    public int obtenerNum(){
        int one, two, three, four, five, six, seven, eight, nine;
        one = Integer.parseInt(Bt_One.getText());
        return one;
    }

}
