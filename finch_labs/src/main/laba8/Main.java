package main.laba8;

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
        while(!(f.getButton("A") || f.getButton("B"))){
            check(f);
        }
    }

    public static void check(Finch f){
        int d = f.getDistance();
        if(d>40){
            f.setMove("F", 20, 95);
        }else{
            f.setTurn("L", 90, 95);
            check(f);
            f.setTurn("R", 90, 95);
            check(f);
        }
    }
}
