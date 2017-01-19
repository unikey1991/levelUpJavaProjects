package com.company.atrificial;

import com.company.SourceOfLight;

/**
 * Created by unike on 19.01.2017.
 */
public abstract class ArtificialLight implements SourceOfLight {


    boolean isON;
    String sourceName;
    String action;
    int bright;

    public ArtificialLight(boolean isON, String sourceName, String action, int bright) {
        this.isON = isON;
        this.sourceName = sourceName;
        this.action = action;
        this.bright = bright;
    }

    @Override
    public void turnOff() {
        this.isON = false;
        this.bright = 0;
        System.out.println("Свет выключен");
    }

    @Override
    public void turnOn() {
        this.isON = true;
        this.bright = 100;
        System.out.println("Свет включен");
    }

    @Override
    public void setBright(int bright) {
        if (bright>=1 && bright <=100){
            if (isON) {
                this.bright = bright;
                System.out.println("Установлена яркость в " + bright + "%");
            }
            else System.out.println("Источник света отключен");
        }
        else System.out.println("Процент яркости нужно задать значениме от 1 до 100");

    }
}
