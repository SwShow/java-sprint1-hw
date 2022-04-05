package com.company;
import java.util.Scanner;
public class Main {


    public static void main(String[] args) {

        System.out.println("Доброго времени суток!");
        System.out.println("Ваша цель на сегодня пройти " + "10000" + " шагов!");

        Scanner scan = new Scanner(System.in);

        while (true) {
            printMenu();
            int command = scan.nextInt();
            if (command == 1) {
                System.out.println("Внесите новую цель:");
                int stepForDay = stepTracker.changeStepForDay();
                System.out.println("Ваша новая цель: " + stepForDay);
            } else if (command == 2) {
                stepTracker.enterStatistic();
            } else if (command == 3) {
                stepTracker.printStatistic();
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
        System.out.println("1 - Изменить цель по количеству шагов в день");
        System.out.println("2 - Внести количество шагов за определенный день");
        System.out.println("3 - Напечатать статистику за определенный месяц");
        System.out.println("4 - Выход");

    }

}



