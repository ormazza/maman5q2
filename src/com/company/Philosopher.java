package com.company;

import java.util.Random;

public class Philosopher implements Runnable {
    private final int id;
    private final ChopStick larghIdChop;
    private final ChopStick smallIdChop;
    private Random randomGenerator = new Random();


    public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick) {
        this.id = id;
        if(leftChopStick.getId()>rightChopStick.getId()){
            this.larghIdChop = leftChopStick;
            this.smallIdChop = rightChopStick;
        }
        else {
            this.larghIdChop = rightChopStick;
            this.smallIdChop = leftChopStick;
        }
    }

    @Override
    public void run() {

        try {
            while (true){
                // Think for a bit.
                think();
                // Make the mechanism obvious.

                if (smallIdChop.pickUp(this, "left")) {
                    if (larghIdChop.pickUp(this, "right")) {
                        // Eat some.
                        eat();
                        // Finished.
                        larghIdChop.putDown(this, "right");
                    }
                    // Finished.
                    smallIdChop.putDown(this, "left");
                }
            }
        } catch (Exception e) {
            // Catch the exception outside the loop.
            e.printStackTrace();
        }
    }

    private void think() throws InterruptedException {
        Thread.sleep(1000+randomGenerator.nextInt(2500));
    }

    private void eat() throws InterruptedException {
        Matrix.philoEat[id].setEatTaken(true);
        Main.mat.repaint();
        Thread.sleep(1000+randomGenerator.nextInt(2500));
        Matrix.philoEat[id].setEatTaken(false);
        Main.mat.repaint();
    }
}
