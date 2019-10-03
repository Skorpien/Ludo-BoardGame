package com.kodilla.ludoboardgame;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Pawn {

    private Image pawnBlue = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\pawn.png", 50, 50, true, false);
    private Image pawnRed = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\pawnRed.png", 50, 50, true, false);
    private Image pawnGreen = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\pawnGreen.png", 50, 50, true, false);
    private Image pawnYellow = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\pawnYellow.png", 50, 50, true, false);
    private Button pawn = new Button();
    private GridPane gridPane = new GridPane();
    private int where;
    private boolean isHome;
    private String color;
    private int homeColumn;
    private int homeRow;
    private int startField;
    private int traveledFields;


    public Pawn (String color, boolean isHome, int where, int homeColumn, int homeRow, int traveledFields) {
        if (color.equals("Blue")) {
            pawn.setGraphic(new ImageView(pawnBlue));
            pawn.setBorder(Border.EMPTY);
            pawn.setStyle("-fx-background-color: transparent");
            this.isHome = isHome;
            this.where = where;
            this.color = color;
            this.homeColumn = homeColumn;
            this.homeRow = homeRow;
            this.startField = where;
            this.traveledFields = traveledFields;

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
            this.isHome = isHome;
            this.where = where;
            this.color = color;
            this.homeColumn = homeColumn;
            this.homeRow = homeRow;
            this.startField = where;
            this.traveledFields = traveledFields;
        } else if (color.equals("Green")) {
            pawn.setGraphic(new ImageView(pawnGreen));
            pawn.setBorder(Border.EMPTY);
            pawn.setStyle("-fx-background-color: transparent");
            this.isHome = isHome;
            this.where = where;
            this.color = color;
            this.homeColumn = homeColumn;
            this.homeRow = homeRow;
            this.startField = where;
            this.traveledFields = traveledFields;
        } else if (color.equals("Yellow")) {
            pawn.setGraphic(new ImageView(pawnYellow));
            pawn.setBorder(Border.EMPTY);
            pawn.setStyle("-fx-background-color: transparent");
            this.isHome = isHome;
            this.where = where;
            this.color = color;
            this.homeColumn = homeColumn;
            this.homeRow = homeRow;
            this.startField = where;
            this.traveledFields = traveledFields;
        }
    }

    public Pawn (String color) {
        this.color = color;
    }

    public Button getPawn() {
        return this.pawn;
    }


    public String getColor() {
        return this.color;
    }

    public boolean getIsHome() {
        return this.isHome;
    }

    public void setIsHome(boolean isHome) {
        this.isHome = isHome;
    }

    public int getStartField() {
        return startField;
    }

    public int getWhere() {
        return this.where;
    }

    public int getHomeColumn() {
        return this.homeColumn;
    }

    public void setTraveledFields(int traveledFields) {
        this.traveledFields = traveledFields;
    }

    public int getTraveledFields() {
        return traveledFields;
    }

    public int getHomeRow() {
        return this.homeRow;
    }

    public void setWhere(int where) {
        this.where = where;
    }

    public void setHome(boolean home) {
        this.isHome = home;
    }
}
