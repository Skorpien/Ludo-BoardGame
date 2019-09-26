package com.kodilla.ludoboardgame;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private  static List<BoardField> board = new ArrayList<>(44);
    private List<CompPlayer> redPlayer = new ArrayList<>();
    private GridPane gridPane = new GridPane();
    private Image image = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\ludo-board.jpg");
    private BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    private BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    private Background background = new Background(backgroundImage);

    public GridPane setBoard () {

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
       createFields();
       red();
       return gridPane;
            }
    public List<BoardField> createFields() {
        board.add(new BoardField(4,5));
        board.add(new BoardField(4,6));
        board.add(new BoardField(4,7));
        board.add(new BoardField(4,8));
        board.add(new BoardField(4,9));
        board.add(new BoardField(3,9));
        board.add(new BoardField(2,9));
        board.add(new BoardField(1,9));
        board.add(new BoardField(0,9));
        board.add(new BoardField(0,10));
        board.add(new BoardField(0,11));
        board.add(new BoardField(1,11));
        board.add(new BoardField(2,11));
        board.add(new BoardField(3,11));
        board.add(new BoardField(4,11));
        board.add(new BoardField(4,12));
        board.add(new BoardField(4,13));
        board.add(new BoardField(4,14));
        board.add(new BoardField(4,15));
        board.add(new BoardField(5,15));
        board.add(new BoardField(6,15));
        board.add(new BoardField(6,14));
        board.add(new BoardField(6,13));
        board.add(new BoardField(6,12));
        board.add(new BoardField(6,11));
        board.add(new BoardField(7,11));
        board.add(new BoardField(8,11));
        board.add(new BoardField(9,11));
        board.add(new BoardField(10,11));
        board.add(new BoardField(10,10));
        board.add(new BoardField(10,9));
        board.add(new BoardField(9,9));
        board.add(new BoardField(8,9));
        board.add(new BoardField(7,9));
        board.add(new BoardField(6,9));
        board.add(new BoardField(6,8));
        board.add(new BoardField(6,7));
        board.add(new BoardField(6,6));
        board.add(new BoardField(6,5));
        board.add(new BoardField(5,5));
        board.add(new BoardField(5,6));
        board.add(new BoardField(5,7));
        board.add(new BoardField(5,8));
        board.add(new BoardField(5,9));

        return board;
    }

    public List<CompPlayer> red () {
        CompPlayer red1 = new CompPlayer("Red");
        CompPlayer red2 = new CompPlayer("Red");
        gridPane.add(red1.getCompPawn(), 14, 0, 2, 2);
        gridPane.add(red2.getCompPawn(), 14, 1, 2, 2);
        redPlayer.add(red1);
        redPlayer.add(red2);
        return redPlayer;
    }

    public void compMoveBoard () {
        redPlayer.get(0).compMove();
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public  static List<BoardField> getBoard() {
        return board;
    }

    public List<CompPlayer> getRedPlayer() {
        return redPlayer;
    }
}
