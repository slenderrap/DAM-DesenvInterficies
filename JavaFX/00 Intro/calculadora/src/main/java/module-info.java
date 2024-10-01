module com.project.calculadora {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;



    opens com.project.calculadora to javafx.fxml;
    exports com.project.calculadora;
}