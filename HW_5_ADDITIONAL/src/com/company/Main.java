package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //1) Дан массив. Поменять местами:
        int arr1[] = new int [] {1,3,7,5,20,9,2,4,20};
        replaceArrayElemetns(arr1,2,5);     //   а) второй и пятый элементы;
        replaceArrayElemetns(arr1,3,2);       //  б) m-й и n-й элементы;
        replaceArrayElemetns(arr1,3,firstOfMaximumElement(arr1));        //в)  третий и максимальный элементы.
        // Если элементов с максимальным значением несколько, то в обмене должен участвовать первый из них;
        replaceArrayElemetns(arr1,1,lastOfMinimumElement(arr1));        //г)  первый и минимальный элементы.
        // Если элементов с минимальным значением несколько, то в обмене должен участвовать последний из них.

        //2) Дан массив из четного числа элементов. Поменять местами
        int arr2[] = new int[]{6,1,7,61,-5,4,2,14,21,46};
        replaceArrayHalfs(arr2);       //а) его половины;
        replaceNearbyElement(arr2);        //б) первый элемент со вторым, третий — с четве ртым и т. д.;
        replaceArrayHalfsMirrored(arr2);      //в)его половины следующим способом:   первый элемент поменять с последним, второй — с предпоследним и т. д

        //3)  Дан одномерный массив из  20  элементов.  Переставить первые три и последние три элемента, сохрани впорядок их следования.
        int arr3[] = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        replaceArrayFirstAndLastThreeElements(arr3);

    }

    static  void replaceArrayFirstAndLastThreeElements(int array[]){
        int x[] = Arrays.copyOf(array,array.length);
        System.out.println("До перестановки первых трех и последних трех элементов, сохранив впорядок их следования "+Arrays.toString(array));
        for (int i=0; i<3; i++){
            array[i]=array[array.length-3+i];
            array[array.length-3+i]=x[i];
        }
        System.out.println("После                                                                                   "+Arrays.toString(array));
        System.out.println("=====================================================");
    }

    static void replaceArrayHalfsMirrored(int array[]){
        int x[] = Arrays.copyOf(array,array.length);
        System.out.println("До перестановки половин зеркально (первая с последней, вторая с предпоследней и т.д. "+Arrays.toString(array));
        for(int i=0; i < array.length/2; i++){
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=x[i];
        }
        System.out.println("После                                                                                "+Arrays.toString(array));
        System.out.println("=====================================================");
    }

    static void replaceNearbyElement(int array[]){
        int x[] = Arrays.copyOf(array,array.length);
        System.out.println("До перестановки пар элементов массива "+Arrays.toString(array));
        for(int i=0; i < array.length; i+=2 ){
            array[i]=array[i+1];
            array[i+1]=x[i];
        }
        System.out.println("После                                 "+Arrays.toString(array));
        System.out.println("=====================================================");
    }

    static void replaceArrayHalfs(int array[]){
        System.out.println("До перестановки половин массива "+Arrays.toString(array));
        int x[] = Arrays.copyOf(array,array.length);
        for(int i=0; i < array.length/2; i++){
            array[i]=array[array.length/2+i];
            array[array.length/2+i]=x[i];
        }
        System.out.println("После                           "+Arrays.toString(array));
        System.out.println("=====================================================");
    }

    static  void replaceArrayElemetns(int array[], int indexOfFirstElement, int indexOfSecondElement){
        System.out.println("Перестановка эелементов массива с индексом "+indexOfFirstElement+" и "+indexOfSecondElement);
        System.out.println(" До перестановки массив содержал следующие элементы: "+Arrays.toString(array));
        int first = array[indexOfFirstElement];
        int second = array[indexOfSecondElement];
        array[indexOfSecondElement]=first;
        array[indexOfFirstElement]=second;
        System.out.println("После перестановки элементов теперь он выглядит так: "+Arrays.toString(array));
        System.out.println("=====================================================");
    }

    static int firstOfMaximumElement(int array[]){
        int indexOfMax = 0;
        int max = 0;
        for(int i = 0; i < array.length; i++){
            if(max<array[i]){
                max = array[i];
                indexOfMax = i;
            }
        }
        return indexOfMax;
    }

    static int lastOfMinimumElement(int array[]){
        int min = array[array.length-1];
        int indexOfMin = array.length-1;
        for(int i = array.length-1; i >= 0; i--){
            if(min>array[i]){
                min = array[i];
                indexOfMin = i;
            }
        }
        return indexOfMin;
    }

}
