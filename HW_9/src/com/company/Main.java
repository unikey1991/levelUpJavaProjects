package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Student studentsList[] = new Student[2];  // массив студентов
    static boolean notEmpty = false;

    public static void main(String[] args) {


        menu(); // главное меню


    }

    static void menu() {
        System.out.println();
        System.out.print("Какую программу хотите запустить?\n" +
                "1 - Калькулятор  \n2 - Запись абитуриентов в Хогвардс \n3 - Отобразить заполненый список студентов\n0 - Выход : ");
        switch (inputInt()) {
            case 0:
                break;
            case 1:
                calc();
                break;
            case 2:
                fillStudensListAndRandomFaculty(studentsList);
                break;
            case 3:
                showStudentList(studentsList);
                break;
            default:
                System.out.println("Повторите выбор");
                menu();
                break;
        }
    }

    static void showStudentList(Student arr[]) {  //вывод всего массива студентов на экран
        if (notEmpty) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i].toString());
            }
        } else System.out.println("Сперва список необходимо заполнить программой №2");
        menu();
    }

    static int inputInt() {
        Scanner x = new Scanner(System.in);
        int z = x.nextInt();
        return z;
    }

    static String inputString() {
        Scanner x = new Scanner(System.in);
        String z = x.nextLine();
        return z;
    }

    static String nameInput() {
        System.out.print("Введите имя : ");
        return inputString();
    }

    static String surNameInput() {
        System.out.print("Введите фамилию :");
        return inputString();
    }

    static int ageInput() {
        System.out.print("Введите возвраст :");
        return inputInt();
    }

    static Lang langSelection() { // программа для выбора языка при заполнении массива студентов
        System.out.print("Язык студента en или ru? :");
        String x = inputString();
        switch (x) {
            case "en":
                return Lang.EN;
            case "ru":
                return Lang.RU;
            default:
                System.out.println("Неверный язык, повторите ввод");
                return langSelection();
        }
    }


    /*               6) Дан массив из 20 студентов.
     Определить к какому факультету в школе магии Хогвартс будет зачислен каждый из них.
     Учесть то, что к каждому факультету может быть зачислено не более пяти новых студентов.
     Также факультеты могут быть определены только случайным образом.
     */

    static void fillStudensListAndRandomFaculty(Student arr[]) {
        int count[] = new int[4];
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Студент " + (i + 1) + ":");
            while (true) {
                Faculty f = randomFaculty();
                if (f.equals(Faculty.GRYFFINDOR) && count[0] < 5) {
                    count[0]++;
                    arr[i] = new Student(nameInput(), surNameInput(), ageInput(), langSelection(), f);
                    break;
                } else if (f.equals(Faculty.SLYTHERIN) && count[1] < 5) {
                    count[1]++;
                    arr[i] = new Student(nameInput(), surNameInput(), ageInput(), langSelection(), f);
                    break;
                } else if (f.equals(Faculty.HUFFLEPUFF) && count[2] < 5) {
                    count[2]++;
                    arr[i] = new Student(nameInput(), surNameInput(), ageInput(), langSelection(), f);
                    break;
                } else if (f.equals(Faculty.RAVENCLAW) && count[3] < 5) {
                    count[3]++;
                    arr[i] = new Student(nameInput(), surNameInput(), ageInput(), langSelection(), f);
                    break;
                }
            }
        }
        notEmpty = true;
        menu();
    }

    /*
    5) Написать программу, которая случайным образом возвращает факультет в виде
       перечисления: GRYFFINDOR, SLYTHERIN, HUFFLEPUFF, RAVENCLAW.
       * Использовать для выполнения метод nextInt(), который можно вызвать у экземпляра класса Random.
     */

    static Faculty randomFaculty() {
        Random random = new Random();
        return Faculty.values()[random.nextInt(Faculty.values().length)];
    }


    //////////                                      1) Доделать консольный калькулятор :
    static void calc() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter operator: ");
        String operator = scanner.nextLine();

        System.out.print("Enter first operand: ");
        Object a = scanner.next();


        System.out.print("Enter second operand: ");
        Object b = scanner.next();
        if (b.toString().contains(".") || a.toString().contains(".")) {
            b = Double.parseDouble(b.toString());
            a = Double.parseDouble(a.toString());
        } else {
            b = Integer.parseInt(b.toString());
            a = Integer.parseInt(a.toString());
        }


        switch (operator) {
            case "+":
                if (a instanceof Integer && b instanceof Integer) {
                    System.out.println((a + operator + b) + " = " + Calc.sum((Integer) a, (Integer) b));
                    break;
                } else System.out.println((a + operator + b) + " = " + Calc.sum((Double) a, (Double) b));
                break;
            case "-":
                if (a instanceof Integer && b instanceof Integer) {
                    System.out.println((a + operator + b) + " = " + Calc.vichetanie((Integer) a, (Integer) b));
                    break;
                } else System.out.println((a + operator + b) + " = " + Calc.vichetanie((Double) a, (Double) b));
                break;
            case "*":
                if (a instanceof Integer && b instanceof Integer) {
                    System.out.println((a + operator + b) + " = " + Calc.umnoj((Integer) a, (Integer) b));
                    break;
                } else System.out.println((a + operator + b) + " = " + Calc.umnoj((Double) a, (Double) b));
                break;
            case "/":
                if (a instanceof Integer && b instanceof Integer) {
                    System.out.println((a + operator + b) + " = " + Calc.delenie((Integer) a, (Integer) b));
                    break;
                } else System.out.println((a + operator + b) + " = " + Calc.delenie((Double) a, (Double) b));
                break;
            default:
                System.out.println("Invalid operator");
                break;
        }
        exit();
    }

    static void exit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would like to continue? Enter y/n: ");
        String exitWord = scanner.nextLine();
        switch (exitWord) {
            case "y":
                calc();
                break;
            case "n":
                menu();
                break;
            default:
                exit();
                break;
        }
    }

}