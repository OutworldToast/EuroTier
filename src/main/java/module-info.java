module com.example.eurotier {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.eurotier to javafx.fxml;
    exports com.example.eurotier;
    exports com.example.eurotier.Controllers;
    opens com.example.eurotier.Controllers to javafx.fxml;
    exports com.example.eurotier.Flagger;
    opens com.example.eurotier.Flagger to javafx.fxml;
    exports com.example.eurotier.Tracker;
    opens com.example.eurotier.Tracker to javafx.fxml;
}