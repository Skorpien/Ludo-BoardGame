package com.kodilla.ludoboardgame;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class MenuButton {

    private MenuBar menuBar = new MenuBar();
    private Board board;
    private Dice dice;
    private Stage primaryStage;
    private SaveLoad saveLoad;


    public MenuButton (Board board, Dice dice, Stage primaryStage, SaveLoad saveLoad) {
        this.board = board;
        this.dice = dice;
        this.primaryStage = primaryStage;
        this.saveLoad = saveLoad;
    }

    public MenuBar menuBar () {
        board.setBoard();
        Menu menu = new Menu("Menu");
        Menu newGame = new Menu("New Game");
        MenuItem twoPlayers = new MenuItem("2 players");
        twoPlayers.setOnAction(event -> {
            primaryStage.close();
            Platform.runLater( () -> new Ludo().restart(2) );

        });
        MenuItem threePlayers = new MenuItem("3 players");
        threePlayers.setOnAction(event -> {
            primaryStage.close();
            Platform.runLater( () -> new Ludo().restart(3) );
        });
        MenuItem fourPlayers = new MenuItem("4 players");
        fourPlayers.setOnAction(event -> {
            primaryStage.close();
            Platform.runLater( () -> new Ludo().restart(4) );
        });
        MenuItem saveGame = new MenuItem("Save Game");
        saveGame.setOnAction(event -> saveLoad.save());
        MenuItem loadGame = new MenuItem("Load Game");
        loadGame.setOnAction(event -> {
           // primaryStage.close();
           // Platform.runLater( () -> new Ludo().restart(board.getHowManyPlayers()) );
            board.getBlueFields().clear();
            board.getBlueFinish().clear();
            board.getRedFinish().clear();
            board.getGreenFinish().clear();
            board.getYellowFinish().clear();
            board.createBlueFinish();
            board.createRedFinish();
            board.createGreenFinish();
            board.createYellowFinish();
            board.createBlueFields();
            for (Pawn pawn:
                    board.getBluePlayer()) {
                pawn.getPawn().setDisable(false);
            }
            saveLoad.load();
        });
        MenuItem ranking = new MenuItem("Ranking");
        MenuItem exit = new MenuItem("Exit");
        exit.setOnAction(event -> {
            System.exit(0);
        });
        newGame.getItems().add(twoPlayers);
        newGame.getItems().add(threePlayers);
        newGame.getItems().add(fourPlayers);
        menu.getItems().add(newGame);
        menu.getItems().add(saveGame);
        menu.getItems().add(loadGame);
        menu.getItems().add(ranking);
        menu.getItems().add(exit);
        menuBar.getMenus().add(menu);



        return menuBar;
    }

}
