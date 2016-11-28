package com.company;

import java.util.Scanner;

public class Main {

    static final String MONTHS[] = new String[] {"январь","февраль","март","апрель","май","июнь","июль","август",
            "сентябрь","октябрь","ноябрь","декабрь"};
    static final double KG_IN_ONE_FUNT = 0.453;



    public static void main(String[] args) {

        hello();

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
    static double inputDouble(){
        Scanner x = new Scanner(System.in);
        double z = x.nextDouble();
        return z;
    }
    static void output(String out){
        System.out.println(out);
        hello();
    }

    static void hello(){
        System.out.println("==============================================================================");
        System.out.println("Введите номер задания для инициализации либо введите 0 для остановки программы");

        switch (inputInt()){
            case 0: break;
            case 1: task1(); break;
            case 2: task2(); break;
            case 3: task3(); break;
            case 4: task4(); break;
            case 5: task5(); break;
            case 6: task6(); break;
            case 7: task7(); break;
            case 8: task8(); break;
            case 9: task9(); break;
            case 10: task10(); break;
            case 11: task11(); break;
            case 12: task12(); break;
            default:System.out.println("Неверный ввод, повторите");hello();break;
        }
    }

    static void task1(){
        System.out.println("Дано слово. Добавить к нему в начале и конце столько звездочек, сколько букв в этом слове");
        System.out.println("введите слово");
        String str = inputString();
        String b1 = "*";
        for(int i = 1; i < str.length(); i++){
            b1 += "*";
        }
        str = b1+str+b1;
        System.out.println("Результат : "+str);
        hello();
    }

    static void task2(){
        System.out.println("Дано название футбольного клуба. Напечатать его на экране столбиком");
        System.out.println("введите название");
        String str = inputString();
        System.out.println("Результат : ");
        for (int i = 0; i < str.length(); i++){
            System.out.println(str.charAt(i));
        }
        hello();
    }

    static void task3(){
        System.out.println("Найти сумму положительных нечетных чисел, меньших 50");
        System.out.println("Введите сколько чисел желаете ввести");
        int numberOf = inputInt();
        int arr[] = new int[numberOf];
        int sum = 0;
        System.out.println("ОК. Введите теперь по очереди эти "+numberOf+ "чисел(а)");
        for (int i = 0; i < numberOf; i++){
            int x = inputInt();
            if(x>=0 && x<50 && x%2!=0)sum+=x;
        }
        System.out.println("Сумма положительных нечетных чисел, меньших 50 = " +sum);
        hello();
    }

    static void task4(){
        int monthLeftToYear = 0;
        System.out.println("== Калькулятор вложения в банке ==");
        System.out.println("Введите начальную сумму");
        double sum = inputInt();
        double sumToLeftOfYear = sum;
        System.out.println("Введите размер % на который увеличивается сумма каждый месяц");
        double perc = inputDouble()/100;
        System.out.println("Введите по очереди день и месяц (словами) вложения");
        int day = inputInt();
        String month1 = inputString();
        System.out.println("Введите по очереди количество лет и месяцев для определения итоговой суммы");
        int totalMonth = inputInt()*12+inputInt();

        for (int i = 0; i < 12; i++){   //////////////  определение сколько осталось месяцев до конца года
            if (month1.equals(MONTHS[i]))monthLeftToYear = 12-i-1;
        }

        for (int i = 0; i < totalMonth; i++){ ////определение суммы через X лет и Y месяцев под ставку Z в месяц
            sum += sum * perc;
        }

        for (int i = 0; i<monthLeftToYear; i++){ ////////////// определение суммы что будет до конца года
            sumToLeftOfYear += sumToLeftOfYear * perc;
        }

        System.out.println("ОК. Дата вложения "+day+" "+month1);
        System.out.println("Через "+totalMonth/12+" лет(года) и "+month1+ " месяца(-ев) сумма уже будет "+sum);
        System.out.println("C месяца открытия ("+month1+") и до конца года сумма будет "+sumToLeftOfYear);
        hello();
    }

    static void task5(){
        int konvA, konvB;
        int otkrA, otkrB;
        System.out.println("== Войдет ли открытка в конверт ==");
        System.out.println("Введите по очереди длину и ширину конверта в мм");
        konvA = inputInt();
        konvB = inputInt();
        System.out.println("Введите по очереди длину и ширину открытки в мм");
        otkrA = inputInt();
        otkrB = inputInt();
        if ((konvA+2 > otkrA && konvB+2 > otkrB) || (konvA+2 > otkrB && konvB+2 > otkrA)) System.out.println("Открытка войдет");
        else System.out.println("Открытка не войдет");
        hello();
    }

    static String task6(){
        double x, y;
        System.out.println("== Определить наибольшее вещественное число из двух ==");
        System.out.println("Введите по очереди 2 вещественных числа");
        x = inputDouble();
        y = inputDouble();
        if (x > y) return "первое "+x+" больше второго "+y;
        return "второе "+y+" больше первого "+x;
    }

    static void task7(){
        int a, b;
        System.out.println("== Выполняется ли условие: ==");
        System.out.println("a) только одно из чисел А и В четное");
        System.out.println("б) хотя бы одно из чисел А и В положительно");
        System.out.println("???????");
        System.out.println("== Введите 2 числа по очереди==");
        a = inputInt();
        b = inputInt();
        if (a%2==0 ^ b%2==0) System.out.println("только одно из чисел А и В четное ВЫПОЛНЯЕТСЯ");
        else System.out.println("только одно из чисел А и В четное НЕ ВЫПОЛНЯЕТСЯ");
        if (a>0 || b>0) System.out.println("хотя бы одно из чисел А и В положительно ВЫПОЛНЯЕТСЯ");
        else System.out.println("хотя бы одно из чисел А и В положительно НЕ ВЫПОЛНЯЕТСЯ");
        hello();
    }

    static void task8() {
        System.out.println("== Таблица соответствия между весом в фунтах и весом в килограммах: ==");
        System.out.println("FT |  KG  ");
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.print(i);
                System.out.print("  |  ");
                System.out.print(i*KG_IN_ONE_FUNT);
            }
            System.out.println();
        }
        hello();
    }

    static void task9() {
        System.out.println("== Таблица перевода долл в грн: ==");
        System.out.println("Введите стоимость одного доллара");
        double kurs = inputDouble();
        System.out.println("USD |  UAH  ");
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < 1; j++) {
                System.out.print(i);
                System.out.print("  |  ");
                System.out.print(i*kurs);
            }
            System.out.println();
        }
        hello();
    }

    static void task10(){
        int numOfDivision = 1;
        int numOfCore = 1;
        System.out.println("== Сколько клеток у амебы будет через N часов: ==");
        System.out.println("Введите количество часов");
        numOfDivision = inputInt() / 3;
        for(int i = 0; i < numOfDivision; i++){
            numOfCore *= 2;
        }
        System.out.println("Количество клеток через указаное количество часов будет " +numOfCore);
        hello();
    }

    static void task11(){
        int sum = 0;
        int numOflowMark = 0;
        String childLowMark = "";
        System.out.println("== количество учеников, оценка которых меньше средней оценки по классу ==");
        System.out.println("Введите количество учеников");
        double arr[] = new double[inputInt()];
        System.out.println("Введите по очереди оценки учеников");
        for (int i = 0; i < arr.length; i++){  //заполнение массива значениями с консоли
            int mark = inputInt();
            arr[i] = mark;
            sum += mark;
        }
        for (int i = 0; i < arr.length; i++){  // поиск учеников с оценкой ниже средней и их номера
            if (arr[i] < sum / arr.length){
                childLowMark += " #"+(i+1);
                numOflowMark += 1;
            }
        }
        System.out.println("Количество учеников с оценкой ниже средней - "+numOflowMark);
        System.out.println("Их номера: " +childLowMark);
        hello();
    }

    static void task12(){
        System.out.println("== количество четных элементов и количество элементов, оканчивающихся на цифру 5 в массиве ==");
        System.out.println("Введите количество цифр для записи");
        int arr[]= new int[inputInt()];
        int sumChetn = 0;
        int sumPastFive = 0;
        System.out.println("Введите цифры по очереди");
        for (int i = 0; i<arr.length; i++){  //заполение массива
            arr[i]=inputInt();
        }
        for (int i = 0; i<arr.length; i++) {  // поиск по массиву четных элементов и заканчивающихся на 5
            if (arr[i]%2 == 0 )sumChetn += 1;
            if (arr[i]%10 == 5)sumPastFive += 1;
        }
        System.out.println("Количество четных эелементов - "+sumChetn);
        System.out.println("Количество элементов оканчивающихся на цифру 5 - "+sumPastFive);
        hello();

    }


}
