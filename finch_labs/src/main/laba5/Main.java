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

    public static void run(Finch f){

    }
}
