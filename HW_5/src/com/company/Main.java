package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {


        int arr1[] = new int[20];       //1. Вывести на экран возрастающую последовательность из 10 чисел начиная с 15.
        fillArray(10,15,0,1,arr1,true);
        System.out.println(Arrays.toString(arr1));

        int arr2[] = new int[20];       //2. Вывести на экран убывающую последовательность нечетных чисел в интервале от 33 до 15.
        fillArray(0,33,15,2,arr2,false);
        System.out.println(Arrays.toString(arr2));

        String arrString3[] = new String[]{"asd","adf","afaf","gsga","442134"};      //3. Написать программу для вывода на экран всех элементов массива строк через запятую.
        displayStringArrayContent(arrString3);

        int arr4[] = new int [] {1,3,7,9,2,4,3};    //4. Написать программу для вывода на экран всех элементов массива чисел в обратном порядке.
        displayArrayMirror(arr4);

        int arr5[]= new int[20];        //5. Написать программу для заполнения 20 элементов массива чисел с шагом 3, первым элементом которого будет 5
        fillArray(20,5,0,3,arr5,true);
        System.out.println(Arrays.toString(arr5));
        fillArrayWithProgression(arr5,10,20);

        int arr6[]= new int [20];        //6. Написать программу для заполнения массива чисел из 10 элементов значениями переменной а, при условии что а является членом арифметической прогрессии 2а-1, а1=4.
        System.out.println(Arrays.toString(arr6));

        int arr7[]=new int[]{-5,-20,8,7,9}; //7. Выяснить, верно ли, что сумма элементов массива есть неотрицательное число, используя тернарный оператор.
        infoOfArray(arr7,true,false,false,false,false,false);

        /*8. Дан массив чисел. Используя тернарный оператор определить:
        а) максимальный элемент;
        б) минимальный элемент;
        в) на сколько максимальный элемент больше минимального;
        г)  индекс максимального элемента;
        д) индекс минимального и индекс максимального элементов.*/
        int arr8[] = new int []{4,9,10,20,24};
        infoOfArray(arr8,false,true,true,true,true,true);  //реализовал метод отображения инфы по массиву с выбором отображаемых параметров

    }

    static void infoOfArray(int array[], boolean showSumOfArrayContentIsPositive, boolean showMaxDigit, boolean showMinDigit, boolean showMaxDigitIndex, boolean showMinDigitIndex, boolean showHowMachMoreMaxThenMin){
        System.out.println("");
        System.out.println("=== Информация о массиве ===");
        System.out.println("Включены следующие параметры отображения:");
        if(showMaxDigit){
            int max = 0;
            for(int i = 0; i < array.length; i++){
                max = (max > array[i])? max : (max = array[i]);
            }
            System.out.println("Максимальный элемент массива = "+max);
        }
        if(showMinDigit){
            int min = array[0];
            for(int i = 0; i < array.length; i++){
                min = (min < array[i])? min : (min = array[i]);
            }
            System.out.println("Минимальный элемент массива = "+min);
        }
        if(showSumOfArrayContentIsPositive){
            int sum = 0;
            for(int i = 0; i<array.length; i++){
                sum += array[i];
            }
            String b = (sum >= 0)? "Сумма чисел массива = " + sum + " и она положительна" : "Сумма чисел массива = " + sum + " и она отрицательна";
            System.out.println(b);
        }
        if(showMaxDigitIndex){
            int indexOfMax = 0;
            int max = 0;
            for(int i = 0; i < array.length; i++){
                max = (max > array[i])? max : (max = array[i]);
                indexOfMax = (max > array[i]) ? indexOfMax : (indexOfMax = i);
            }
            System.out.println("Индекс максимального элемента массива = "+indexOfMax);
        }
        if(showMinDigitIndex){
            int min = array[0];
            int indexOfMin = 0;
            for(int i = 0; i < array.length; i++){
                min = (min < array[i])? min : (min = array[i]);
                indexOfMin = (min < array[i]) ? indexOfMin : (indexOfMin = i);
            }
            System.out.println("Индекс минимального элемента массива = "+indexOfMin);
        }
        if(showHowMachMoreMaxThenMin){
            int min = array[0];
            for(int i = 0; i < array.length; i++){
                min = (min < array[i])? min : (min = array[i]);
            }
            int max = 0;
            for(int i = 0; i < array.length; i++){
                max = (max > array[i])? max : (max = array[i]);
            }
            int howMachMore = max-min;
            System.out.println("Максимальный элемент больше от минимального на "+howMachMore);
        }
        System.out.println("==============");
    }

    static void fillArray(int numberOfDigits, int primaryDigit, int finalDigit, int step, int array[], boolean isIncreasing){

        if(isIncreasing){
            if(finalDigit == 0) finalDigit = primaryDigit+numberOfDigits*step;
            if(numberOfDigits == 0) numberOfDigits = (finalDigit - primaryDigit) / step + 1;
            array[0] = primaryDigit;
            for(int i = 1; i < numberOfDigits; i++ ){
                array[i] = primaryDigit+step*i;
            }
        }
        else{
            if(finalDigit == 0) finalDigit = primaryDigit-numberOfDigits*step;
            if(numberOfDigits == 0) numberOfDigits = (primaryDigit - finalDigit) / step + 1;
            array[0] = primaryDigit;
            for(int i = 1; i < numberOfDigits; i++ ){
                array[i] = primaryDigit -step*i;
            }
        }
    }

    static void fillArrayWithProgression(int array[], int primaryDigit, int numberOfDigits){
        array[0] = primaryDigit;
        int x = primaryDigit;
        for(int i = 1; i<numberOfDigits; i++){
            x = 2*x-1;
            array[i] = x;
        }
        System.out.println("массив заполениный по прогрессии: "+Arrays.toString(array));
    }

    static void displayStringArrayContent(String x[]){
        System.out.print("Содержимое массива следующее: ");
        for(int i = 0; i<x.length; i++){
            System.out.print(x[i]);
            if(i<x.length-1) System.out.print(", ");
            else System.out.println(".");

        }
    }

    static void displayArrayMirror(int x[]){
        System.out.print("Отоюражение в обратном порядке: ");
        for(int i = x.length-1; i>=0; i--){
            System.out.print(x[i]);
            if(i>0) System.out.print(", ");
            else System.out.println(".");
        }
    }
}
