module com.example.crescimentopopulacional {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.crescimentopopulacional to javafx.fxml;
    exports com.example.crescimentopopulacional;
}