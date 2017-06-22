package com.company;
public class ChopStick {
    private boolean taken ;
    private final int id;

    public ChopStick(int id) {
        taken = false;
        this.id = id;
    }

    public void pickUp() {
            taken = true;
            Main.mat.chopUse[id].setEatTaken(true);
            Main.mat.repaint();

    }


    public void putDown() {
        taken = false;
        Main.mat.chopUse[id].setEatTaken(false);
        Main.mat.repaint();
    }

    public boolean isTaken() {
        return taken;
    }

    public int getId() {
        return id;
    }



}