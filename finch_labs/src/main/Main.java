package main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program started");

        Finch f = new Finch(); 

        evaluateMovement(f);

        evaluateTurning(f);

        f.stopAll();
        f.disconnect();

        System.out.println("Program finished");
    }


    private static void evaluateMovement(Finch f) {
        for (int i = 0; i < 5; i++) {
            f.setMove((i%2==0)?"F":"B", 100.0, 100.0);
            f.pause(5);
            System.out.println(i);
        }


        for (double speed : new double[]{20.0f, 40.0f, 60.0f}) {
            for (int i = 0; i < 5; i++) {
                long startTime = System.currentTimeMillis();
                f.setMove((i%2==0)?"F":"B", 100.0, speed);
                f.pause(5);
                f.stopWheels();
                long elapsedTime = System.currentTimeMillis() - startTime;
                System.out.println("Speed: " + speed + ", Time: " + elapsedTime + " ms");
                f.pause(2);
            }
        }
    }

    private static void evaluateTurning(Finch f) {
        for (int i = 0; i < 5; i++) {
            f.setTurn("R", 360, 100);
            f.pause(5);
            f.stopWheels();
            f.pause(2);
        }


        for (int speed : new int[]{20, 40, 60}) {
            for (int i = 0; i < 5; i++) {
                long startTime = System.currentTimeMillis();
                f.setTurn("R", 360, speed);
                f.pause(4);
                f.stopWheels();
                long elapsedTime = System.currentTimeMillis() - startTime;
                System.out.println("Turn Speed: " + speed + ", Time: " + elapsedTime + " ms");
                f.pause(2);
            }
        }
    }
}