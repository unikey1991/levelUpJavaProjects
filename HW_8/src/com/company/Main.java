package com.company;


public class Main {
    static final String [] NUM_FROM_10_TO_19 = new String []{"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    static final String [] NUM_FOR_TENS = new String[]{"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    static final String [] NUM_TO_STRING = new String []{"","one","two","three","four","five","six","seven","eight","nine"};


    public static void main(String[] args) {


        int arr1[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int arr3[] = new int[]{1, 1, 2, 2, 3, 4, 5, 6, 6, 7, 7, 8, 9, 9, 10, 10, 11, 12, 13, 13};
        int arr4[] = new int[]{45, 64, 64, 48, 6876, 446, 64, 48, 64, 48, 64, 486, 8, 4, 6, 4, 6, 8, 1, 6879, 3, 1, 4, 6, 4, 7, 6, 9, 6877, 3, 1, 6, 6, 7, 6, 1, 6, 9, 9, 4};
        double arr6[] = new double[]{-3.5, -2.5, -1.5, -0.5, 0.5, 1.5, 2.5, 3.5};
        int int7 = 959719299;
        int int8 = 12345678;
        int int9 = 19;
        int int10 = 100;


        output(task1(arr1));
        output(task2(arr1, 8));
        output(task3(arr3));
        output(task4(arr4));
        output(task5(arr1));
        output(task6(arr6));
        output(task7(int7));
        output(task8(int8));
        output(task9(int9));
        output(task10(int10));



    }

    static void output(String out) {
        System.out.println(out);
    }


    // 1.Найти среднее арифметическое элементов массива, больших числа 10. * Решить задачу при помощи циклов while и for-each
    static String task1 (int arr[]){
        double sredn = 0;
        for (int x:arr){
        sredn    += x;
        }
        return "Среднее = "+(sredn/arr.length);
    }

    // 2. Найти среднее арифметическое элементов массива, меньших некоторого числа m. * Решить задачу при помощи циклов while и for-each
    static String task2 (int arr[], int lowerThan){
        double sredn = 0;
        for (int x:arr){
            if (x < lowerThan) sredn += x;
        }
        return "Среднее меньше числа "+lowerThan+" = "+(sredn/arr.length);
    }

    // 3. В массиве из 20 элементов числа образуют неубывающую последовательность. Несколько элементов, идущих подряд, равны между собой.
    // Найти количество таких элементов. Сколько различных чисел имеется в массиве?
    static String task3 (int arr[]){
        int countEqual = 0;  // если верно понял, то подсчитал сколько всего цифр образуют такие пары в массиве
        int i = 0, j=arr.length-1;
        while (i < arr.length-1){
            if (arr[i] ==  arr[i+1]) countEqual++;
            i+=1;
        }
        return "Количество элементов, идущих подряд, равны между собои = "+countEqual*2+". Различных же чисел в массиве = "+(arr.length-countEqual);
    }

    // 4. В массиве хранится информация о максимальной скорости каждой из 40 марок легковых автомобилеи
    // ̆. Определить скорости двух самых быстрых автомобилей. * Задачу решить, не используя два прохода по массиву.
    static String task4 (int arr[]){
        int max1 = 0, max2 = 0;
        int i=0;
        while (i < arr.length){
            if (arr[i] >= max1){
                max2 = max1;
                if (arr[i]> max1) max1 = arr[i];
            }
            else if (max2 != max1 && max2 < arr[i]) max2 = arr[i];
            i++;
        }
        return "Машины с самой большой скоростью "+max1+" и "+max2;
    }

    // 5. Дана непустая последовательность целых чисел, оканчивающаяся нулем. Найти:
    //а) сумму всех чисел последовательности;
    //б) количество всех чисел последовательности.
    static String task5 (int arr[]){
        int sum = 0;
        for (int x : arr){
            sum += x;
        }
        return "Cумма всех чисел последовательности = "+sum+". Количество всех чисел "+arr.length;
    }


    // 6. Дана последовательность из n вещественных чисел, начинающаяся с отрицательного числа.
    // Определить, какое количество отрицательных чисел записано в начале последовательности. Условный оператор не использовать.
    static String task6 (double arr[]){
        int i = 0;
        int count = 0;
        while (i < arr.length && arr[i] < 0){
            count ++;
            i++;
        }
        return "Количество отрицательных чисел "+count;
    }


    // 7. Дано натуральное число. Определить, сколько раз в нем встречается максимальная цифра (например, для числа 132233 ответ равен 3, для числа 46 336 — 2, для числа 12 345 — 1).
    // * Задачу решить, не используя два прохода по массиву.
    static String task7 (int num){
        int count = 0;
        int max = 0;
        do {
            if (num%10 > max) {
                max = num%10;
                count = 1;
            }
            else if(num%10 == max) count++;
            num /= 10;
        }while (num > 0);
        return "Количество максимальных цифр в данном числе "+count;
    }


    // 8. Дано число. Написать программу, которая возвращает его зеркальное отражение в виде числа.
    static String task8 (int num){
        String mirorredNumString = "";
        int mirorredNum = 0;
        do {
            mirorredNumString += Integer.toString(num%10);
            num /= 10;
        }while (num > 0);
        mirorredNum = Integer.parseInt(mirorredNumString);
        return "Pеркальное отражение в виде числа "+mirorredNum;
    }


    // 9. Дано двузначное число. Необходимо написать программу, которая вернет строковое представление данного числа.
    // Например, дано число 34, его строковое представление - thirty four.
    static String task9 (int num){
        if (num < 20 && num > 9) return "Число "+num+" = "+NUM_FROM_10_TO_19[num%10];
        else if (num >19 && num <100) return "Число "+num+" = "+NUM_FOR_TENS[num/10-2]+NUM_TO_STRING[num%10];
        else return "Число не 2х значное";
    }

    // 10. Написать программу определения оценки студента по его рейтингу, на основе следующих правил:
    static String task10 (int num){
        if (num >= 0 && num <20) return "Mark F";
        else if (num >= 20 && num < 40) return "Mark E";
        else if (num >=40 && num < 60) return "Mark D";
        else if (num >= 60 && num < 74) return "Mark C";
        else if (num >= 75 && num < 89) return "Mark B";
        else if (num >= 91 && num <= 100) return "Mark A";
        else return "неверная оценка";
    }





}
