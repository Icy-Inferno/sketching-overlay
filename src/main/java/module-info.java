module com.github.icy_inferno.sketching_overlay {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.icy_inferno.sketching_overlay to javafx.fxml;
    exports com.github.icy_inferno.sketching_overlay;
}