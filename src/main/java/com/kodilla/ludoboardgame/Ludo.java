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

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Board board = new Board();
        board.setBoard();


        Dice dice = new Dice();
        Button button = new Button();
        button.setGraphic(new ImageView(dice6));
        button.setOnAction(event -> button.setGraphic(new ImageView(dice.diceThrow())));

        MenuButton menuButton = new MenuButton(board, dice);


        VBox group = new VBox(menuButton.menuBar());
        group.getChildren().add(board.getGridPane());


        board.getGridPane().add(button, 0, 0, 2,2);


        Scene scene = new Scene(group, 1600, 900);


        primaryStage.setTitle("Ludo - BoardGame");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
