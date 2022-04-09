package com.company;

import java.util.Scanner;

public class StepTracker {


    // Данные о шагах за определенный месяц,
    static int[][] fullStep2D = new int[30][12];

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
    static void enterStatistic() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Какое сегодня число?");
        int day = scan.nextInt();
        while (day < 1 || day > 30) {
            askOtherNumber();
            day = scan.nextInt();
        }
        System.out.println("Какой сейчас месяц?");
        int month = scan.nextInt();
        while (month < 1 || month > 12) {
            askOtherNumber();
            month = scan.nextInt();

        }

        System.out.println("Введите количество пройденных шагов");
        int i = day - 1;
        int j = month - 1;
        fullStep2D[i][j] = scan.nextInt();
        while (fullStep2D[i][j] < 0) {
            askOtherNumber();
            fullStep2D[i][j] = scan.nextInt();
        }
        System.out.println(day + "." + month + "." + " шагов: " + fullStep2D[i][j]);
    }

    // Вывод статистики:
    static void printStatistic(int month) {
        int j = month - 1;
        // количество шагов по дням
        for (int i = 0; i < fullStep2D.length; i++) {
            System.out.print("День " + (i + 1) + ": " + fullStep2D[i][j] + ", ");
        }
        System.out.print("\n");

        // общее количество шагов за месяц
        int sumSteps = 0;
        for (int i = 0; i < fullStep2D.length; i++) {
            sumSteps = sumSteps + fullStep2D[i][j];
        }
        System.out.println("За месяц вы прошли: " + sumSteps + " шагов.");

        // Максимальное кол шагов в месяце
        int maxStep = 0;
        int max = getMaxStep(month, maxStep);
        System.out.println("Максимальное количество шагов: " + max);

        // среднее количество шагов
        System.out.println("Среднее количество шагов: " + (sumSteps / fullStep2D.length));

        // пройденная дистанция
        Converter.regDistance(sumSteps);

        // Количество сожженных килокалорий
        Converter.regKal(sumSteps);
    }

    // лучшая серия: максимальное количество подряд идущих дней когда шагов за день было равно или выше целевого
    static void getBestCount(int stepDay, int month) {
        int k = 0;
        int j = month - 1;
        int finishBestCount = 0;
        for (int i = 0; i < fullStep2D.length; i++) {
            if (fullStep2D[i][j] >= stepDay) {
                k++;
            } else if (k > finishBestCount) {
                finishBestCount = k;
                k = 0;
            }

        }
        System.out.println("Максимальная серия максимальных шагов: " + finishBestCount + " дней.");
    }

    // Максимальное кол шагов в месяце
    public static int getMaxStep(int month, int maxStep) {
        int j = month - 1;
        for (int i = 0; i < fullStep2D.length; i++) {
            if (fullStep2D[i][j] > maxStep) {
                maxStep = fullStep2D[i][j];
            }
        }
        return maxStep;
    }

    public static void askOtherNumber() {

        System.out.println("Вы ввели неправильное число! Попробуйте снова.");
    }

}
