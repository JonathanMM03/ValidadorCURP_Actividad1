module org.utl.validador {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.utl.validador to javafx.fxml;
    exports org.utl.validador;
}