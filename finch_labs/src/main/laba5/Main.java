package main.laba5;

import main.finch.Finch;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program started");

        Finch f = new Finch();

        run(f);

        f.stopAll();
        f.disconnect();

        System.out.println("Program finished");
    }

    public static void run(Finch f) {

        double[][] arr = {
                {50., 180.},
                {50., 180.}
        };
        double speed = 99.;
        int runs = 2;

        f.setBeak(100, 100, 100);
        for (int i = 0; i < runs; i++){
            for (double[] data : arr) {
                f.setMove("F", data[0], speed);
                f.setTurn("L", data[1], speed);
            }
        }
        f.setBeak(0, 0, 0);
    }
}