package com.kodilla.ludoboardgame;


import javafx.scene.control.Label;

public class VictoryCheck {
    Board board;

    public VictoryCheck (Board board) {
        this.board = board;
    }

    public void blueVictoryCheck () {
        boolean isBlueVictory = true;
        for (int i = 0; i<board.getBlueFinish().size(); i++) {
            if (!board.getBlueFinish().get(i).getPawn().getColor().equals("Blue")) {
                isBlueVictory = false;
                break;
            }
        }
        if (isBlueVictory) {
            Label blueWin = new Label("  YOU WIN!");
            board.getGridPane().add(blueWin, 10, 5,2,2);
        }
    }

    public void redVictoryCheck () {
        boolean isRedVictory = true;
        for (int i = 0; i<board.getRedFinish().size(); i++) {
            if (!board.getRedFinish().get(i).getPawn().getColor().equals("Red")) {
                isRedVictory = false;
                break;
            }
        }
        if (isRedVictory) {
            Label blueWin = new Label("RED WIN...");
            board.getGridPane().add(blueWin, 10, 5,2,2);
        }
    }

    public void greenVictoryCheck () {
        boolean isGreenVictory = true;
        for (int i = 0; i<board.getGreenFinish().size(); i++) {
            if (!board.getGreenFinish().get(i).getPawn().getColor().equals("Green")) {
                isGreenVictory = false;
                break;
            }
        }
        if (isGreenVictory) {
            Label blueWin = new Label("GREEN WIN...");
            board.getGridPane().add(blueWin, 10, 5,2,2);
        }
    }

    public void yellowVictoryCheck () {
        boolean isYellowVictory = true;
        for (int i = 0; i<board.getYellowFinish().size(); i++) {
            if (board.getYellowFinish().get(i).getPawn().getColor().equals("Yellow")) {
                isYellowVictory = false;
                break;
            }
        }
        if (isYellowVictory) {
            Label blueWin = new Label("YELLOW WIN...");
            board.getGridPane().add(blueWin, 10, 5,2,2);
        }
    }
}
