package com.kodilla.ludoboardgame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;


public class Pawn {

    private Image pawnBlue = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\pawn.png", 50, 50, true, false);
    private Button pawn = new Button();
    private GridPane gridPane = new GridPane();
    private int numb;
    private int where = 0;
    private boolean isHome = true;
    private Dice dice;
    private Board board;
    private CompPlayer compPlayer;

    public Pawn (String color, int numb, Dice dice, Board board) {
        if (color.equals("Blue")) {
            pawn.setGraphic(new ImageView(pawnBlue));
            pawn.setBorder(Border.EMPTY);
            pawn.setStyle("-fx-background-color: transparent");
            this.numb = numb;
            this.dice = dice;
            this.board = board;
           pawn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (dice.getDiceIsThrow()) {
                        move();
                        dice.setDiceIsThrow(false);
                        board.compMoveBoard();
                    }
                }
            });
        }
    }

    public Button getPawn() {
        return pawn;
    }

    public void move() {
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
    }

    public boolean getIsHome() {
        return isHome;
    }

    public void setIsHome(boolean isHome) {
        this.isHome = isHome;
    }


}
