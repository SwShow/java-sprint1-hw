package com.company;

class Converter {

    public static void regDistance(int sumSteps) {
        int kilometres = sumSteps * 75 / 100000;
        System.out.println("Вы прошли: " + kilometres + " километров");
    }

    public static void regKal(int sumSteps) {
        int energy = sumSteps * 50 / 1000;
        System.out.println("Вы потратили: " + energy + " килокалорий!");
    }
}