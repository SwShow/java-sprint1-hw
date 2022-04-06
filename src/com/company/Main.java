package com.company;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        // Целевое количество шагов
        int StepForDay = 10000;
        System.out.println("Доброго времени суток!");
        System.out.println("Ваша цель на сегодня пройти " + StepForDay + " шагов!");


        Scanner scan = new Scanner(System.in);
        while (true) {
            printMenu();
            int command = scan.nextInt();
            if (command == 1) {
                stepTracker.enterStatistic();
            }else if (command == 2) {
                System.out.println("За какой месяц показать статистику?");
                int month = scan.nextInt();
                stepTracker.printStatistic(month);
                stepTracker.getBestCount(StepForDay, month);
            } else if (command == 3) {
                System.out.println("Внесите новую цель:");
                StepForDay = stepTracker.changeStepForDay();
                System.out.println("Ваша новая цель: " + StepForDay);
            } else if (command == 4) {
                System.out.println("Выход");
                break;
            } else {
                stepTracker.askOtherNumber();
            }
        }
    }






    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Внести количество шагов за определенный день");
        System.out.println("2 - Напечатать статистику за определенный месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выход");

    }

}




