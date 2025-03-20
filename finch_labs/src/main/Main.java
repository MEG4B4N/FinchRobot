package main;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program started");

        Finch f = new Finch();

        // Массив пар (расстояние, курс)
        double[][] movements = {
                {50, 0},   // 50 см вперед, курс 0 градусов
                {30, 90},  // 30 см вперед, курс 90 градусов (поворот направо)
                {40, 180}, // 40 см вперед, курс 180 градусов (поворот назад)
                {20, 270}  // 20 см вперед, курс 270 градусов (поворот налево)
        };

        // Количество прогонов для оценки погрешности
        int numRuns = 5;

        // Массив для хранения конечных координат
        double[][] finalPositions = new double[numRuns][2]; // [x, y]

        for (int run = 0; run < numRuns; run++) {
            System.out.println("Run " + (run + 1));

            // Начальные координаты (0, 0)
            double x = 0;
            double y = 0;
            double currentAngle = 0; // Начальный курс

            for (double[] movement : movements) {
                double distance = movement[0];
                double targetAngle = movement[1];

                // Поворот на целевой курс
                double angleDifference = targetAngle - currentAngle;
                f.setTurn("R", angleDifference, 50); // Поворот вправо на angleDifference градусов
                f.pause(1); // Пауза для завершения поворота
                currentAngle = targetAngle;

                // Движение вперед на заданное расстояние
                f.setMove("F", distance, 50); // Движение вперед на distance см
                f.pause(1); // Пауза для завершения движения

                // Обновление координат
                x += distance * Math.cos(Math.toRadians(currentAngle));
                y += distance * Math.sin(Math.toRadians(currentAngle));
            }

            // Запись конечных координат
            finalPositions[run][0] = x;
            finalPositions[run][1] = y;

            System.out.println("Final position: (" + x + ", " + y + ")");

            // Возврат робота в начальную точку
            f.resetEncoders();
            f.pause(1);
        }

        f.stopAll();
        f.disconnect();

        // Оценка погрешности
        double avgX = 0, avgY = 0;
        for (int i = 0; i < numRuns; i++) {
            avgX += finalPositions[i][0];
            avgY += finalPositions[i][1];
        }
        avgX /= numRuns;
        avgY /= numRuns;

        System.out.println("Average final position: (" + avgX + ", " + avgY + ")");

        // Вычисление стандартного отклонения
        double stdDevX = 0, stdDevY = 0;
        for (int i = 0; i < numRuns; i++) {
            stdDevX += Math.pow(finalPositions[i][0] - avgX, 2);
            stdDevY += Math.pow(finalPositions[i][1] - avgY, 2);
        }
        stdDevX = Math.sqrt(stdDevX / numRuns);
        stdDevY = Math.sqrt(stdDevY / numRuns);

        System.out.println("Standard deviation: (" + stdDevX + ", " + stdDevY + ")");

        System.out.println("Program finished");
    }
}