package com.kodilla.ludoboardgame;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.List;


public class Pawn {

    private Image pawnBlue = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\pawn.png", 50, 50, true, false);
    private Image pawnRed = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\pawnRed.png", 50, 50, true, false);
    private Button pawn = new Button();
    private GridPane gridPane = new GridPane();
    private int where;
    private boolean isHome;
    private  static List<BoardField> blueFields = new ArrayList<>(44);

    public Pawn (String color, boolean isHome, int where) {
        if (color.equals("Blue")) {
            pawn.setGraphic(new ImageView(pawnBlue));
            pawn.setBorder(Border.EMPTY);
            pawn.setStyle("-fx-background-color: transparent");
            this.isHome = isHome;
            this.where = where;
            createBlueFields();
          //  this.dice = dice;
           // this.board = board;
    /*       pawn.setOnAction(event -> {
               if (dice.getDiceIsThrow()) {
                   move();
                   dice.setDiceIsThrow(false);
                   board.compMoveBoard();
               }
           });*/
        } else if (color.equals("Red")) {
            pawn.setGraphic(new ImageView(pawnRed));
            pawn.setBorder(Border.EMPTY);
            pawn.setStyle("-fx-background-color: transparent");
            //createBlueFields();
        }
    }

    public void createBlueFields() {
        blueFields.add(new BoardField(4,5));
        blueFields.add(new BoardField(4,6));
        blueFields.add(new BoardField(4,7));
        blueFields.add(new BoardField(4,8));
        blueFields.add(new BoardField(4,9));
        blueFields.add(new BoardField(3,9));
        blueFields.add(new BoardField(2,9));
        blueFields.add(new BoardField(1,9));
        blueFields.add(new BoardField(0,9));
        blueFields.add(new BoardField(0,10));
        blueFields.add(new BoardField(0,11));
        blueFields.add(new BoardField(1,11));
        blueFields.add(new BoardField(2,11));
        blueFields.add(new BoardField(3,11));
        blueFields.add(new BoardField(4,11));
        blueFields.add(new BoardField(4,12));
        blueFields.add(new BoardField(4,13));
        blueFields.add(new BoardField(4,14));
        blueFields.add(new BoardField(4,15));
        blueFields.add(new BoardField(5,15));
        blueFields.add(new BoardField(6,15));
        blueFields.add(new BoardField(6,14));
        blueFields.add(new BoardField(6,13));
        blueFields.add(new BoardField(6,12));
        blueFields.add(new BoardField(6,11));
        blueFields.add(new BoardField(7,11));
        blueFields.add(new BoardField(8,11));
        blueFields.add(new BoardField(9,11));
        blueFields.add(new BoardField(10,11));
        blueFields.add(new BoardField(10,10));
        blueFields.add(new BoardField(10,9));
        blueFields.add(new BoardField(9,9));
        blueFields.add(new BoardField(8,9));
        blueFields.add(new BoardField(7,9));
        blueFields.add(new BoardField(6,9));
        blueFields.add(new BoardField(6,8));
        blueFields.add(new BoardField(6,7));
        blueFields.add(new BoardField(6,6));
        blueFields.add(new BoardField(6,5));
        blueFields.add(new BoardField(5,5));
        blueFields.add(new BoardField(5,6));
        blueFields.add(new BoardField(5,7));
        blueFields.add(new BoardField(5,8));
        blueFields.add(new BoardField(5,9));

    }


    public Button getPawn() {
        return pawn;
    }

/*    public void move() {
        if (isHome) {
            if (dice.getResult() == 5) {
                gridPane.setRowIndex(this.getPawn(), Board.getBoard().get(0).getRow());
                gridPane.setColumnIndex(this.getPawn(), Board.getBoard().get(0).getColumn());
                dice.setHome(false);
                isHome = false;
            }
        } else {
            where+=dice.getResult()+1;
            if (where>=Board.getBoard().size()) {
                where-=dice.getResult()+1;
            } else
            gridPane.setRowIndex(this.getPawn(), Board.getBoard().get(where).getRow());
            gridPane.setColumnIndex(this.getPawn(), Board.getBoard().get(where).getColumn());
        }
    }*/

    public boolean getIsHome() {
        return isHome;
    }

    public void setIsHome(boolean isHome) {
        this.isHome = isHome;
    }

    public List<BoardField> getBlueFields() {
        return blueFields;
    }

    public int getWhere() {
        return where;
    }

    public void setWhere(int where) {
        this.where = where;
    }
}
