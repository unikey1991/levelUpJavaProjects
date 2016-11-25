package com.company;

/**
 * Created by java on 25.11.2016.
 */
public enum DayOfWeek {

    Monday(1, "Monday", "Понедельник", "Пн"),
    Tuesday(2, "s", "as", "asf");

    int dayOfWeek;
    String enName;
    String ruName;
    String ruShortName;

    DayOfWeek(int dayOfWeek, String enName, String ruName, String ruShortName) {
        this.dayOfWeek = dayOfWeek;
        this.enName = enName;
        this.ruName = ruName;
        this.ruShortName = ruShortName;
    }

    public int getDayOfWeek() {
        return dayOfWeek;
    }

    public String getEnName() {
        return enName;
    }

    public String getRuName() {
        return ruName;
    }

    public String getRuShortName() {
        return ruShortName;
    }
}


