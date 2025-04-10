package main.fractal;

import main.finch.Finch;

public class Fractal {
    public static final int speed = 100;
    public static final int dist = 3;

    public static void main(String[] args) {
        System.out.println("Program started");

        Finch f = new Finch();

        hilbertFractal(f);

        f.stopAll();
        f.disconnect();

        System.out.println("Program finished");
    }

    public static void hilbertFractal(Finch f) {
        f_x(f, 3);
    }

    public static void f_x(Finch f, int d){
        if (d<=0) return;
        f.setTurn("L", -90, speed);
        f_y(f, d-1);
        f.setMove("F", dist, speed);
        f.setTurn("L", 90, speed);
        f_x(f, d-1);
        f.setMove("F", dist, speed);
        f_x(f, d-1);
        f.setTurn("L", 90, speed);
        f.setMove("F", dist, speed);
        f_y(f, d-1);
        f.setTurn("L", -90, speed);
    }

    public static void f_y(Finch f, int d){
        if (d<=0) return;
        f.setTurn("L", 90, speed);
        f_x(f, d-1);
        f.setMove("F", dist, speed);
        f.setTurn("L", -90, speed);
        f_y(f, d-1);
        f.setMove("F", dist, speed);
        f_y(f, d-1);
        f.setTurn("L", -90, speed);
        f.setMove("F", dist, speed);
        f_x(f, d-1);
        f.setTurn("L", 90, speed);
    }
}
