package com.kodilla.ludoboardgame;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Dice {
    private Image dice1 = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\dice_1-512.png",  40,40,true, false);
    private Image dice2 = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\dice_2-512.png",  40,40,true, false);
    private Image dice3 = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\dice_3-512.png",  40,40,true, false);
    private Image dice4 = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\dice_4-512.png",  40,40,true, false);
    private Image dice5 = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\dice_5-512.png",  40,40,true, false);
    private Image dice6 = new Image("file:E:\\JAVA\\IntelliJ IDEA 2019.2\\Projects\\kodilla-course\\ludo-boardgame\\src\\main\\resources\\dice_6-512.png", 40,40,true, false);
    private int result;
    private boolean diceIsThrow = false;
    private boolean isHome = true;
    private Image dice;
    private Button button = new Button();

    Random random = new Random();

    public Image diceThrow () {
        if(!diceIsThrow || isHome) {
        result = random.nextInt(6);
                if (result == 0) {
                    diceIsThrow = true;
                    dice = dice1;
                } else if (result == 1) {
                    diceIsThrow = true;
                    dice = dice2;
                } else if (result == 2) {
                    diceIsThrow = true;
                    dice = dice3;
                } else if (result == 3) {
                    diceIsThrow = true;
                    dice = dice4;
                } else if (result == 4) {
                    diceIsThrow = true;
                    dice = dice5;
                } else if (result == 5) {
                    diceIsThrow = true;
                    dice = dice6;
                } else {
                    System.out.println("BUG");
                    return null;
                }
            }
        return dice;
        }

        public void showDice () { // how can i show dice when is comp turn?
            button.setGraphic(new ImageView(dice));
        }

    public Image compDiceThrow() { // is necessary...?
        result = random.nextInt(6);
        if (result == 0) {
            dice = dice1;
        } else if (result == 1) {
            dice = dice2;
        } else if (result == 2) {
            dice = dice3;
        } else if (result == 3) {
            dice = dice4;
        } else if (result == 4) {
            dice = dice5;
        } else if (result == 5) {
            dice = dice6;
        } else {
            System.out.println("BUG");
            return null;
        }
        return dice;
    }

   /* public void isHomeCheck () {
        if (dice.getResult()<5) {
            boolean allIsHome = true;
            for (Pawn pawn : board.getBluePlayer()
            ) {
                if (!pawn.getIsHome()) {
                    allIsHome = false;
                    break;
                }
            }
            if (allIsHome) {
                play();
            }
        }
    }*/

    public int getResult() {
        return result;
    }
    public boolean getDiceIsThrow() {
        return diceIsThrow;
    }

    public void setDiceIsThrow(boolean diceIsThrow) {
        this.diceIsThrow = diceIsThrow;
    }

    public void setHome(boolean home) {
        isHome = home;
    }

}
