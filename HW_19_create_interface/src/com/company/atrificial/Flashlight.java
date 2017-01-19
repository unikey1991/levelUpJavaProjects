package com.company.atrificial;

/**
 * Created by unike on 19.01.2017.
 */
public class Flashlight extends Lamp {

    public Flashlight(boolean isON) {
        super(isON, "Flash light", isON?"Фонарик горит":"Фонарик выключен", isON?100:0, 40);
    }
}
