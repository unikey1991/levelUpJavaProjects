package com.company;

/**
 * Created by unike on 26.11.2016.
 */
public enum Months {

    /*Опишите с помощью enum тип данных для хранения месяцев.
    У каждого месяца должны быть следующие свойства: номер месяца,
    название на английском, название на русском, количество дней. Написать конструктор со всеми параметрами,
    а также геттеры.
*/

    January(1, 31, "January", "Январь"),
    February(2, 28, "February", "Февраль"),
    March(3, 31, "March", "Март"),
    April(4, 30, "April", "Апрель"),
    May(5, 31, "May", "Май"),
    June(6, 30, "June", "Июнь"),
    July(7, 31, "July", "Июль"),
    August(8, 31, "August", "Август"),
    September(9, 30, "September", "Сентябрь"),
    October(10, 31, "October", "Октябрь"),
    November(11, 30, "November", "Ноябрь"),
    December(12, 31, "December", "Декабрь");

    int monthOfYear;
    int daysAmount;
    String enName;
    String ruName;


    Months(int monthOfYear, int daysAmount, String enName, String ruName) {
        this.monthOfYear = monthOfYear;
        this.daysAmount = daysAmount;
        this.enName = enName;
        this.ruName = ruName;
    }

    public int getMonthOfYear() {
        return monthOfYear;
    }

    public int getDaysAmount() {
        return daysAmount;
    }

    public String getEnName() {
        return enName;
    }

    public String getRuName() {
        return ruName;
    }


}




