module com.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.project to javafx.fxml;
    exports com.project;
}