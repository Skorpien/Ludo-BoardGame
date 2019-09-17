package com.kodilla.ludoboardgame;

public class BoardField {
    int row;
    int column;

    public BoardField (int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
