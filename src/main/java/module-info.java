module com.example.cadastrocliente {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.cadastrocliente to javafx.fxml;
}