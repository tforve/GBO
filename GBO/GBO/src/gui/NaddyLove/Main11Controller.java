package gui.NaddyLove;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Main11Controller
{
    private int counter;

    @FXML
    private Label label;

    public void buttonClicked(ActionEvent e)
    {
        counter++;
        label.setText("Love Naddys Design " + counter + ".");
    }
}
