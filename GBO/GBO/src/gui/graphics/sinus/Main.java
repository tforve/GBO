package gui.graphics.sinus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Pane root = new Pane();

        SinusPresenter sinusPresenter = new SinusPresenter();
        SinusView sinusView = new SinusView();
        SinusModel sinusModel = new SinusModel();

        sinusPresenter.setView(sinusView);
        sinusPresenter.setModel(sinusModel);
        sinusView.setPresenter(sinusPresenter);

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Sinus");
        stage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
