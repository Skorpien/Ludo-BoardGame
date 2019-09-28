package com.kodilla.ludoboardgame;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    //private  static List<BoardField> blueFields = new ArrayList<>(44);
    private List<Pawn> bluePlayer = new ArrayList<>();
    private List<Pawn> redPlayer = new ArrayList<>();
    private List<Pawn> greenPlayer = new ArrayList<>();
    private List<Pawn> yellowPlayer = new ArrayList<>();
    private GridPane gridPane = new GridPane();
    private Image image = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\ludo-board.jpg");
    private BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    private BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    private Background background = new Background(backgroundImage);

    public void setBoard () {

        gridPane.setPadding(new Insets(37, 10, 20, 13));
        gridPane.setHgap(75.0);
        gridPane.setVgap(75.0);
        gridPane.setBackground(background);
        gridPane.setGridLinesVisible(true);
        gridPane.setOnMouseClicked((event) -> {
            System.out.println(event.getX() + " " + event.getY());
        });
        Button first = new Button();
        Button last = new Button();
        gridPane.add(first, 0,0,2,2);
        gridPane.add(last,20,10,2,2);
       blue();
       red();
       green();
       yellow();
    }


    public void blue () {
        Pawn blue1 = new Pawn("Blue", true, 0);
        Pawn blue2 = new Pawn("Blue", true, 0);
        Pawn blue3 = new Pawn("Blue", true, 0);
        Pawn blue4 = new Pawn("Blue", true, 0);
        gridPane.add(blue1.getPawn(), 5, 0, 2, 2);
        gridPane.add(blue2.getPawn(), 5, 1, 2, 2);
        gridPane.add(blue3.getPawn(), 6, 0, 2, 2);
        gridPane.add(blue4.getPawn(), 6, 1, 2, 2);
        bluePlayer.add(blue1);
        bluePlayer.add(blue2);
        bluePlayer.add(blue3);
        bluePlayer.add(blue4);
    }

    public void red () {
        Pawn red1 = new Pawn("Red", true, 0);
        Pawn red2 = new Pawn("Red", true, 0);
        Pawn red3 = new Pawn("Red", true, 0);
        Pawn red4 = new Pawn("Red", true, 0);
        gridPane.add(red1.getPawn(), 14, 0, 2, 2);
        gridPane.add(red2.getPawn(), 14, 1, 2, 2);
        gridPane.add(red3.getPawn(), 15, 0, 2, 2);
        gridPane.add(red4.getPawn(), 15, 1, 2, 2);
        redPlayer.add(red1);
        redPlayer.add(red2);
        redPlayer.add(red3);
        redPlayer.add(red4);
    }
    public void green () {
        Pawn green1 = new Pawn("Green", true, 0);
        Pawn green2 = new Pawn("Green", true, 0);
        Pawn green3 = new Pawn("Green", true, 0);
        Pawn green4 = new Pawn("Green", true, 0);
        gridPane.add(green1.getPawn(), 14, 9, 2, 2);
        gridPane.add(green2.getPawn(), 14, 10, 2, 2);
        gridPane.add(green3.getPawn(), 15, 9, 2, 2);
        gridPane.add(green4.getPawn(), 15, 10, 2, 2);
        greenPlayer.add(green1);
        greenPlayer.add(green2);
        greenPlayer.add(green3);
        greenPlayer.add(green4);
    }
    public void yellow () {
        Pawn yellow1 = new Pawn("Yellow", true, 0);
        Pawn yellow2 = new Pawn("Yellow", true, 0);
        Pawn yellow3 = new Pawn("Yellow", true, 0);
        Pawn yellow4 = new Pawn("Yellow", true, 0);
        gridPane.add(yellow1.getPawn(), 5, 9, 2, 2);
        gridPane.add(yellow2.getPawn(), 5, 10, 2, 2);
        gridPane.add(yellow3.getPawn(), 6, 9, 2, 2);
        gridPane.add(yellow4.getPawn(), 6, 10, 2, 2);
        yellowPlayer.add(yellow1);
        yellowPlayer.add(yellow2);
        yellowPlayer.add(yellow3);
        yellowPlayer.add(yellow4);
    }

   /* public void compMoveBoard () {
        redPlayer.get(0).compMove();
    }*/

    public GridPane getGridPane() {
        return gridPane;
    }

/*    public  static List<BoardField> getBlueFields() {
        return blueFields;
    }*/

    public List<Pawn> getBluePlayer() {
        return bluePlayer;
    }
    public List<Pawn> getRedPlayer() {
        return redPlayer;
    }
    public List<Pawn> getGreenPlayer() {
        return greenPlayer;
    }
    public List<Pawn> getYellowPlayer() {
        return yellowPlayer;
    }
}
