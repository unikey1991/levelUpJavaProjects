package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        for (int i = 10; i > 0; i--) {
            int sqrt = i * i;
            int cqrt = sqrt * i;
            System.out.println(sqrt + " " + cqrt);
        }

        int arr1[] = new int[8];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 15 + i;
        }

        System.out.println(Arrays.toString(arr1));
        dubleArrayValue(arr1);
        System.out.println(Arrays.toString(arr1));

    }

    static void dubleArrayValue(int x[]) {
        for (int i = 0; i < x.length; i++) {
            x[i] *= 2;
        }
    }
}
