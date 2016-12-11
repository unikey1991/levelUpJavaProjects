package com.company;

import java.util.Scanner;

public class Main {

    static String args1[];

    final static String CARD_SUITE[] = new String[]{null, "пик", "треф", "бубен", "червей"};
    final static String QUALITY_OF_CARD[] = new String[]{null, null, "двойка", "тройка", "черверка", "пятерка", "шестерка", "семерка",
            "восьмерка", "девятка,", "десятка", "валет", "дама", "король", "туз"};  //присвоил пустые значения просто чтоб индексы совпали с условиями в задаче, чтоб меньше путаться
    final static String DAYS_OF_WEEK[] = new String[]{"понедельник", "вторник", "среда", "четверг", "пятница", "суббота", "воскресенье"};
    final static String DIGITS[] = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
    final static int DAYS_IN_THE_YEAR = 365;


    public static void main(String[] args) {

        args1 = args;


        Book b1 = new Book("one", 1990, "alex", BookType.DETEKTIV);
        Book b2 = new Book("two", 1996, "andr", BookType.DRAMA);
        Book b3 = new Book("three", 2000, "petr", BookType.KOMEDIA);
        Book b4 = new Book("four", 2002, "serg", BookType.ROMAN);
        Book b5 = new Book("five", 2006, "dmitr", BookType.SKAZKA);
        Book b6 = new Book("six", 2014, "petr", BookType.NAU4NAYA_FANTASTIKA);

        String arr[] = new String[]{"preved","medved","kaG","dela","m?"};

        System.out.println(task1(args, 7));

        task2(2,12);

        task3(20, "вторник");

        System.out.println(task4(7));

        System.out.println(task5("say hello"));

        System.out.println(task6("aleksej.mikhalchuk@gmail.com"));

        task7(arr, 2);



    }

    static int inputInt() {
        Scanner x = new Scanner(System.in);
        int z = x.nextInt();
        return z;
    }

    static String inputString() {
        Scanner x = new Scanner(System.in);
        String z = x.nextLine();
        return z;
    }

    static int isLeapYear(String[] args) {
        Months[] months = Months.values();
        int x = months[1].getDaysAmount();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("высокосный")) return x + 1;
        }
        return x;
    }


    /*1. Составить программу, которая в зависимости от порядкового номера месяца (1, 2, ..., 12) выводит на экран количество дней в этом месяце. Рассмотреть два случая:
    1) год не является високосным;
    2) год может быть високосным (информация об этом вводится в аргументы при запуске программы).*/

    static int task1(String[] args, int monthNumber) {  //программа учитывает сразу высокосный ли (можно в аргументах программы ввести "высокосный")
        if (monthNumber == 2) return isLeapYear(args);
        else if (monthNumber == 1 || (monthNumber > 2 && monthNumber <= 12)) {
            Months[] months = Months.values();
            return months[monthNumber - 1].getDaysAmount();
        }
        else return 0;
    }


    /* Мастям игральных карт условно присвоены следующие порядковые номера:
    масти "пики" — 1, масти "трефы" — 2, масти "бубны" — 3, масти "червы" — 4, а достоинству карт:
     "валету" — 11, "даме" — 12, "королю" — 13, "тузу" — 14 (порядковые номера карт остальных достоинств соответствуют их
     названиям: "шестерка", "девятка" и т. п.). По заданным номеру масти m (1 <= m <=  4) и номеру достоинства карты k (6 <= k <= 14)
     определить полное название (масть и достоинство) соответствующей карты в виде "Дама пик", "Шестерка бубен" и т. п.*/

    static String task2(int numOfCard, int numOfQuality) {
        if (numOfCard > 4 || numOfCard < 1) {
            return "неверный номер!";
        }
        if (numOfQuality > 14 || numOfQuality < 6) {
            return "неверный номер!";
        }
        return QUALITY_OF_CARD[numOfQuality] + " " + CARD_SUITE[numOfCard];
    }


    /*Дано целое число k (1 <= k <= 365). Определить, каким днем недели (понедельником, вторником, ..., субботой или воскресеньем) является k-й день невисокосного года, в котором 1 января:
а) понедельник;
б) i-й день недели (если 1 января — понедельник, то d=1 , если вторник — d=2, ..., если воскресенье —  d= 7).*/

    static String task3(int enterDay, String dayName) {
        int startDay = -1;
        int target;
        if (enterDay < 1 || enterDay > DAYS_IN_THE_YEAR) return "wrong number";
        for (int i = 0; i < DAYS_OF_WEEK.length; i++) {
            if (DAYS_OF_WEEK[i].equals(dayName)) {
                startDay = i + 1;
                break;
            }
            if (i == DAYS_OF_WEEK.length-1 && !DAYS_OF_WEEK[i].equals(dayName)) return "wrong start day name";
        }
        target = (enterDay % 7 - 1 + startDay - 1) % 7;
        return DAYS_OF_WEEK[target];
    }


    /*Напишите программу для перевода чисел от 1 до 10 в строковое значение. Например, для числа 1 результатом будет строка “one”.*/
    static String task4(int digit) {
        if (digit > 0 && digit <= 10) return DIGITS[digit-1];
        else return "Число должно быть от 1 до 10";
    }


    /*Дана строка. Написать программу, которая возвращает строку, написанную в обратном порядке.*/
    static String task5(String in) {
        char char1[] = new char[in.length()];
        for (int i = in.length() - 1; i >= 0; i--) {
            char1[in.length() - 1 - i] = in.charAt(i);
        }
        return new String(char1);
    }

    /* Дан email в виде строки. Написать программу для проверки email на валидность. email должен соответствовать условию (пример - emailaddr@domain.zone)
1)	emailaddr > 4 символов
2)	1 < domain < 10
3)	2 <= zone < 5
*/
    static String task6(String email) {
        int idPoint;
        int idCommercialAT;
        idCommercialAT = email.indexOf("@");
        idPoint = email.indexOf(".", idCommercialAT);
        if (idCommercialAT < 4) return "email адрес до @ не может быть меньше 4 символов";
        if ((idPoint - idCommercialAT - 1) < 2 || (idPoint - idCommercialAT - 1) > 9) return "домен не может быть меньше 2 и больше 9 символов";
        if ((email.length() - 1 - idPoint) < 2 || (email.length() - 1 - idPoint) > 4) return "зона не может быть меньше 2 и больше 4 символов";
        return "email адрес "+email+" подходит";
    }


    /*. Дан массив строк. Написать программу, которая:
а) выводит на экран значение всех строк через запятую, длина которых больше n.
б) выводит на экран значение всех неповторяющихся строк через запятую.
*/
    static String task7(String arr[], int minLengthOfString) {
        int test;
        String out = "";
        if (minLengthOfString < 1) return "min length may be > 0";
        if (arr[0].length() >= minLengthOfString) out += arr[0] + ", ";  //сделал универсальный метод сочетающий оба условия
        for (int i = 1; i < arr.length; i++) {
            test = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i].equals(arr[j])) test = 1;
            }
            if (test == 0 && arr[i].length() >= minLengthOfString && !out.equals("")) out += ", " + arr[i];
            else if (test == 0 && arr[i].length() >= minLengthOfString && out.equals("")) out += arr[i];
        }
        out += ".";
        return out;
    }



}
