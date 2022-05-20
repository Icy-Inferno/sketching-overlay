package com.github.icy_inferno.sketching_overlay;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SketchingOverlayController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick()
    {
        welcomeText.setText("Welcome to JavaFX Application!");
        welcomeText.setStyle("-fx-text-fill: #90EE90;");
    }
}