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
        int N = 40;
        int left = 0, right = 0;
        for (int i = 0; i < N; i++){
            left  += f.getLine("L");
            right += f.getLine("R");
            f.pause(1.0/N);
        }
        left /= N;
        right /= N;
        int s = 16;
        System.out.println("avg font left: "+left+"  right: "+right);
        while(!(f.getButton("A") || f.getButton("B"))){
            int dl = left  - f.getLine("L");
            int dr = right - f.getLine("R");
            f.setMotors(bound(s - dl, 1, 16), bound(s - dr, 1, 16));
            f.pause(0.01);
        }
    }

    public static int bound(int n, int a, int b){
        return Math.min(Math.max(n, a), b);
    }
}
