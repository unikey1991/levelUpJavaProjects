package com.company.Figures;

/**
 * Created by unike on 08.12.2016.
 */
public class LineSegment {
    private Point stratPoint;
    private Point endPoint;


    public LineSegment(double startCoordX, double startCoordY, double endCoordX, double endCoordY) {
        stratPoint = new Point(startCoordX, startCoordY);
        endPoint = new Point(endCoordX, endCoordY);
    }

    public void setPointCoord(double coordOfStartX, double coordOfStartY, double coordOfEndX, double coordOfEndY){
        stratPoint.setCoordX(coordOfStartX);
        stratPoint.setCoordY(coordOfStartY);
        endPoint.setCoordX(coordOfEndX);
        endPoint.setCoordY(coordOfEndY);
    }
}
