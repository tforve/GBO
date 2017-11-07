package gui.Ubeung4;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Aufgabe1 extends Application
{
    private Pane root = new Pane();

    private double sizeX, sizeY;

    public void start(Stage primaryStage)
    {

        root.widthProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldSize, Number newSize)
            {
                // sizeX = (double) newSize;
                root.getChildren().clear();
                changeSize();

            }

        });

        root.heightProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldSize, Number newSize)
            {
                // sizeY = (double) newSize;
                root.getChildren().clear();
                changeSize();

            }

        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pane Aufgabe");
        primaryStage.show();

    }

    double lerp(double v0, double v1, double t)
    {
        return v0 + t * (v1 - v0);
    }

    public void changeSize()
    {

        Number width = root.widthProperty().getValue();
        Number height = root.heightProperty().getValue();

        // Button btn = new Button("Button");
        // double oldBtnX = btn.getWidth();
        // double oldBtnY = btn.getHeight();

        for (int i = 0; i < 10; i++)
        {
            Button btn = new Button("Button " + i);
            // Button btn = (Button) root.getChildren().get(i);
            btn.setLayoutX(lerp(0, (double) width - 75, i / 9));
            btn.setLayoutY(lerp(0, (double) height - 25, i / 9));

            root.getChildren().add(btn);
        }

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
