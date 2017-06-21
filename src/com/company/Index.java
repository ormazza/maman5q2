package com.company;

public class Index {
    private int i;
    private int j;
    private boolean eatTaken;


    public Index(int i, int j){
        this.i = i;
        this.j = j;
        eatTaken = false;
    }

    public int getJ() {
        return j;
    }

    public int getI() {

        return i;
    }
    public void setEatTaken(boolean eatTaken) {
        this.eatTaken = eatTaken;
    }

    public boolean getBool() {

        return eatTaken;
    }

}
