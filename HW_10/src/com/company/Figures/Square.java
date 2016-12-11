package com.company.Figures;

import java.util.Arrays;

/**
 * Created by unike on 08.12.2016.
 */
public class Square {
    private LineSegment lineSegment[];
    private String color;
    private double width;
    private double lenth;

    public Square(String color, double width, double lenth) {
        this.color = color;
        this.width = width;
        this.lenth = lenth;
        lineSegment = new LineSegment[4];
        lineSegment[0] = new LineSegment(0,0,lenth,0);
        lineSegment[1] = new LineSegment(0,0,0,width);
        lineSegment[2] = new LineSegment(width,0,width,lenth);
        lineSegment[3] = new LineSegment(lenth,width,lenth,0);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(double width, double lenth){
        this.lenth = lenth;
        this.width = width;
        lineSegment[0].setPointCoord(0,0,lenth,0);
        lineSegment[1].setPointCoord(0,0,0,width);
        lineSegment[2].setPointCoord(width,0,width,lenth);
        lineSegment[3].setPointCoord(lenth,width,lenth,0);

    }

    public void narrow (double narrowValue){
        this.width -= narrowValue;
        setSize(width, lenth);
    }

    public void extend (double extendValue){
        this.width += extendValue;
        setSize(width, lenth);
    }

    public void rotate (){
        System.out.println("Square rotated");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (Double.compare(square.width, width) != 0) return false;
        if (Double.compare(square.lenth, lenth) != 0) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(lineSegment, square.lineSegment)) return false;
        return color != null ? color.equals(square.color) : square.color == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = Arrays.hashCode(lineSegment);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lenth);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
