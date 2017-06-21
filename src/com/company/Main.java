package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static final int NUM_OF_PHILOSOPHER = 5;
    public static Matrix mat;

    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = null;

        Philosopher[] philosophers = null;
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(415, 450);
        mat = new Matrix();
        frame.add(mat);
        frame.setVisible(true);
        Graphics g = mat.getGraphics();
        mat.paintComponent(g);
        try {
            philosophers = new Philosopher[NUM_OF_PHILOSOPHER];
            ChopStick[] chopSticks = new ChopStick[NUM_OF_PHILOSOPHER];
            for (int i = 0; i < NUM_OF_PHILOSOPHER; i++) {
                chopSticks[i] = new ChopStick(i);
            }
            executorService = Executors.newFixedThreadPool(NUM_OF_PHILOSOPHER);
            for (int i = 0; i < NUM_OF_PHILOSOPHER; i++) {
                philosophers[i] = new Philosopher(i, chopSticks[i], chopSticks[(i + 1) % NUM_OF_PHILOSOPHER]);
                executorService.execute(philosophers[i]);
            }
        } finally {
            // Close everything down.
            executorService.shutdown();

            // Wait for all thread to finish
            while (frame.isActive()) {
                Thread.sleep(350);
            }

        }
    }
}
