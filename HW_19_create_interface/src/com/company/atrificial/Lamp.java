package com.company.atrificial;

/**
 * Created by unike on 19.01.2017.
 */
public class Lamp extends ArtificialLight {

    int lumen;

    public Lamp(boolean isON, String sourceName, String action, int bright, int lumen) {
        super(isON, sourceName, action, bright);
        this.lumen = lumen;
    }

    public void getQuantity(){
        System.out.println("Количество света "+(double) lumen* bright/100+" люмен");
    }
}
