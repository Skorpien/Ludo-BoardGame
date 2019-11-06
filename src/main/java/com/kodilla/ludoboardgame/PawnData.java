package com.kodilla.ludoboardgame;

import java.io.Serializable;

public class PawnData implements Serializable {
    private boolean isHome;
    private int where;
    private int traveledFields;
    private boolean isFinishing;

    public PawnData (boolean isHome, int where, int traveledFields, boolean isFinishing) {
        this.isHome = isHome;
        this.where = where;
        this.traveledFields = traveledFields;
        this.isFinishing = isFinishing;
    }

    public boolean getIsHome() {
        return isHome;
    }

    public int getWhere() {
        return where;
    }

    public int getTraveledFields() {
        return traveledFields;
    }

    public boolean getIsFinishing() {
        return isFinishing;
    }
}
