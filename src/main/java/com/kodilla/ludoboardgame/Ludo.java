package com.kodilla.ludoboardgame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Ludo extends Application {

    //private Image image = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\ludo-board.jpg");
  //  private Image pawn = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\pawn.png", 40, 40, false, false);
    //private FlowPane pawns = new FlowPane(Orientation.HORIZONTAL);
    private Image dice6 = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\dice_6-512.png", 40,40,true, false);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    /*    BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);*/

       /* GridPane grid = new GridPane();
        //grid.setAlignment(Pos.BASELINE_CENTER);
        grid.setPadding(new Insets(40, 40, 40, 40)); // co to te marginesy wewnętrzne
        grid.setHgap(75.0);
        grid.setVgap(75.0);
        grid.setBackground(background);
        grid.setGridLinesVisible(true);*/

       /* Board board = new Board();
        board.setBoard();*/

   /*     Pawn pawn1 = new Pawn("Blue");
        Pawn pawn2 = new Pawn("Blue");
        Pawn pawn3 = new Pawn("Blue");*/
        //ImageView img = new ImageView(pawn);
        // pawn1.getPawns().getChildren().add(pawn1.getImg());
        //pawn1.getButton().setFitHeight(130.0);
        //pawn1.getButton().setFitWidth(150.0);

/*        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                grid.add(new Label(i + " " + j), i, j,2,2);
            }
        }*/

      /*  grid.add(pawn1.getPawn(), 466, 100, 1, 1);
        grid.add(button, 0, 0, 1,1);
        grid.add(pawn2.getPawn(), 4,0);
        grid.add(pawn3.getPawn(), 5,0);*/

        /*Button first = new Button();
        Button last = new Button();
        grid.add(first, 0,0,2,2);
        grid.add(last,19,9,2,2);*/


        Board board = new Board();
        board.setBoard();

        Dice dice = new Dice();
        Button button = new Button();
        button.setGraphic(new ImageView(dice6));
        button.setOnAction(event -> button.setGraphic(new ImageView(dice.diceThrow())));

        GameController gameController = new GameController(board, dice);
        gameController.setPlayer();


       // Pawn pawn1 = new Pawn("Blue",1, dice, board);
       // Pawn pawn2 = new Pawn("Blue",2, dice);

        //CompPlayer comp1 =  new CompPlayer("Blue");

        //board.getGridPane().add(pawn1.getPawn(),5,0,2,2);
       // board.getGridPane().add(pawn2.getPawn(),6,0,2,2);
       // board.getGridPane().add(comp1.getCompPawn(), 7, 7, 2, 2);
       /* button.fire();
        comp1.compMove();
        button.fire();
        comp1.compMove()*/;
        board.getGridPane().add(button, 0, 0, 2,2);
        System.out.println(board.getRedPlayer().size());
        System.out.println(board.getBluePlayer().size());
       // board.compMoveBoard();


        Scene scene = new Scene(board.getGridPane(), 1600, 900, Color.BLUEVIOLET);




        primaryStage.setTitle("Ludo - BoardGame");
        primaryStage.setScene(scene);
        primaryStage.show();
        //gameController.play();

    }

}
