package com.company.Figures;

/**
 * Created by unike on 08.12.2016.
 */
public class LineSegment {
    private Point point[];
    private double coordOfStartX;
    private double coordOfStartY;
    private double coordOfEndX;
    private double coordOfEndY;
    private Double length;


    public LineSegment(double coordOfStartX, double coordOfStartY, double coordOfEndX, double coordOfEndY, Double length) {
        this.coordOfStartX = coordOfStartX;
        this.coordOfStartY = coordOfStartY;
        this.coordOfEndX = coordOfEndX;
        this.coordOfEndY = coordOfEndY;
        this.length = length;
        point = new Point[2];
        for (int i = 0; i < 2; i++){
            point[i] = new Point(0,0);
        }
        setPointCoord(coordOfStartX,coordOfStartY,coordOfEndX ,coordOfEndY);
    }


    public void setPointCoord(double coordOfStartX, double coordOfStartY, double coordOfEndX, double coordOfEndY){
        point[0].setCoordX(coordOfStartX);
        point[0].setCoordY(coordOfStartY);
        point[1].setCoordX(coordOfEndX);
        point[1].setCoordY(coordOfEndY);
    }



    public void setCoordOfStartX(double coordOfStartX) {
        this.coordOfStartX = coordOfStartX;
    }

    public void setCoordOfStartY(double coordOfStartY) {
        this.coordOfStartY = coordOfStartY;
    }

    public void setCoordOfEndX(double coordOfEndX) {
        this.coordOfEndX = coordOfEndX;
    }

    public void setCoordOfEndY(double coordOfEndY) {
        this.coordOfEndY = coordOfEndY;
    }

    public void setLength(Double length) {
        this.length = length;
    }
}
