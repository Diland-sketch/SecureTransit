module com.mycompany.secure.transitgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.base;

    opens com.mycompany.secure.transitgui to javafx.fxml;
    exports com.mycompany.secure.transitgui;
}
