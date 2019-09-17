package com.kodilla.ludoboardgame;

import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Display implements Initializable {
    private Text status;

    private void displayPosition(MouseEvent event){
        status.setText("X = " + event.getX() + "     Y = " + event.getY());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
