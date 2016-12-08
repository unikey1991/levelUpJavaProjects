package com.company.StarSystem;

/**
 * Created by unike on 07.12.2016.
 */
public class Star {

    private int size;
    private String name;
    private int temperature;
    private int weight;

    public Star(int size, String name, int temperature, int weight) {
        this.size = size;
        this.name = name;
        this.temperature = temperature;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
}
