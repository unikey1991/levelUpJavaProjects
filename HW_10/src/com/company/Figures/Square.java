package com.company.Figures;

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

}
