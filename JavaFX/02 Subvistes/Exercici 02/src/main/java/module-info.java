module com.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.json;
    //requires org.json;
    opens com.project to javafx.fxml;
    exports com.project;
    exports com.project.controllers;
    opens com.project.controllers to javafx.fxml;
}