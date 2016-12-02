package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        hello();
    }

    static int inputInt(){
        Scanner x = new Scanner(System.in);
        int z = x.nextInt();
        return z;
    }
    static String inputString(){
        Scanner x = new Scanner(System.in);
        String z = x.nextLine();
        return z;
    }

    static void hello(){
        System.out.println("==============================================================================");
        System.out.println("Введите номер задания для инициализации либо введите 0 для остановки программы");

        switch (inputInt()){
            case 0: break;
            case 1: task1(); break;
            case 2: task2(); break;
            case 3: task3(); break;
            case 4: task4(); break;
            case 5: task5(); break;
            default:System.out.println("Неверный ввод, повторите");hello();break;
        }
    }

    static void task1(){
        int arr[] = new int[20];
        String number;
        System.out.println("введите первое 20-значное число (каждую цифру по очереди)");
        number = inputString();
        if(number.length() != 20) {
            System.out.println("вы ввели не 20-значное число, начнем с начала");
            task1();
        }
        for (int i = 0; i<20; i++){
            arr[i]=Character.getNumericValue(number.charAt(i));
        }
        System.out.println("введите второе 20-значное число (каждую цифру по очереди)");
        number = inputString();
        if(number.length() != 20) {
            System.out.println("вы ввели не 20-значное число, начнем с начала");
            task1();
        }
        for (int i = 0; i<20; i++){
            arr[i]+=Character.getNumericValue(number.charAt(i));
        }
        System.out.print("результат сложение 2х 20-значных чисел = ");
        for (int i = 0; i<20; i++){
            System.out.print(arr[i]);
        }
        System.out.println();
        hello();
    }

    static void task2(){
        int num1 = -1, num2 = -1;
        System.out.println("введите длинну массива");
        int arr[] = new int [inputInt()];
        System.out.println("заполните массив числами вводя их раздельно");
        for (int i = 0; i<arr.length; i++){
            arr[i]=inputInt();
        }
        for (int i = 0; i<arr.length; i++){
            if (arr[i]%2 == 0 ){
                num1 = arr[i];
                break;
            }
        }
        if (num1 >= 0) System.out.println("индекс первого нечетного элемента "+num1);
        else System.out.println("нечетных элементов в массиве нет");
        for (int i = 0; i<arr.length; i++){
            if (arr[i]%13 == 0 ){
                num2 = arr[i];
                break;
            }
        }
        if (num1 >= 0) System.out.println("индекс первого элемента кратного 13 "+num1);
        else System.out.println("элементов кратных 13 нет");
        hello();
    }

    static void task3(){
        int count = 0;
        System.out.println("введите кол. учеников");
        int arr[] = new int [inputInt()];
        System.out.println("введите рост в см каждого из них раздельно");
        for (int i = 0; i<arr.length; i++){
            arr[i]=inputInt();
        }
        for (int i = 0; i<arr.length; i++){
            if (arr[i] > 170 ){
                count++;
            }
        }
        System.out.println("количество учеников с ростом более 170 см "+count);
        if (count >= 5) System.out.println("можно сформировать баскетбольную команду");
        else System.out.println("сформировать баскетбольную команду не выйдет");
        hello();
    }

    static void task4(){
        int count = 0;
        int max = 0;
        System.out.println("введите кол. человек");
        int arr[] = new int [inputInt()];
        System.out.println("введите рост в см каждого из них раздельно");
        for (int i = 0; i<arr.length; i++){
            arr[i]=inputInt();
        }
        for (int i = 0; i<arr.length; i++){
            if (arr[i] > max ){
                max = arr[i];
                count = 0;
                count++;
            }
            else if (arr[i] == max) count++;
        }
        System.out.println("количество человек с самым большим ростом "+count);
        hello();
    }

    static void task5(){
        int max = 0;
        int min;
        System.out.println("введите кол. человек");
        int arr[] = new int [inputInt()];
        System.out.println("введите год рождения каждого из них раздельно");
        for (int i = 0; i<arr.length; i++){
            arr[i]=inputInt();
        }
        min=arr[0];
        for (int i = 0; i<arr.length; i++){
            if (arr[i] > max ) max = arr[i];
            if (arr[i] < min) min = arr[i];
        }
        System.out.println("возраст самого старого человека превышает возраст самого молодого на "+(max-min));
        hello();
    }
}
