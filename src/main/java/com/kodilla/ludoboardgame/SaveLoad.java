package com.kodilla.ludoboardgame;

import javafx.scene.layout.GridPane;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveLoad {
    File savedGame = new File("saved.game");
    File ranking = new File ("ranking.game");
    List<String> rank = new ArrayList<>();
    List<PawnData> list = new ArrayList<>();
    Board board;

    public SaveLoad(Board board) {
        this.board = board;
    }

    public void save () {
        System.out.println("at start " + board.getAllPawns().size());

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedGame));
            list.clear();
            for (int i = 0; i < board.getAllPawns().size(); i++) {
                list.add(new PawnData(board.getAllPawns().get(i).getIsHome(), board.getAllPawns().get(i).getWhere(), board.getAllPawns().get(i).getTraveledFields(), board.getAllPawns().get(i).getIsFinishing()));
                System.out.println("list size " + list.size());
            }
            oos.writeObject(list);
            System.out.println("saving");
            oos.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void load () {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedGame));
            Object readList = ois.readObject();
            if(readList instanceof ArrayList) {
              //  list.addAll((ArrayList) readList);
              for (int i = 0; i<list.size(); i++) {
                  board.getAllPawns().get(i).setHome(list.get(i).getIsHome());
                  board.getAllPawns().get(i).setWhere(list.get(i).getWhere());
                  board.getAllPawns().get(i).setTraveledFields(list.get(i).getTraveledFields());
                  board.getAllPawns().get(i).setFinishing(list.get(i).getIsFinishing());
                  if (!board.getAllPawns().get(i).getIsHome()) {
                      if (!board.getAllPawns().get(i).getIsFinishing()) {
                          GridPane.setColumnIndex(board.getAllPawns().get(i).getPawn(), board.getBlueFields().get(board.getAllPawns().get(i).getWhere()).getColumn());
                          GridPane.setRowIndex(board.getAllPawns().get(i).getPawn(), board.getBlueFields().get(board.getAllPawns().get(i).getWhere()).getRow());
                          board.getBlueFields().get(board.getAllPawns().get(i).getWhere()).setPawn(board.getAllPawns().get(i));
                      } else {
                          presence(i);
                      }
                  } else  {
                      GridPane.setColumnIndex(board.getAllPawns().get(i).getPawn(), board.getAllPawns().get(i).getHomeColumn());
                      GridPane.setRowIndex(board.getAllPawns().get(i).getPawn(), board.getAllPawns().get(i).getHomeRow());
                  }
              }
                System.out.println("load");
                System.out.println(list.size());
            }
            ois.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void presence (int i) {
        String color = board.getAllPawns().get(i).getColor();

            switch (color) {
                case "Blue":
                    GridPane.setColumnIndex(board.getAllPawns().get(i).getPawn(), board.getBlueFinish().get(board.getAllPawns().get(i).getWhere()).getColumn());
                    GridPane.setRowIndex(board.getAllPawns().get(i).getPawn(), board.getBlueFinish().get(board.getAllPawns().get(i).getWhere()).getRow());
                    board.getBlueFinish().get(board.getAllPawns().get(i).getWhere()).setPawn(board.getAllPawns().get(i));
                    break;
                case "Red":
                    GridPane.setColumnIndex(board.getAllPawns().get(i).getPawn(), board.getRedFinish().get(board.getAllPawns().get(i).getWhere()).getColumn());
                    GridPane.setRowIndex(board.getAllPawns().get(i).getPawn(), board.getRedFinish().get(board.getAllPawns().get(i).getWhere()).getRow());
                    board.getRedFinish().get(board.getAllPawns().get(i).getWhere()).setPawn(board.getAllPawns().get(i));
                    break;
                case "Green":
                    GridPane.setColumnIndex(board.getAllPawns().get(i).getPawn(), board.getGreenFinish().get(board.getAllPawns().get(i).getWhere()).getColumn());
                    GridPane.setRowIndex(board.getAllPawns().get(i).getPawn(), board.getGreenFinish().get(board.getAllPawns().get(i).getWhere()).getRow());
                    board.getGreenFinish().get(board.getAllPawns().get(i).getWhere()).setPawn(board.getAllPawns().get(i));
                    break;
                case "Yellow":
                    GridPane.setColumnIndex(board.getAllPawns().get(i).getPawn(), board.getYellowFinish().get(board.getAllPawns().get(i).getWhere()).getColumn());
                    GridPane.setRowIndex(board.getAllPawns().get(i).getPawn(), board.getYellowFinish().get(board.getAllPawns().get(i).getWhere()).getRow());
                    board.getYellowFinish().get(board.getAllPawns().get(i).getWhere()).setPawn(board.getAllPawns().get(i));
                    break;
            }
        }

        public void saveRanking () {
            try {
                ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(ranking));
                oos.writeObject(rank);
                oos.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public void loadRanking () {
            try {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ranking));
                Object readMap = ois.readObject();
                if(readMap instanceof ArrayList) {
                    rank.addAll((ArrayList) readMap);
                }
                ois.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
}

