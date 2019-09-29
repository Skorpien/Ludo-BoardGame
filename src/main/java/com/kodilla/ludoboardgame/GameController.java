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
                  //  play();
                }
            });
        } // there is something no yes...
    }


    public void play() {

        redPlay();
        greenPlay();
        yellowPlay();

    }

    public void redPlay() {
        boolean wasMove = false;
        dice.compDiceThrow();
        dice.showDice();
        System.out.println("Red: " + dice.getResult());
        for (Pawn pawn : board.getRedPlayer()
        ) {
            if (dice.getResult() == 5 && pawn.getIsHome() && board.getBlueFields().get(pawn.getHomeRow()).getPawn() == null) {
                move(pawn);
                wasMove = true;
                break;
            } else if (dice.getResult() == 5 && pawn.getIsHome() && !board.getBlueFields().get(pawn.getHomeRow()).getPawn().getColor().equals("Red")) {
                move(pawn);
                wasMove = true;
                break;
            } else {
                ;
            }
        }
        if (!wasMove) {
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
            if (dice.getResult() == 5 && pawn.getIsHome() && board.getBlueFields().get(pawn.getHomeRow()).getPawn() == null) {
                move(pawn);
                wasMove = true;
                break;
            } else if (dice.getResult() == 5 && pawn.getIsHome() && !board.getBlueFields().get(pawn.getHomeRow()).getPawn().getColor().equals(pawn.getColor())) {
                move(pawn);
                wasMove = true;
                break;
            } else {
                ;
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
            if (dice.getResult() == 5 && pawn.getIsHome() && board.getBlueFields().get(pawn.getHomeRow()).getPawn() == null) {
                    move(pawn);
                    wasMove = true;
                    break;
            } else if (dice.getResult() == 5 && pawn.getIsHome() && !board.getBlueFields().get(pawn.getHomeRow()).getPawn().getColor().equals(pawn.getColor())) {
                move(pawn);
                wasMove = true;
                break;
            } else {
                break;
            }
        }
        if (!wasMove) {
            for (Pawn pawn : board.getYellowPlayer()
            ) {
                if (pawn.getTraveledFields()<40) {
                    move(pawn);
                    break;
                }
                if (pawn.getTraveledFields()>39 && pawn.getTraveledFields()<43) {
                    int rest = pawn.getTraveledFields() - 40;
                    if (dice.getResult() +1 < board.getYellowFinish().size()) {

                    }
                }
            }
        }
    }

        public void move (Pawn pawn){
            if (pawn.getIsHome()) {
                if (dice.getResult() == 5) {
                    switch (pawn.getColor()) {
                        case "Blue":
                            if (board.getBlueFields().get(0).getPawn() == null) {
                                GridPane.setRowIndex(pawn.getPawn(), board.getBlueFields().get(0).getRow());
                                GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFields().get(0).getColumn());
                                board.getBlueFields().get(0).setPawn(pawn);
                            } else if (!board.getBlueFields().get(0).getPawn().getColor().equals("Blue")) {
                                GridPane.setRowIndex(pawn.getPawn(), board.getBlueFields().get(0).getRow());
                                GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFields().get(0).getColumn());
                                beating(pawn, 0);
                            } else {
                                ;
                            }
                            break;
                        case "Red":
                            GridPane.setRowIndex(pawn.getPawn(), board.getBlueFields().get(10).getRow());
                            GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFields().get(10).getColumn());
                            beating(pawn, 10);
                            board.getBlueFields().get(10).setPawn(pawn);
                            break;
                        case "Green":
                            GridPane.setRowIndex(pawn.getPawn(), board.getBlueFields().get(20).getRow());
                            GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFields().get(20).getColumn());
                            beating(pawn, 20);
                            board.getBlueFields().get(20).setPawn(pawn);
                            break;
                        case "Yellow":
                            GridPane.setRowIndex(pawn.getPawn(), board.getBlueFields().get(30).getRow());
                            GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFields().get(30).getColumn());
                            beating(pawn, 30);
                            board.getBlueFields().get(30).setPawn(pawn);

                            break;
                    }
                    dice.setHome(false);
                    pawn.setIsHome(false);
                }
            } else {
                    pawn.setTraveledFields(pawn.getTraveledFields() + dice.getResult() + 1);
                    if (pawn.getTraveledFields() <= 39) {
                        int releasedField = pawn.getWhere();
                        pawn.setWhere(pawn.getWhere() + dice.getResult() + 1);
                        if (pawn.getWhere() >= board.getBlueFields().size()) {
                            pawn.setWhere(pawn.getWhere() - board.getBlueFields().size());
                          //  beating(pawn, pawn.getWhere());
                          //  board.getBlueFields().get(pawn.getWhere()).setPawn(pawn);
                         //   board.getBlueFields().get(releasedField).setPawn(null);
                            //  pawn.setTraveledFields(pawn.getTraveledFields()+dice.getResult()+1);
                        }
                            if (beating(pawn, pawn.getWhere()) || board.getBlueFields().get(pawn.getWhere()).getPawn() == null) {
                                GridPane.setRowIndex(pawn.getPawn(), board.getBlueFields().get(pawn.getWhere()).getRow());
                                GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFields().get(pawn.getWhere()).getColumn());
                                board.getBlueFields().get(pawn.getWhere()).setPawn(pawn);
                                board.getBlueFields().get(releasedField).setPawn(null);
                                // pawn.setTraveledFields(pawn.getTraveledFields() + dice.getResult() + 1);
                            }
                    } else {
                        int releasedField = pawn.getWhere();
                        finishing(pawn, releasedField);
                    }
            }
        }

        public boolean beating (Pawn pawn, int where) {
        if (board.getBlueFields().get(where).getPawn() != null) {
            if (!board.getBlueFields().get(where).getPawn().getColor().equals(pawn.getColor())) {
                GridPane.setRowIndex(board.getBlueFields().get(where).getPawn().getPawn(), board.getBlueFields().get(where).getPawn().getHomeRow());
                GridPane.setColumnIndex(board.getBlueFields().get(where).getPawn().getPawn(), board.getBlueFields().get(where).getPawn().getHomeColumn());
                board.getBlueFields().get(where).getPawn().setWhere(board.getBlueFields().get(where).getPawn().getStartField());
                board.getBlueFields().get(where).getPawn().setTraveledFields(0);
                board.getBlueFields().get(where).getPawn().setHome(true);
                return true;
            }
            }
        return false;
        }

        public void finishing (Pawn pawn, int releasedField) {
            boolean finish = true;
            int rest = releasedField + dice.getResult() +1;
            if (pawn.getWhere() > 4) {
                rest = pawn.getTraveledFields() - 40;
                finish = false;
            }
                System.out.println(rest);
            switch (pawn.getColor()) {
                case "Blue":
                    if (rest < board.getBlueFinish().size() && board.getBlueFinish().get(rest).getPawn()==null) {
                        GridPane.setRowIndex(pawn.getPawn(), board.getBlueFinish().get(rest).getRow());
                        GridPane.setColumnIndex(pawn.getPawn(), board.getBlueFinish().get(rest).getColumn());
                        board.getBlueFinish().get(rest).setPawn(pawn);
                        if (!finish) {
                            board.getBlueFields().get(releasedField).setPawn(null);
                            pawn.setWhere(rest);
                        } else {
                            board.getBlueFinish().get(releasedField).setPawn(null);
                            pawn.setWhere(rest);
                        }
                    } else {
                        ;
                    }
                    break;
                case "Red":
                    if (rest < board.getRedFinish().size()) {
                        GridPane.setRowIndex(pawn.getPawn(), board.getRedFinish().get(rest).getRow());
                        GridPane.setRowIndex(pawn.getPawn(), board.getRedFinish().get(rest).getColumn());
                        board.getRedFinish().get(rest).setPawn(pawn);
                        if (releasedField > 0) {
                            board.getBlueFields().get(releasedField).setPawn(null);
                            pawn.setWhere(0);
                        } else {
                            board.getRedFinish().get(releasedField).setPawn(null);
                        }
                    } else {
                        ;
                    }
                    break;
                case "Green":
                    if (rest < board.getGreenFinish().size()) {
                        GridPane.setRowIndex(pawn.getPawn(), board.getGreenFinish().get(rest).getRow());
                        GridPane.setRowIndex(pawn.getPawn(), board.getGreenFinish().get(rest).getColumn());
                        board.getGreenFinish().get(rest).setPawn(pawn);
                        if (releasedField > 0) {
                            board.getBlueFields().get(releasedField).setPawn(null);
                            pawn.setWhere(0);
                        } else {
                            board.getGreenFinish().get(releasedField).setPawn(null);
                        }
                    } else {
                        ;
                    }
                    break;
                case "Yellow":
                    if (rest < board.getYellowFinish().size()) {
                        GridPane.setRowIndex(pawn.getPawn(), board.getYellowFinish().get(rest).getRow());
                        GridPane.setRowIndex(pawn.getPawn(), board.getYellowFinish().get(rest).getColumn());
                        board.getYellowFinish().get(rest).setPawn(pawn);
                        if (releasedField > 0) {
                            board.getBlueFields().get(releasedField).setPawn(null);
                            pawn.setWhere(0);
                        } else {
                            board.getYellowFinish().get(releasedField).setPawn(null);
                        }
                    } else {
                        ;
                    }
                    break;
            }

        }

    }

/*
     if (pawn.getWhere() >= pawn.getBlueFields().size()) {  //when go to base
             pawn.setWhere(pawn.getWhere() - dice.getResult() + 1);*/

//if (pawn.getColor().equals(board.getBlueFields().get(where).getPawn().getColor())) //func when the same color
//!board.getBlueFields().get(pawn.getWhere() + dice.getResult() + 1).getPawn().getColor().equals(pawn.getColor()) the same color