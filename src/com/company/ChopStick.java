package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class ChopStick {
    boolean taken ;
    Lock up = new ReentrantLock();
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

    public int getId() {
        return id;
    }



}