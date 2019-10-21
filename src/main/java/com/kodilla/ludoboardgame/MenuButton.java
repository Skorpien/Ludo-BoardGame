package com.kodilla.ludoboardgame;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;


public class MenuButton {

    MenuBar menuBar = new MenuBar();
    Board board;
    Dice dice;
    Stage primaryStage;


    public MenuButton (Board board, Dice dice, Stage primaryStage) {
        this.board = board;
        this.dice = dice;
        this.primaryStage = primaryStage;
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
            board.blue();
            board.red();
            board.green();
            GameController gameController = new GameController(board, dice);
            gameController.setPlayer();
        });
        MenuItem fourPlayers = new MenuItem("4 players");
        fourPlayers.setOnAction(event -> {
            board.blue();
            board.red();
            board.green();
            board.yellow();
            GameController gameController = new GameController(board, dice);
            gameController.setPlayer();
        });
        MenuItem saveGame = new MenuItem("Save Game");
        MenuItem loadGame = new MenuItem("Load Game");
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
