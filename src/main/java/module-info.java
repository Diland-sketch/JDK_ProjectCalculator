module com.example.jdk_calculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.co.jdk_calculator to javafx.fxml;
    exports com.co.jdk_calculator;
}