package com.kodilla.ludoboardgame;

import javafx.event.ActionEvent;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    private Board board;
    private Dice dice;
    private GridPane gridPane = new GridPane();
    private boolean playerTurn = true;
    //private boolean isHome = true;
    // private int where = 0;
    //  private List<Pawn> bluePawns = new ArrayList<>();
    // private List<Pawn> redPawns = new ArrayList<>();
    //  private List<Pawn> greenPawns = new ArrayList<>();
    // private List<Pawn> yellowPawns = new ArrayList<>();

    public GameController(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
    }


    public void setPlayer() {
        for (int i = 0; i < board.getBluePlayer().size(); i++) {
            int finalI = i;
            board.getBluePlayer().get(i).getPawn().setOnAction(event -> {
                if (dice.getDiceIsThrow()) {
                    move(board.getBluePlayer().get(finalI));
                    dice.setDiceIsThrow(false);
                    play();
                }
            });
        } // there is something no yes...
    }


    public void play() { // TO FIX!

        redPlay();
        greenPlay();
        yellowPlay();

    }

    public void redPlay() {
        boolean redWasMove = false;
        dice.diceThrow();
        for (Pawn pawn : board.getRedPlayer()
        ) {
            if (dice.getResult() == 5 && pawn.getIsHome()) {
                move(pawn);
                redWasMove = true;
                break;
            }
        }
        if (!redWasMove) {
            for (Pawn pawn : board.getRedPlayer()
            ) {
                if (pawn.getWhere() < 41) {
                    move(pawn);
                    break;
                }
            }
        }
    }

    public void greenPlay() {
        boolean wasMove = false;
        dice.diceThrow();
        for (Pawn pawn : board.getGreenPlayer()
        ) {
            if (dice.getResult() == 5 && pawn.getIsHome()) {
                move(pawn);
                wasMove = true;
                break;
            }
        }
        if (!wasMove) {
            for (Pawn pawn : board.getGreenPlayer()
            ) {
                if (pawn.getWhere() < 41) {
                    move(pawn);
                    break;
                }
            }
        }
    }

    public void yellowPlay () {
        boolean wasMove = false;
        dice.diceThrow();
        for (Pawn pawn : board.getYellowPlayer()
        ) {
            if (dice.getResult() == 5 && pawn.getIsHome()) {
                move(pawn);
                wasMove = true;
                break;
            }
        }
        if (!wasMove) {
            for (Pawn pawn : board.getYellowPlayer()
            ) {
                if (pawn.getWhere() < 41) {
                    move(pawn);
                    break;
                }
            }
        }
    }

        public void move (Pawn pawn){
            if (pawn.getIsHome()) {
                if (dice.getResult() == 5) {
                    GridPane.setRowIndex(pawn.getPawn(), pawn.getBlueFields().get(0).getRow());
                    GridPane.setColumnIndex(pawn.getPawn(), pawn.getBlueFields().get(0).getColumn());
                    dice.setHome(false);
                    pawn.setIsHome(false);
                }
            } else {
                pawn.setWhere(pawn.getWhere() + dice.getResult() + 1);
                if (pawn.getWhere() >= pawn.getBlueFields().size()) {
                    pawn.setWhere(pawn.getWhere() - dice.getResult() + 1);
                } else
                    GridPane.setRowIndex(pawn.getPawn(), pawn.getBlueFields().get(pawn.getWhere()).getRow());
                GridPane.setColumnIndex(pawn.getPawn(), pawn.getBlueFields().get(pawn.getWhere()).getColumn());
            }
        }

    }
