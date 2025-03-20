package main.fractal;

import main.finch.Finch;

public class Fractal {
    public static final double speed = 75.;

    public static void main(String[] args) {
        System.out.println("Program started");

        Finch f = new Finch();

        f.stopAll();
        f.disconnect();

        System.out.println("Program finished");
    }

    public static void runHilbertFractal(Finch f, int depth){

    }
}
