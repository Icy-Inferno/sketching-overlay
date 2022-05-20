package com.github.icy_inferno.sketching_overlay;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SketchingOverlay extends Application
{
    @Override
    public void start(Stage mainStage)
    {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        final StackPane root = new StackPane();
        final Scene scene = new Scene(root, screenBounds.getWidth(), screenBounds.getHeight());
        final Canvas canvas = new Canvas(screenBounds.getWidth(), screenBounds.getHeight());
        final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();

        setUpSketchWindow(root, mainStage, scene, canvas, graphicsContext);

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        graphicsContext.beginPath();
                        graphicsContext.moveTo(event.getX(), event.getY());
                        graphicsContext.stroke();
                    }
                });

        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        // Draw mouse cursor path
                        graphicsContext.lineTo(event.getX(), event.getY());
                        graphicsContext.stroke();
                    }
                });

        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED,
                new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        graphicsContext.closePath();
                    }
                });

        mainStage.setTitle("Sketching Overlay");
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void setUpSketchWindow(StackPane root, Stage mainStage, Scene scene, Canvas canvas, GraphicsContext graphicsContext)
    {
        root.getChildren().add(canvas);
        mainStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        scene.getStylesheets().add(SketchingOverlay.class.getResource("sketching-overlay-view.css").toString());
        graphicsContext.setStroke(Color.RED);
        graphicsContext.setLineWidth(1);
    }
}