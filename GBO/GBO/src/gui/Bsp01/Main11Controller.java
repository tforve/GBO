package gui.Bsp01;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class Main11Controller
{
    private int counter;

    private Label label1;

    public void buttonClicked(ActionEvent e)
    {
        counter++;
        label1.setText("Hallo Welt zum " + counter + ".");
    }
}