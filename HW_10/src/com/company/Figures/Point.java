package com.company.Figures;

/**
 * Created by unike on 08.12.2016.
 */
public class Point {

    private double coordX;
    private double coordY;


    public Point(double coordX, double coordY) {
        this.coordX = coordX;
        this.coordY = coordY;
    }

    protected void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    protected void setCoordY(double coordY) {
        this.coordY = coordY;
    }
}
