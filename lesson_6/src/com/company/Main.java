package com.company;


public class Main {
    static int a = 235825;

    public static void main(String[] args) {
        isEven(a);
        isDayOfCoder(13, 9);
        doSomething(3);
        whatIsBiggest(33);
        whatIsBiggestOfTwo(120.3,120.33);

    }

    static void isEven(int a){
        if(a%2==0) System.out.println("четное");
        else System.out.println("не четное");
    }

    static void isDayOfCoder (int day, int monthNumber){
        if(monthNumber == 9 && day == 14) System.out.println("Ураа! Бухать!");
        else if(monthNumber  == 9 && day == 13) System.out.println("Завтра бухать!");
        else System.out.println("Работать!");
    }

    static void doSomething (int score){
        if(score==0) System.out.println("проигрыш");
        else if(score == 1) System.out.println("ничья");
        else if(score == 3) System.out.println("выигрыш");
    }

    static void whatIsBiggest(int a){
        int i = a%10;
        int j = a/10;
        if(i<j) System.out.println("первая цифра больше второй");
        else if (j<i) System.out.println("первая цифра меньше второй");
        else System.out.println("первая цифра равна второй");
    }

    static void whatIsBiggestOfTwo(double a, double b){
        if(a>b) System.out.println(a+" > "+b);
        else if (b > a) System.out.println(b+" > "+a);
        else System.out.println(a +" = "+b);
    }

}
