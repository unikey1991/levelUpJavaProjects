package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter sum pls");
        int in = scanner.nextInt();
        int minNalog = in;
        int minChast = in;

        for (int i = in; i>1; i--){
            if (in-in/i*i > 1 && maxDelitel(i)*in/i + maxDelitel(in-in/i*i) < minNalog) {
                minChast = i;
                minNalog = maxDelitel(i)*(in/i) + maxDelitel(in-in/i*i);
            }
        }


        System.out.println("часть для минимального налога: "+(in/minChast)+" по " + minChast+ " и остаток "+(in- in/minChast*minChast));
        System.out.println("налог всего выйдет: " + minNalog);
        //System.out.println(maxDelitel(6));

    }

    public static int maxDelitel (int num){
        if (num < 2) return num;
        int i = num-1;
        while (num%i != 0){
            if (--i == 0) return num;
        }
        return i;
    }
}
