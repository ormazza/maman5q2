package com.company;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;
public  class ChopStick {
    // Make sure only one philosopher can have me at any time.
    Lock up = new ReentrantLock();
    // Who I am.
    private final int id;

    public ChopStick(int id) {
        this.id = id;
    }

    public boolean pickUp(Philosopher who, String where) throws InterruptedException {
        if (up.tryLock(10, TimeUnit.MILLISECONDS)) {
            Main.mat.chopUse[id].setEatTaken(true);
            Main.mat.repaint();
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void putDown(Philosopher who, String name) {
        up.unlock();
        Main.mat.chopUse[id].setEatTaken(false);
        Main.mat.repaint();
    }
}