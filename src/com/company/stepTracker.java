package com.company;
import java.util.Scanner;
public class stepTracker {

    // Данные о шагах за определенный месяц
    static int[][] fullStep2D = new int[31][13];

    // Изменение целевого количества шагов
    public static int changeStepForDay() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int newStepForDay = sc.nextInt();
            if (newStepForDay > 0) {
                return newStepForDay;
            } else {
                askOtherNumber();
            }
        }
    }

    //  Сохранение пройденных шагов
     public static void enterStatistic() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Какое сегодня число?");
        int day = scan.nextInt();
        while (day < 1 || day > 31) {
            askOtherNumber();
            day = scan.nextInt();
            // continue;
        }
            System.out.println("Какой сейчас месяц?");
            int month = scan.nextInt();
            while (month < 1 || month > 13) {
                askOtherNumber();
                month = scan.nextInt();
                //  continue;
            }


            System.out.println("Введите количество пройденных шагов");
            fullStep2D[day][month] = scan.nextInt();
            System.out.println(day + "." + month + "." + " шагов: " + fullStep2D[day][month]);
    }


        // Вывод статистики:
        static void printStatistic(int month) {
            // количество шагов по дням
            for (int i = 1; i < 31; i++) {
                System.out.print("День " + i + ": " + fullStep2D[i][month] + ", ");
            }
            System.out.print("\n");

            // общее количество шагов за месяц
            int sumSteps = 0;
            for (int i = 1; i < 31; i++) {
                sumSteps = sumSteps + fullStep2D[i][month];
            }
            System.out.println("За месяц вы прошли: " + sumSteps + " шагов.");

            // Максимальное кол шагов в месяце
            int maxStep = 0;
            int max = getMaxStep(fullStep2D, month, maxStep);
            System.out.println("Максимальное количество шагов: " + max);

            // среднее количество шагов
            System.out.println("Среднее количество шагов: " + (sumSteps / 30));

            // пройденная дистанция
            Converter.regDistance(sumSteps);

            // Количество сожженных килокалорий
            Converter.regKal(sumSteps);
        }

        // лучшая серия: максимальное количество подряд идущих дней когда шагов за день было равно или выше целевого
        static void getBestCount(int stepDay, int month){
            int k = 0;
            int finishBestCount = 0;
            for (int i = 1; i < 31; i++) {
                if (fullStep2D[i][month] >= stepDay) {
                    k++;
                } else if (k > finishBestCount) {
                    finishBestCount = k;
                    k = 0;
                }

            }
            System.out.println("Максимальная серия максимальных шагов: " + finishBestCount + " дней.");
        }
        // Максимальное кол шагов в месяце
        public static int getMaxStep(int[][] fullStep2D, int month, int maxStep){
            for (int i = 1; i < 31; i++) {
                if (fullStep2D[i][month] > maxStep) {
                    maxStep = fullStep2D[i][month];
                }
            }
            return maxStep;
        }

        public static void askOtherNumber() {

            System.out.println("Вы ввели неправильное число! Попробуйте снова.");
        }


    }
