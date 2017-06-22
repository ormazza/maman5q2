package com.company;

import java.util.Random;

public class Philosopher implements Runnable {
    private final int id;
    private static final int MIN_TIME_TO_EAT = 1000;
    private static final int MAX_TIME_TO_EAT = 3500;
    private final ChopStick largeIdChop;
    private final ChopStick smallIdChop;
    private Random randomGenerator = new Random();


    public Philosopher(int id, ChopStick leftChopStick, ChopStick rightChopStick) {
        this.id = id;
        if (leftChopStick.getId() > rightChopStick.getId()) {
            this.largeIdChop = leftChopStick;
            this.smallIdChop = rightChopStick;
        } else {
            this.largeIdChop = rightChopStick;
            this.smallIdChop = leftChopStick;
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                synchronized (smallIdChop) {
                    smallIdChop.pickUp();
                    if(largeIdChop.taken){
                        smallIdChop.putDown();
                        smallIdChop.notifyAll();
                        smallIdChop.wait();
                        smallIdChop.pickUp();
                    }
                    synchronized (largeIdChop) {
                        largeIdChop.pickUp();
                        eat();
                        largeIdChop.putDown();
                        largeIdChop.notifyAll();
                    }
                    smallIdChop.putDown();
                    smallIdChop.notifyAll();
                }

            }

        } catch (
                Exception e)

        {
            e.printStackTrace();
        }

    }

    private void think() throws InterruptedException {
        Thread.sleep(MIN_TIME_TO_EAT + randomGenerator.nextInt(MAX_TIME_TO_EAT - MIN_TIME_TO_EAT));
    }

    private void eat() throws InterruptedException {
        Matrix.philoEat[id].setEatTaken(true);
        Main.mat.repaint();
        Thread.sleep(MIN_TIME_TO_EAT + randomGenerator.nextInt(MAX_TIME_TO_EAT - MIN_TIME_TO_EAT));
        Matrix.philoEat[id].setEatTaken(false);
        Main.mat.repaint();
    }
}
