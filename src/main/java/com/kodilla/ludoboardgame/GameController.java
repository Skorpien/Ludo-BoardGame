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
        dice.compDiceThrow();
        dice.showDice();
        System.out.println("Red: " + dice.getResult());
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
        dice.compDiceThrow();
        System.out.println("Green: " + dice.getResult());
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
        dice.compDiceThrow();
        System.out.println("Yellow: " + dice.getResult());
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
                    if (pawn.getColor().equals("Blue")) {
                        GridPane.setRowIndex(pawn.getPawn(), board.getBlueFields().get(0).getRow());
                        GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFields().get(0).getColumn());
                        beating(pawn, 0);
                        board.getBlueFields().get(0).setPawn(pawn);
                    } else if (pawn.getColor().equals("Red")) {
                        GridPane.setRowIndex(pawn.getPawn(), board.getBlueFields().get(10).getRow());
                        GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFields().get(10).getColumn());
                        beating(pawn, 10);
                        board.getBlueFields().get(10).setPawn(pawn);
                    } else if (pawn.getColor().equals("Green")) {
                        GridPane.setRowIndex(pawn.getPawn(), board.getBlueFields().get(20).getRow());
                        GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFields().get(20).getColumn());
                        beating(pawn, 20);
                        board.getBlueFields().get(20).setPawn(pawn);
                    } else if (pawn.getColor().equals("Yellow")) {
                        GridPane.setRowIndex(pawn.getPawn(), board.getBlueFields().get(30).getRow());
                        GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFields().get(30).getColumn());
                        beating(pawn, 30);
                        board.getBlueFields().get(30).setPawn(pawn);

                    }
                    dice.setHome(false);
                    pawn.setIsHome(false);
                }
            } else {
                int releasedField = pawn.getWhere();
                pawn.setWhere(pawn.getWhere() + dice.getResult() + 1);
                if (pawn.getWhere() >= board.getBlueFields().size()) {
                    pawn.setWhere(pawn.getWhere() - board.getBlueFields().size());
                    beating(pawn, pawn.getWhere());
                    board.getBlueFields().get(pawn.getWhere()).setPawn(pawn);
                    board.getBlueFields().get(releasedField).setPawn(null);
                    pawn.setTraveledFields(pawn.getTraveledFields()+dice.getResult()+1);
                } else
                    beating(pawn, pawn.getWhere());
                    GridPane.setRowIndex(pawn.getPawn(), board.getBlueFields().get(pawn.getWhere()).getRow());
                    GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFields().get(pawn.getWhere()).getColumn());
                    board.getBlueFields().get(pawn.getWhere()).setPawn(pawn);
                    board.getBlueFields().get(releasedField).setPawn(null);
                    pawn.setTraveledFields(pawn.getTraveledFields()+dice.getResult()+1);
            }
        }

        public void beating (Pawn pawn, int where) {
        if (board.getBlueFields().get(where).getPawn() != null) {
                GridPane.setRowIndex(board.getBlueFields().get(where).getPawn().getPawn(), board.getBlueFields().get(where).getPawn().getHomeRow());
                GridPane.setColumnIndex(board.getBlueFields().get(where).getPawn().getPawn(), board.getBlueFields().get(where).getPawn().getHomeColumn());
                board.getBlueFields().get(where).getPawn().setWhere(0);
                board.getBlueFields().get(where).getPawn().setTraveledFields(0);
                board.getBlueFields().get(where).getPawn().setHome(true);
            }
        }

    }

/*
     if (pawn.getWhere() >= pawn.getBlueFields().size()) {  //when go to base
             pawn.setWhere(pawn.getWhere() - dice.getResult() + 1);*/

//if (pawn.getColor().equals(board.getBlueFields().get(where).getPawn().getColor())) //func when the same color