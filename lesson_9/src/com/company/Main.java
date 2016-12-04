package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        calc();






    }

    static void exit(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would like to continue? Enter y/n: ");
        String exitWord = scanner.nextLine();
        switch (exitWord){
            case "y":calc();break;
            case "n":break;
            default:exit();break;
        }
    }

    static void calc(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter operator: ");
        String operator = scanner.nextLine();

        System.out.print("Enter first operand: ");
        double a = scanner.nextDouble();

        System.out.print("Enter second operand: ");
        double b = scanner.nextDouble();
        System.out.println();

        switch (operator){
            case "+":System.out.println((a + operator + b)+" = "+Calc.sum(a,b));break;
            case "-":System.out.println((a + operator + b)+" = "+Calc.vichetanie(a,b));break;
            case "*":System.out.println((a + operator + b)+" = "+Calc.umnoj(a,b));break;
            case "/":System.out.println((a + operator + b)+" = "+Calc.delenie(a,b));break;
            default:System.out.println("Invalid operator");;break;
        }
        exit();
    }

}
