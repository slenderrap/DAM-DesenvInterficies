module com.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.json;
    //requires org.json;
    opens com.project to javafx.fxml;
    exports com.project;
}