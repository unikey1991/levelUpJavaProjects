package com.company;

import java.util.Scanner;

public class Main {

    static final String [] NUM_FROM_10_TO_19 = new String []{"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    static final String [] NUM_FOR_TENS = new String[]{"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    static final String [] NUM_FOR_ONES = new String []{"","one","two","three","four","five","six","seven","eight","nine"};

    public static void main(String[] args) {

        int arr1[] = new int[]{-200, -54, 100, 0, 500, 55, 9999};
        int num4 = 6;
        int num5 = 22115;
        int num6[] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String str7 = "seven hundred twenty one";

        System.out.println(task1(10, -4));
        System.out.println("Cумма только положительных из трех чисел = " + task2(arr1));
        System.out.println("Факториал числа " + num4 + "! = " + task4(num4));
        System.out.println("Сумма цифр числа " + num5 + " = " + task5(num5));
        System.out.println("Cумма элементов массива с нечетными индексами = " + task6(num6));
        System.out.println(task7(str7));
       // System.out.println(str7.charAt(4) == ' ');

    }

    //7.Вводим строку, которая содержит число, написанное прописью (0-999). Получить само число. Например, дана строка: seven hundred fifty two = 752.
    static int task7(String num){
        int count=0;
        String arr[] = new String[4];
        String strNum1 = "", strNum2 = "";
        int intNum = 0;
        for (int i = 0, j = 0; i < num.length(); i++){  // разбитие строки на отдельные слова и занесение в массив
            if (num.charAt(i) == ' ') {
                arr[count] = num.substring(j,i);
                count++;
                j = i + 1;
            }
            if (i == num.length()-1) arr[count] = num.substring(j,num.length()); // если цикл достик последнего элемента, то строку от последнего элемента до индекса последнего пробела пишем в массив
        }
        for (int y = 0; y<count+1; y++){ // перебираем массив слов и сравниваем с константой
            if (arr[y].equals("hundred")) strNum1 += "00";
                for (int k = 0; k < NUM_FOR_ONES.length; k++){  // присваиваем переменным значения в зависимости от найденых
                    if (arr[y].equals(NUM_FOR_ONES[k]) && y == 0)strNum1 += k;
                    else if (arr[y].equals(NUM_FOR_ONES[k])) intNum += k;
                }
                for (int k = 0; k < NUM_FOR_TENS.length; k++){
                    if (arr[y].equals(NUM_FOR_TENS[k]))strNum2 += (k+2)*10;
                }
                for (int k = 0; k < NUM_FROM_10_TO_19.length; k++){
                    if (arr[y].equals(NUM_FROM_10_TO_19[k]) && y == 0) strNum1 += k+10;
                    else if(arr[y].equals(NUM_FROM_10_TO_19[k])) strNum2 += k+10;
                }
        }
        if (strNum1.length()>0)intNum += Integer.parseInt(strNum1); // проверяем на не пустые строки
        if (strNum2.length()>0)intNum += Integer.parseInt(strNum2);
        return intNum;
    }

    static int findEquals(String x){
        for (int i = 0; i < NUM_FOR_ONES.length; i++){
            if (x.equals(NUM_FOR_ONES[i]))return i;
        }
        for (int i = 0; i < NUM_FOR_TENS.length; i++){
            if (x.equals(NUM_FOR_TENS[i]))return (i+2)*10;
        }
        for (int i = 0; i < NUM_FROM_10_TO_19.length; i++){
            if (x.equals(NUM_FROM_10_TO_19[i])) return i;
        }
        return 0;
    }

    //6.Посчитать сумму элементов массива с нечетными индексами
    static int task6(int num[]) {
        int sum = 0;
        int i = 1;
        while (i < num.length) {
            sum += num[i];
            i += 2;
        }
        return sum;
    }

    //5.Посчитать сумму цифр заданного числа.
    static int task5(int num) {
        String numStr = Integer.toString(num);
        int i = 0;
        num = 0;
        while (i < numStr.length()) {
            num += Character.getNumericValue(numStr.charAt(i));
            i++;
        }
        return num;
    }

    //1.Определить какой четверти принадлежит точка с координатами (х,у)
    static String task1(int x, int y) {
        if (x != 0 && y != 0) {
            if (x > 0) {
                if (y > 0) return "I область оси координат";
                else return "IV область оси координат";
            } else {
                if (y > 0) return "II область оси координат";
                else return "III область оси координат";
            }
        } else return "х и y не могут быть одновременно в 2х областях, по этому не могут быть = 0";
    }

    //2.Найти суммы только положительных из трех чисел /////// ЗЫ(если верно понял, то просуммировать 3х-значные числа)
    static int task2(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            if (x > 0 && x / 100 > 0 && x / 100 < 10) sum += x;
        }
        return sum;
    }

    //3.Посчитать выражение макс(а*б*с, а+б+с)+3
    static int task3() {
        return 0;
    }

    //4.Вычислить факториал числа n. n! = 1*2*...*n-1*n;
    static int task4(int num) {
        int factorial = 1;
        while (num > 0) {
            factorial *= num;
            num--;
        }
        return factorial;
    }


}


