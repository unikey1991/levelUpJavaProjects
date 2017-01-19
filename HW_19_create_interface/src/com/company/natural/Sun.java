package com.company.natural;

/**
 * Created by unike on 19.01.2017.
 */
public class Sun extends NaturalLight {

    public Sun(boolean isDay) {
        super(isDay, "Sun",isDay?100:0);
    }

}
