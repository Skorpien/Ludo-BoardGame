package com.kodilla.ludoboardgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Ludo extends Application {

    private Image dice6 = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\dice_6-512.png", 40,40,true, false);
    private Board board;
    private Dice dice;

    public static void main(String[] args) {
        launch(args);
    }

    public void restart (int players) {
        Stage stage = new Stage();
        start(stage);

        switch (players) {
            case 2: {
                board.blue();
                board.red();
                GameController gameController = new GameController(board, dice, 2);
                gameController.setPlayer();
                board.setHowManyPlayers(2);
                break;
            }
            case 3: {
                board.blue();
                board.red();
                board.green();
                GameController gameController = new GameController(board, dice, 3);
                gameController.setPlayer();
                board.setHowManyPlayers(3);
                break;
            }
            case 4: {
                board.blue();
                board.red();
                board.green();
                board.yellow();
                GameController gameController = new GameController(board, dice, 4);
                gameController.setPlayer();
                board.setHowManyPlayers(4);
                break;
            }
        }
    }

    @Override
    public void start(Stage primaryStage) {


        board = new Board();
        board.setBoard();
        SaveLoad saveLoad = new SaveLoad(board);

        dice = new Dice();
        Button button = new Button();
        button.setGraphic(new ImageView(dice6));
        button.setOnAction(event -> {
            button.setGraphic(new ImageView(dice.diceThrow()));
            GameController gameController = new GameController(board, dice);
            gameController.isHomeCheck();
        });

        MenuButton menuButton = new MenuButton(board, dice, primaryStage, saveLoad);


        VBox group = new VBox(menuButton.menuBar());
        group.getChildren().add(board.getGridPane());


        board.getGridPane().add(button, 0, 0, 2,2);


        Scene scene = new Scene(group, 1600, 900);


        primaryStage.setTitle("Ludo - BoardGame");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
