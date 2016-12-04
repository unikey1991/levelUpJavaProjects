package com.company;

import java.util.IdentityHashMap;

/**
 * Created by java on 02.12.2016.
 */
public class Calc {

    public static int sum(int a, int b){
        return a+b;
    }

    public static double sum(double a, double b){
        return a+b;
    }

    public static int sum(String a, String b){
        return Integer.parseInt(a)+Integer.parseInt(b);
    }
///////////////////
    public static int delenie(int a, int b){
        return a/b;
    }

    public static double delenie(double a, double b){
        return a/b;
    }

    public static int delenie(String a, String b){
        return Integer.parseInt(a)/Integer.parseInt(b);
    }
/////////////////////
    public static int umnoj(int a, int b){
        return a*b;
    }

    public static double umnoj(double a, double b){
        return a*b;
    }

    public static int umnoj(String a, String b){
        return Integer.parseInt(a)*Integer.parseInt(b);
    }
//////////////////////

    public static int vichetanie(int a, int b){
        return a-b;
    }

    public static double vichetanie(double a, double b){
        return a-b;
    }

    public static int vichetanie(String a, String b){
        return Integer.parseInt(a)-Integer.parseInt(b);
    }




}
