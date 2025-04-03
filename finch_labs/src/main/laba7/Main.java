package main.laba7;


import main.finch.Finch;

class Main{
    public static void main(String[] args) {
        System.out.println("Program started");

        Finch f = new Finch();

        run(f);

        f.stopAll();
        f.disconnect();

        System.out.println("Program finished");
    }

    public static void run(Finch f){
        int N = 100;
        double diff = 0.0, sq_diff = 0.0;
        f.setBeak(100, 100, 100);
        for (int i = 0; i < N; i++){
            double[] acc = f.getAcceleration();
            double a = acc[0] * acc[0] + acc[1] * acc[1] + acc[2] * acc[2];
            sq_diff += a;
            diff += Math.sqrt(a);
            f.pause(1.0/N);
        }
        System.out.println("Diff: "+diff/N+"   Square Diff: "+Math.sqrt(sq_diff/N));
        System.out.println("start");
        while(!(f.getButton("A") || f.getButton("B"))){
            double[] acc = f.getAcceleration();
            double a = Math.sqrt(acc[0] * acc[0] + acc[1] * acc[1] + acc[2] * acc[2]);
            if(a > diff/N+0.5){
                f.setBeak(100, 0, 0);
            }else{
                f.setBeak(0, 100, 0);
            }
            f.pause(0.01);
        }
    }

    public static void run2(Finch f){
        int N = 100;
        double diff = 0.0, sq_diff = 0.0;
        f.setBeak(100, 100, 100);
        for (int i = 0; i < N; i++){
            double[] acc = f.getAcceleration();
            double a = acc[0] * acc[0] + acc[1] * acc[1] + acc[2] * acc[2];
            sq_diff += a;
            diff += Math.sqrt(a);
            f.pause(1.0/N);
        }
        System.out.println("Diff: "+diff/N+"   Square Diff: "+Math.sqrt(sq_diff/N));
        System.out.println("start");
        while(!(f.getButton("A") || f.getButton("B"))){
            double[] acc = f.getAcceleration();
            f.setBeak(50+(int)bound(acc[0], -10, 10)*5, 50+(int)bound(acc[1], -10, 10)*5, 50+(int)bound(acc[2], -10, 10)*5);
            f.pause(0.01);
        }
    }

    public static double bound(double n, double a, double b){
        return Math.min(Math.max(n, a), b);
    }
}