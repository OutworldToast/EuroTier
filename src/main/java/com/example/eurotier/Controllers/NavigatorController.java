package com.example.eurotier.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class NavigatorController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}