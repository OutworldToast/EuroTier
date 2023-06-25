module com.example.eurotier {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eurotier to javafx.fxml;
    exports com.example.eurotier;
}