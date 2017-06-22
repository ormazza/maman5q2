package com.company;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;

public class ChopStick {
    Lock up = new ReentrantLock();
    private final int id;

    public ChopStick(int id) {
        this.id = id;
    }

    public boolean pickUp() {
        if (up.tryLock()) {
            Main.mat.chopUse[id].setEatTaken(true);
            Main.mat.repaint();
            return true;
        }
        return false;
    }


    public void putDown() {
        up.unlock();
        Main.mat.chopUse[id].setEatTaken(false);
        Main.mat.repaint();
    }

    public int getId() {
        return id;
    }

}