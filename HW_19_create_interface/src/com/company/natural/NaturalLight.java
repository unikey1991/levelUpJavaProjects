package com.company.natural;

import com.company.SourceOfLight;

/**
 * Created by unike on 19.01.2017.
 */
public abstract class NaturalLight implements SourceOfLight {

    boolean isDay;
    String sourceName;
    int bright;

    public NaturalLight(boolean isDay, String sourceName, int bright) {
        this.isDay = isDay;
        this.sourceName = sourceName;
        this.bright = bright;
    }


    @Override
    public void turnOff() {
        this.isDay = false;
        System.out.println("Настала ночь");
        this.bright = 0;
    }

    @Override
    public void turnOn() {
        this.isDay = true;
        System.out.println("Настал день");
        this.bright = 100;
    }

    @Override
    public void setBright(int bright) {
        if (bright>=1 && bright <=100){
            if (isDay) {
                this.bright = bright;
                System.out.println("Установлена яркость в " + bright + "%");
            }
            else System.out.println("Источник света недоступен/погашен");
        }
        else System.out.println("Процент яркости нужно задать значениме от 1 до 100");

    }
}
