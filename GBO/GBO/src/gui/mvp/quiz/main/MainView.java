package gui.mvp.quiz.main;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class MainView extends BorderPane
{
    private BorderPane bPane;

    private Button undo, redo;

    private MainPresenter mainPresenter;

    public MainView()
    {
        initView();
    }

    private void initView()
    {
        bPane = new BorderPane();
        HBox topArea = new HBox(5);

        Button start = new Button("Quiz starten!");
        Button weiter = new Button("Quiz fortsetzen!");
        Button overview = new Button("\u00dcberblick!");
        Button edit = new Button("Quiz editieren!");
        undo = new Button("R\u00dcckg\u00dcngig!");
        redo = new Button("Wiederholen!");

        // zwischen Views hinundherschalten
        start.setOnAction(e -> start());
        weiter.setOnAction(e -> nextQ());
        overview.setOnAction(e -> overview());
        edit.setOnAction(e -> editorList());
        undo.setOnAction(e -> undo());
        redo.setOnAction(e -> redo());

        overview.setId("overview");

        undo.setId("undo");
        redo.setId("redo");

        topArea.getChildren().addAll(start, weiter, overview, edit, undo, redo);
        bPane.setTop(topArea);
    }

    private void redo()
    {
        mainPresenter.inputOld();
        mainPresenter.undo();
    }

    private void undo()
    {
        mainPresenter.redo();
    }

    private void overview()
    {
        undo.setDisable(true);
        redo.setDisable(true);
        mainPresenter.showOverviewView();
    }

    public void start()
    {
        undo.setDisable(true);
        redo.setDisable(true);
        mainPresenter.showQuiz(true);
    }

    public void nextQ()
    {
        undo.setDisable(true);
        redo.setDisable(true);
        mainPresenter.showQuiz(false);
    }

    public void editorList()
    {
        undo.setDisable(false);
        redo.setDisable(false);
        mainPresenter.showEditorView();
    }

    public void setPresenter(MainPresenter mainP)
    {
        mainPresenter = mainP;
    }

    public void setContent(Pane pane)
    {
        bPane.setCenter(pane);
    }

    public Pane getView()
    {
        undo.setDisable(true);
        redo.setDisable(true);
        return bPane;
    }

}
