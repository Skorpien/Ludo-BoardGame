package com.kodilla.ludoboardgame;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;

public class CompPlayer {
    private Dice compDice = new Dice();
    private Pawn compMovePawn;
    private Image pawnBlue = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\pawnRed.png", 50, 50, true, false);
    private Button compPawn = new Button();
    private GridPane gridPane = new GridPane();
    private int compNumb;
    private int compWhere = 0;
    private boolean compIsHome = true;

    public CompPlayer(String color) {
        if (color.equals("Blue")) {
            compPawn.setGraphic(new ImageView(pawnBlue));
            compPawn.setBorder(Border.EMPTY);
            compPawn.setStyle("-fx-background-color: transparent");
        }
    }

        public void compMove () {
            compDice.diceThrow();
            if (compIsHome) {
                if (compDice.getResult() == 5) {
                    gridPane.setRowIndex(this.getCompPawn(), Board.getBoard().get(0).getRow());
                    gridPane.setColumnIndex(this.getCompPawn(), Board.getBoard().get(0).getColumn());
                    compIsHome = false;
                }
            } else {
                compWhere+=compDice.getResult()+1;
                if (compWhere>=Board.getBoard().size()) {
                    compWhere-=compDice.getResult()+1;
                } else
                    gridPane.setRowIndex(this.getCompPawn(), Board.getBoard().get(compWhere).getRow());
                    gridPane.setColumnIndex(this.getCompPawn(), Board.getBoard().get(compWhere).getColumn());
            }
        }

    public Button getCompPawn() {
        return compPawn;
    }
}

