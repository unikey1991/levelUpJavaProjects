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

    public double getCoordX() {
        return coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.coordX, coordX) != 0) return false;
        return Double.compare(point.coordY, coordY) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(coordX);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(coordY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
