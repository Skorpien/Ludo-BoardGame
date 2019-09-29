package com.kodilla.ludoboardgame;

public class BoardField {
    private int row;
    private int column;
    private Pawn pawn;

    public BoardField (int row, int column, Pawn pawn) {
        this.row = row;
        this.column = column;
        this.pawn = pawn;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }
}
