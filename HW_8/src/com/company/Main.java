package com.company;

import sun.org.mozilla.javascript.internal.ast.WhileLoop;

import java.util.Scanner;

public class Main {
    static final String [] NUM_FROM_10_TO_19 = new String []{"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    static final String [] NUM_FOR_TENS = new String[]{"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    static final String [] NUM_TO_STRING = new String []{"","one","two","three","four","five","six","seven","eight","nine"};


    public static void main(String[] args) {


        int arr1[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr3[] = new int[]{2, 2, 2, 3, 3, 4, 6, 4, 9, 9, 9, 9, 7, 7, 8, 4, 6, 4, 4, 5};
        int arr4[] = new int[]{45, 64, 64, 48, 6876, 446, 64, 48, 64, 48, 64, 486, 8, 4, 6, 4, 6, 8, 1, 6879, 3, 1, 4, 6, 4, 7, 6, 9, 6877, 3, 1, 6, 6, 7, 6, 1, 6, 9, 9, 4};
        double arr6[] = new double[]{-3.5, -2.5, -1.5, -0.5, 0.5, 1.5, 2.5, 3.5};
        int int7 = 959719299;
        int int8 = 12345678;
        int int9 = 19;
        int int10 = 101;


        output(task1(arr1));
        output(task2(arr1, 8));
        output(task3(arr3));
        output(task4(arr4));
        output(task5(arr1));
        output(task6(arr6));
        output(task7(int7));
        output(task8(int8));
        output(task9(int9));
        output(task10(int10));



    }

    static void output(String out) {
        System.out.println(out);
    }



    static String task1 (int arr[]){
        double sredn = 0;
        for (int x:arr){
        sredn    += x;
        }
        return "Среднее = "+(sredn/arr.length);
    }

    static String task2 (int arr[], int lowerThan){
        double sredn = 0;
        for (int x:arr){
            if (x < lowerThan) sredn += x;
        }
        return "Среднее меньше числа "+lowerThan+" = "+(sredn/arr.length);
    }

    static String task3 (int arr[]){
        int count = 0;
        int i = 1;
        while (i < arr.length){
            if (arr[i-1] ==  arr[i]) count++;
            i++;
        }
        return "Количество элементов, идущих подряд, равны между собои = "+count+". Различных же числе в массиве = "+(arr.length-count);
    }

    static String task4 (int arr[]){
        int max1 = 0, max2 = 0;
        int i=0;
        while (i < arr.length){
            if (arr[i] >= max1){
                max2 = max1;
                if (arr[i]> max1) max1 = arr[i];
            }
            else if (max2 != max1 && max2 < arr[i]) max2 = arr[i];
            i++;
        }
        return "Машины с самой большой скоростью "+max1+" и "+max2;
    }

    static String task5 (int arr[]){
        int sum = 0;
        for (int x : arr){
            sum += x;
        }
        return "Cумма всех чисел последовательности = "+sum+". Количество всех чисел "+arr.length;
    }

    static String task6 (double arr[]){
        int i = 0;
        int count = 0;
        while (i < arr.length && arr[i] < 0){
            count ++;
            i++;
        }
        return "Количество отрицательных чисел "+count;
    }

    static String task7 (int num){
        int count = 0;
        int max = 0;
        do {
            if (num%10 > max) {
                max = num%10;
                count = 1;
            }
            else if(num%10 == max) count++;
            num /= 10;
        }while (num > 0);
        return "Количество максимальных цифр в данном числе "+count;
    }

    static String task8 (int num){
        String mirorredNumString = "";
        int mirorredNum = 0;
        do {
            mirorredNumString += Integer.toString(num%10);
            num /= 10;
        }while (num > 0);
        mirorredNum = Integer.parseInt(mirorredNumString);
        return "Pеркальное отражение в виде числа "+mirorredNum;
    }

    static String task9 (int num){
        if (num < 20 && num > 9) return "Число "+num+" = "+NUM_FROM_10_TO_19[num%10];
        else if (num >19 && num <100) return "Число "+num+" = "+NUM_FOR_TENS[num/10-2]+NUM_TO_STRING[num%10];
        else return "Число не 2х значное";
    }

    static String task10 (int num){
        if (num >= 0 && num <20) num = 0;
        else if (num >= 20 && num < 40) num = 1;
        else if (num >=40 && num < 60) num = 2;
        else if (num >= 60 && num < 74) num = 3;
        else if (num >= 75 && num < 89) num = 4;
        else if (num >= 91 && num <= 100) num = 5;
        switch (num){
            case 0:return "Mark F";
            case 1:return "Mark E";
            case 2:return "Mark D";
            case 3:return "Mark C";
            case 4:return "Mark B";
            case 5:return "Mark A";
            default:return "неверная оценка";
        }
    }





}
