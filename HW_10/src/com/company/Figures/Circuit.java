package com.company.Figures;

/**
 * Created by unike on 10.12.2016.
 */
public class Circuit {

    private double area;
    private double centerX;
    private double centerY;
    private double radius;
    Point point;

    public Circuit(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        point = new Point(centerX, centerY);
        area = Math.PI * radius * radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
        area = Math.PI * radius * radius;
    }

    public void setArea(double area) {
        this.area = area;
        radius = Math.sqrt(area/Math.PI);
    }

    public boolean isInCircuitThisPoint (Point point){
        if (radius > Math.sqrt(Math.sqrt(centerX-point.getCoordX())+Math.sqrt(centerY-point.getCoordY()))) return true;
        else return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circuit circuit = (Circuit) o;

        if (Double.compare(circuit.area, area) != 0) return false;
        if (Double.compare(circuit.centerX, centerX) != 0) return false;
        if (Double.compare(circuit.centerY, centerY) != 0) return false;
        if (Double.compare(circuit.radius, radius) != 0) return false;
        return point != null ? point.equals(circuit.point) : circuit.point == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(area);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(centerX);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(centerY);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (point != null ? point.hashCode() : 0);
        return result;
    }
}
