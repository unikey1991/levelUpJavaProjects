package com.company;

import java.util.Arrays;

public class Main {

    static final String[] NUM_FROM_10_TO_19 = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    static final String[] NUM_FOR_TENS = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    static final String[] NUM_FOR_ONES = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};


    public static void main(String[] args) {

        int totalTime = 500; // Время путешествия (сек)
        int restTime = 45; // Время, которое необходимо лошади на отдых (сек)
        int speed = 14; // Максимальна яскорость лошади (м/с)
        int runTime = 60; // Время, которое лошадь может бежать на максимальной скорости (сек)
        System.out.println(horseCalc(totalTime, runTime, restTime, speed));


        System.out.println(stringInvertor("ПревЕд мЕдвЕд, Каг ДИла"));

        System.out.println(stringSort("отсортируй меня детка"));

        int firstCarSpeed = 40; // Скоростьпервогоавтомобиля км\ч
        int secondCarSpeed = 60; // второго км\ч
        int distanceBetweenCars = 10; // расстояниемеждуними  s  км
        int time = 2;  // прошедшее время  t  ч
        System.out.println("Расстояние между машинами движущимеся в разные стороны через " + time + " часов будет " +
                carDistanceCalc(firstCarSpeed, secondCarSpeed, distanceBetweenCars, time) + " км");

        int intArr[] = new int[]{12, 45, 4, 64, 864, 4, 6, -5};
        bubbleSort(intArr);

        System.out.println(999 / 1000);

        System.out.println(intNumToStringNum(0));


    }

    /*
    6) Данотрехзначноечисло  (0-999).  Необходимонаписатьпрограмму,  котораявернетстроковоепредставлениеданногочисла.
    Например,  даночисло  738,  егостроковоепредставление - seven hundred thirty eight.
     */
    public static String intNumToStringNum(int inputNum) {
        if (inputNum == 0) return "zero";
        else if (inputNum / 10 == 0) {
            return NUM_FOR_ONES[inputNum];
        } else if (inputNum / 100 == 0) {
            if (inputNum >= 10 && inputNum < 20) return NUM_FROM_10_TO_19[inputNum - 10];
            else return NUM_FOR_TENS[inputNum / 10] + " " + NUM_FOR_ONES[inputNum % 10];
        } else if (inputNum / 1000 == 0) {
            if (inputNum % 100 >= 10 && inputNum % 100 < 20)
                return NUM_FOR_ONES[inputNum / 100] + " hundred " + NUM_FROM_10_TO_19[inputNum % 100 - 10];
            else
                return NUM_FOR_ONES[inputNum / 100] + " hundred " + NUM_FOR_TENS[inputNum % 100 / 10] + " " + NUM_FOR_ONES[inputNum % 10];
        } else return "Число должно быть от 0 до 999";

    }


    // 5) Отсортироватьмассивпузырьком (Bubble).
    public static void bubbleSort(int arr[]) {
        int i = 1, test = 2, buffer = 0;
        while (test > 0) {
            if (arr[i - 1] > arr[i]) {
                buffer = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = buffer;
                test = 2;
            }
            i++;
            if (i == arr.length) {
                i = 1;
                test--;
            }
        }
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }


    public static int carDistanceCalc(int firstCarSpeed, int secondCarSpeed, int distanceBetweenCars, int time) {
        return distanceBetweenCars + firstCarSpeed * time + secondCarSpeed * time;
    }

    /*
    3) Данастрока. Написатьпрограмму, котораясортируетвсесимволывстрокевпорядкевозрастания.
    Например: "hello world" => " dehllloorw».
     */
    public static String stringSort(String inputString) {
        char strToChar[] = inputString.toCharArray();
        Arrays.sort(strToChar);
        return "Сортировка символов строки проведена : " + inputString + " => " + (new String(strToChar));
    }


    /*
    2)  Данастрока.  Написатьпрограмму,  котораяпреобразовываетсимволыизнижнегорегистравверхнийинаоборот.
    Например:  ТЕкстнАпиСАннЫйСрАзныМРегиСТроМ => теКСТНаПИсаННыЙсРаЗНЫмрЕГИстРОм.
     */
    public static String stringInvertor(String inputString) {
        char strToChar[] = inputString.toCharArray();
        for (int i = 0; i < strToChar.length; i++) {
            if (Character.isLowerCase(strToChar[i])) strToChar[i] = Character.toUpperCase(strToChar[i]);
            else strToChar[i] = Character.toLowerCase(strToChar[i]);
        }
        return "Замена регистра строки проведена : " + inputString + " => " + (new String(strToChar));
    }

    /*
    1) Известно,  чтолошадипутешествуютвуникальноймодели  -  онискачут(намаксимальнойскорости)
    илиотдыхают(стоянаместе).  Вотпримертого,  какоднаконкретнаялошадьможетпутешествовать:
    Лошадь Blaze можетскакатьсоскоростью 14 м/свтечение 60 секунд, нозатемдолжнаотдохнутьвтечение
    45  секунд.  Через  500  секунд  Blaze  преодолеетрасстояниев 4200 метров.
    Написатьпрограммудлявычислениярасстояния,  котороепройдетлошадьзаопределенныйпромежутоквремени,
    приследующихвходныхпараметрах: totalTime - Времяпутешествия (сек) runTime - Время, котороелошадьможетбежатьнамаксимальнойскорости
    (сек) restTime - Время, котороенеобходимолошадинаотдых (сек) speed - Максимальнаяскоростьлошади (м/с
     */

    public static String horseCalc(int totalTime, int runTime, int restTime, int speed) { //считаем сколько раз нацело влезет в общее время время скачки+время перерыва
        int distance = (totalTime / (restTime + runTime)) * runTime; //считаем сколько раз нацело влезет в общее время время скачки+время перерыва и вычисляем остаток
        if (distance > runTime) distance += runTime;
        else distance = runTime - distance;
        return "Данный конь пройдет " + speed * distance + " метров за " + totalTime + " сек";
    }


}
