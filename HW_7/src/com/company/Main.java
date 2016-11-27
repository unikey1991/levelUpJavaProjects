package com.company;

import java.util.Scanner;

public class Main {

    final static String CARD_SUITE[] = new String[]{null,"пик","треф","бубен","червей"};
    final static String QUALITY_OF_CARD[] = new String[]{null,null,"двойка","тройка","черверка","пятерка","шестерка","семерка",
            "восьмерка", "девятка,","десятка","валет","дама","король","туз"};  //присвоил пустые значения просто чтоб индексы совпали с условиями в задаче, чтоб меньше путаться
    final static String DAYS_OF_WEEK[] = new String[]{"понедельник", "вторник","среда","четверг","пятница","суббота","воскресенье"};
    final static String DIGITS[] = new String[]{"one","two","three","four","five","six","seven","eight","nine","ten"};


    public static void main(String[] args) {


        hello(args);
        Book b1 = new Book("one",1990,"alex", BookType.DETEKTIV);
        Book b2 = new Book("two",1996,"andr",BookType.DRAMA);
        Book b3 = new Book("three",2000,"petr",BookType.KOMEDIA);
        Book b4 = new Book("four",2002,"serg",BookType.ROMAN);
        Book b5 = new Book("five",2006,"dmitr",BookType.SKAZKA);
        Book b6 = new Book("six",2014,"petr",BookType.NAU4NAYA_FANTASTIKA);



    }
    static void hello(String[] args){
        System.out.println("==============================================================================");
        System.out.println("Введите номер задания для инициализации либо введите 0 для остановки программы");

        switch (inputInt()){
            case 0: break;
            case 1: task1(args); break;
            case 2: task2(args); break;
            case 3: task3(args); break;
            case 4: output(args, task4()); break;
            case 5: output(args,task5()); break;
            case 6: output(args,task6()); break;
            case 7: task7(args); break;
            default:System.out.println("Неверный ввод, повторите");hello(args);break;
        }
    }

    static int inputInt(){
        Scanner x = new Scanner(System.in);
        int z = x.nextInt();
        return z;
    }

    static String inputString(){
        Scanner x = new Scanner(System.in);
        String z = x.nextLine();
        return z;
    }

    static int isLeapYear(String[] args){
        Months[] months = Months.values();
        int x = months[1].getDaysAmount();
        for (int i = 0; i < args.length; i++){
            if (args[i].equals("высокосный")) return x+1;
        }
        return x;
    }

    static void task1(String[] args){
        System.out.println("Введите номер месяца");
        int num = inputInt();
        if (num == 2) System.out.println(isLeapYear(args));
        else if (num == 1 || (num > 2 && num <= 12)) {
            Months[] months = Months.values();
            int x = months[num-1].getDaysAmount();
            System.out.println(x);
        }
        else System.out.println("неверный месяц");
        hello(args);
    }

    static void task2 (String args[]){
        int indexM, indexK;
        System.out.println("Введите порядковый номер масти карты от 1 до 4");
        indexM = inputInt();
        if (indexM > 4 || indexM < 1){
            System.out.println("неверный номер!");
            task2(args);
        }
        System.out.println("Введите порядковый номер достоинства карты от 6 до 14");
        indexK = inputInt();
        if (indexK > 14 || indexK < 6) {
            System.out.println("неверный номер!");
            task2(args);
        }
        System.out.println("Это "+QUALITY_OF_CARD[indexK]+" "+CARD_SUITE[indexM]);
        hello(args);
    }

    static void task3 (String args[]){
        int daysInYear = 365;
        int day;
        int startDay = -1;
        int target;
        String dayName;
        for (int i = 0; i < args.length; i++){
            if (args[i].equals("высокосный")) daysInYear += 1;
        }
        System.out.println("Введите номер дня в году от 1 до "+daysInYear);
        day = inputInt();
        if (day < 1 || day > daysInYear){
            System.out.println("wrong number");
            task3(args);
        }
        System.out.println("введите название дня недели (полность) или номер дня, с которого начался год (1го января)");
        dayName = inputString();
        for (int i = 0; i < DAYS_OF_WEEK.length; i++){
            if (DAYS_OF_WEEK[i].equals(dayName)) startDay = i+1;
        }
        if (startDay == -1){
            startDay = Character.getNumericValue(dayName.charAt(0));
            if (startDay < 1 || startDay > 7) {
                System.out.println("wrong day name");
                task3(args);
            }
        }
        target = (day%7 - 1 + startDay-1)%7;
        System.out.println(day+ " день в году - " +DAYS_OF_WEEK[target]+" ("+(target+1)+"й день недели)");
        hello(args);
    }

    static String task4(){
        int digit;
        System.out.println("Введите число от 1 до 10");
        digit = inputInt();
        return DIGITS[digit+1];
    }

    static void output(String[] args,String out){
        System.out.println(out);
        hello(args);
    }

    static String task5(){
        String in;
        System.out.println("Введите строку");
        in = inputString();
        char char1[] = new char[in.length()];
        for (int i = in.length()-1; i >= 0; i--){
            char1[in.length()-1-i] = in.charAt(i);
        }
        return new String(char1);
    }

    static String task6(){
        String email;
        int idPoint;
        int idCommercialAT;
        boolean test1, test2, test3;
        System.out.println("pls enter your @mail here");
        email = inputString();
        idCommercialAT = email.indexOf("@");
        idPoint = email.indexOf(".",idCommercialAT);
        test1 = idCommercialAT-1>4; //1)	emailaddr > 4 символов
        test2 = (idPoint-idCommercialAT-1) > 1 && (idPoint-idCommercialAT-1) <10; //2)	1 < domain < 10
        test3 = (email.length()-1-idPoint) >= 2 && (email.length()-1-idPoint) <5;  //3)	2 <= zone < 5
        if (!test1)return "email адрес до @ не может быть меньше 4 символов";
        if (!test2) return "домен не может быть меньше 2 и больше 9 символов";
        if (!test3) return "зона не может быть меньше 2 и больше 4 символов";
        return "email подходит";

    }

    static void task7(String[] args){
        String arr[];
        int test;
        int lengthOfString;
        System.out.println("pls enter here array length");
        arr = new String[inputInt()];
        System.out.println("введите какой минимальный размер строки долже быть");
        lengthOfString = inputInt();
        System.out.println("заполните массив строками вводя их по очереди");
        for (int i = 0; i < arr.length; i++){
            arr[i]=inputString();
        }
        if (arr[0].length() >= lengthOfString) System.out.print(arr[0] + ", ");
        for (int i = 1; i< arr.length; i++){
            test = 0;
            for (int j = 0; j < i; j++){
                if(arr[i].equals(arr[j])) test=1;
            }
            if (test == 0 && arr[i].length() >= lengthOfString ) System.out.print(arr[i] + ", ");
        }
        System.out.println();
        hello(args);
    }



}
