package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Matrix extends JPanel {
    private boolean[][] mat;
    private static final int SIZE = 70;
    private static final int SIZE_CUBE = 80;
    public static Index[] philoEat;
    public static Index[] chopUse;

    public Matrix() {
    philoEat = new Index[]{new Index(2, 0),new Index(4, 2),new Index(3, 4),new Index(1, 4),new Index(0, 2)};
    chopUse = new Index[]{new Index(1, 1),new Index(3, 1) ,new Index(4, 3),new Index(2, 4),new Index(0, 3)};
    }

    @Override
    public void  paintComponent(Graphics g){
        super.paintComponent(g);
        for (Index i:philoEat) {
            g.setColor(Color.red);
            if(i.getBool()) {
                g.setColor(Color.green);
            }
            g.fillRect(i.getI()*SIZE_CUBE,i.getJ()*SIZE_CUBE,SIZE,SIZE);
            g.drawRect(i.getI()*SIZE_CUBE,i.getJ()*SIZE_CUBE,SIZE,SIZE);
        }

        for (Index i:chopUse) {
            g.setColor(Color.red);
            if(i.getBool()){
                g.setColor(Color.green);
            }
            g.fillRect(i.getI()*SIZE_CUBE+20,i.getJ()*SIZE_CUBE+20,SIZE/2,SIZE/2);
            g.drawRect(i.getI()*SIZE_CUBE+20,i.getJ()*SIZE_CUBE+20,SIZE/2,SIZE/2);
        }


    }

}
