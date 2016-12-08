package com.company.Figures;

/**
 * Created by unike on 08.12.2016.
 */
public class Square {
    private LineSegment lineSegment[];
    private String color;
    private double lenthX;
    private double lenthY;

    public Square(String color, double lenthX, double lenthY) {
        lineSegment = new LineSegment[4];
        this.color = color;
        this.lenthX = lenthX;
        this.lenthY = lenthY;
        setLineCoord(lenthX, lenthY);
        for (int i = 0; i < 4; i++){
            lineSegment[i] = new LineSegment(0,0,0,0, 0.);
        }
    }


    public void setLineCoord(double lenthX, double lenthY){
        lineSegment[0].setCoordOfStartX(0);
        lineSegment[0].setCoordOfStartY(0);
        lineSegment[0].setCoordOfEndX(lenthX);
        lineSegment[0].setCoordOfEndY(0);
        lineSegment[1].setCoordOfStartX(0);
        lineSegment[1].setCoordOfStartY(0);
        lineSegment[1].setCoordOfEndX(0);
        lineSegment[1].setCoordOfEndY(lenthY);
        lineSegment[2].setCoordOfStartX(0);
        lineSegment[2].setCoordOfStartY(lenthY);
        lineSegment[2].setCoordOfEndX(lenthX);
        lineSegment[2].setCoordOfEndY(lenthY);
        lineSegment[3].setCoordOfStartX(lenthX);
        lineSegment[3].setCoordOfStartY(lenthY);
        lineSegment[3].setCoordOfEndX(lenthX);
        lineSegment[3].setCoordOfEndY(0);
    }

    public void squareExtension(int extensionSizeX, int extensionSizeY){
        setLineCoord(lenthX+extensionSizeX, lenthY+extensionSizeY);
    }

    public void squareContraction(int contractionSizeX, int contractionSizeY){
        setLineCoord(lenthX-contractionSizeX,lenthY-contractionSizeY);
    }

    public void squareRotate(){
        setLineCoord( lenthY, lenthX);
    }

    public void setColor(String color) {
        this.color = color;
    }
}
