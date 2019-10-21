package com.kodilla.ludoboardgame;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private List<Pawn> bluePlayer = new ArrayList<>();
    private List<Pawn> redPlayer = new ArrayList<>();
    private List<Pawn> greenPlayer = new ArrayList<>();
    private List<Pawn> yellowPlayer = new ArrayList<>();
    private GridPane gridPane = new GridPane();
    private Image image = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\ludo-board.jpg");
    private BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    private BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    private Background background = new Background(backgroundImage);
    private List<BoardField> blueFields = new ArrayList<>(40);
    private Map<Integer, BoardField> blueFinish = new HashMap<Integer, BoardField>();
    private Map<Integer, BoardField> redFinish = new HashMap<Integer, BoardField>();
    private Map<Integer, BoardField> greenFinish = new HashMap<Integer, BoardField>();
    private Map<Integer, BoardField> yellowFinish = new HashMap<Integer, BoardField>();
    private List<Pawn> allPawns = new ArrayList<>();


    public void setBoard () {

        gridPane.setPadding(new Insets(37, 10, 38, 16));
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
        createBlueFields();
/*       blue();
       red();
       green();
       yellow();*/
    }


    public void blue () {
        Pawn blue1 = new Pawn("Blue", true, 0, 5, 0, 0);
        Pawn blue2 = new Pawn("Blue", true, 0, 5, 1, 0);
        Pawn blue3 = new Pawn("Blue", true, 0, 6, 0, 0);
        Pawn blue4 = new Pawn("Blue", true, 0, 6, 1, 0);
        allPawns.add(blue1);
        allPawns.add(blue2);
        allPawns.add(blue3);
        allPawns.add(blue4);
        gridPane.add(blue1.getPawn(), 5, 0, 2, 2);
        gridPane.add(blue2.getPawn(), 5, 1, 2, 2);
        gridPane.add(blue3.getPawn(), 6, 0, 2, 2);
        gridPane.add(blue4.getPawn(), 6, 1, 2, 2);
        bluePlayer.add(blue1);
        bluePlayer.add(blue2);
        bluePlayer.add(blue3);
        bluePlayer.add(blue4);


        blueFinish.put(0, new BoardField(5,6, new Pawn ("none")));
        blueFinish.put(1, new BoardField(5,7, new Pawn ("none")));
        blueFinish.put(2, new BoardField(5,8, new Pawn ("none")));
        blueFinish.put(3, new BoardField(5,9, new Pawn ("none")));
    }

    public void red () {
        Pawn red1 = new Pawn("Red", true, 10, 14, 0, 0);
        Pawn red2 = new Pawn("Red", true, 10, 14, 1, 0);
        Pawn red3 = new Pawn("Red", true, 10, 15, 0, 0);
        Pawn red4 = new Pawn("Red", true, 10, 15, 1, 0);
        gridPane.add(red1.getPawn(), 14, 0, 2, 2);
        gridPane.add(red2.getPawn(), 14, 1, 2, 2);
        gridPane.add(red3.getPawn(), 15, 0, 2, 2);
        gridPane.add(red4.getPawn(), 15, 1, 2, 2);
        redPlayer.add(red1);
        redPlayer.add(red2);
        redPlayer.add(red3);
        redPlayer.add(red4);

        redFinish.put(0, new BoardField(1,10, new Pawn ("none")));
        redFinish.put(1, new BoardField(2,10, new Pawn ("none")));
        redFinish.put(2, new BoardField(3,10, new Pawn ("none")));
        redFinish.put(3, new BoardField(4,10, new Pawn ("none")));
    }
    public void green () {
        Pawn green1 = new Pawn("Green", true, 20, 14, 9,0);
        Pawn green2 = new Pawn("Green", true, 20, 14, 10, 0);
        Pawn green3 = new Pawn("Green", true, 20, 15, 9, 0);
        Pawn green4 = new Pawn("Green", true, 20, 15, 10, 0);
        gridPane.add(green1.getPawn(), 14, 9, 2, 2);
        gridPane.add(green2.getPawn(), 14, 10, 2, 2);
        gridPane.add(green3.getPawn(), 15, 9, 2, 2);
        gridPane.add(green4.getPawn(), 15, 10, 2, 2);
        greenPlayer.add(green1);
        greenPlayer.add(green2);
        greenPlayer.add(green3);
        greenPlayer.add(green4);

        greenFinish.put(0, new BoardField(5,14, new Pawn ("none")));
        greenFinish.put(1, new BoardField(5,13, new Pawn ("none")));
        greenFinish.put(2, new BoardField(5,12, new Pawn ("none")));
        greenFinish.put(3, new BoardField(5,11, new Pawn ("none")));
    }
    public void yellow () {
        Pawn yellow1 = new Pawn("Yellow", true, 30, 5, 9, 0);
        Pawn yellow2 = new Pawn("Yellow", true, 30, 5, 10, 0);
        Pawn yellow3 = new Pawn("Yellow", true, 30, 6, 9, 0);
        Pawn yellow4 = new Pawn("Yellow", true, 30, 6, 10, 0);
        gridPane.add(yellow1.getPawn(), 5, 9, 2, 2);
        gridPane.add(yellow2.getPawn(), 5, 10, 2, 2);
        gridPane.add(yellow3.getPawn(), 6, 9, 2, 2);
        gridPane.add(yellow4.getPawn(), 6, 10, 2, 2);
        yellowPlayer.add(yellow1);
        yellowPlayer.add(yellow2);
        yellowPlayer.add(yellow3);
        yellowPlayer.add(yellow4);

        yellowFinish.put(0, new BoardField(9,10, new Pawn ("none")));
        yellowFinish.put(1, new BoardField(8,10, new Pawn ("none")));
        yellowFinish.put(2, new BoardField(7,10, new Pawn ("none")));
        yellowFinish.put(3, new BoardField(6,10, new Pawn ("none")));
    }

    public void createBlueFields() {
        blueFields.add(new BoardField(4,5, new Pawn("none")));
        blueFields.add(new BoardField(4,6, new Pawn("none")));
        blueFields.add(new BoardField(4,7, new Pawn("none")));
        blueFields.add(new BoardField(4,8, new Pawn("none")));
        blueFields.add(new BoardField(4,9, new Pawn("none")));
        blueFields.add(new BoardField(3,9, new Pawn("none")));
        blueFields.add(new BoardField(2,9, new Pawn("none")));
        blueFields.add(new BoardField(1,9, new Pawn("none")));
        blueFields.add(new BoardField(0,9, new Pawn("none")));
        blueFields.add(new BoardField(0,10, new Pawn("none")));
        blueFields.add(new BoardField(0,11, new Pawn("none")));
        blueFields.add(new BoardField(1,11, new Pawn("none")));
        blueFields.add(new BoardField(2,11, new Pawn("none")));
        blueFields.add(new BoardField(3,11, new Pawn("none")));
        blueFields.add(new BoardField(4,11, new Pawn("none")));
        blueFields.add(new BoardField(4,12, new Pawn("none")));
        blueFields.add(new BoardField(4,13, new Pawn("none")));
        blueFields.add(new BoardField(4,14, new Pawn("none")));
        blueFields.add(new BoardField(4,15, new Pawn("none")));
        blueFields.add(new BoardField(5,15, new Pawn("none")));
        blueFields.add(new BoardField(6,15, new Pawn("none")));
        blueFields.add(new BoardField(6,14, new Pawn("none")));
        blueFields.add(new BoardField(6,13, new Pawn("none")));
        blueFields.add(new BoardField(6,12, new Pawn("none")));
        blueFields.add(new BoardField(6,11, new Pawn("none")));
        blueFields.add(new BoardField(7,11, new Pawn("none")));
        blueFields.add(new BoardField(8,11, new Pawn("none")));
        blueFields.add(new BoardField(9,11, new Pawn("none")));
        blueFields.add(new BoardField(10,11, new Pawn("none")));
        blueFields.add(new BoardField(10,10, new Pawn("none")));
        blueFields.add(new BoardField(10,9, new Pawn("none")));
        blueFields.add(new BoardField(9,9, new Pawn("none")));
        blueFields.add(new BoardField(8,9, new Pawn("none")));
        blueFields.add(new BoardField(7,9, new Pawn("none")));
        blueFields.add(new BoardField(6,9, new Pawn("none")));
        blueFields.add(new BoardField(6,8, new Pawn("none")));
        blueFields.add(new BoardField(6,7, new Pawn("none")));
        blueFields.add(new BoardField(6,6, new Pawn("none")));
        blueFields.add(new BoardField(6,5, new Pawn("none")));
        blueFields.add(new BoardField(5,5,new Pawn("none")));
    }



    public GridPane getGridPane() {
        return gridPane;
    }


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
    public List<BoardField> getBlueFields() {
        return blueFields;
    }

    public Map<Integer, BoardField> getBlueFinish() {
        return blueFinish;
    }

    public Map<Integer, BoardField> getRedFinish() {
        return redFinish;
    }

    public Map<Integer, BoardField> getGreenFinish() {
        return greenFinish;
    }

    public Map<Integer, BoardField> getYellowFinish() {
        return yellowFinish;
    }


    public List<Pawn> getAllPawns() {
        return allPawns;
    }
}
