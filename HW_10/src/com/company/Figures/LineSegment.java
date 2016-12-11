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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineSegment that = (LineSegment) o;

        if (stratPoint != null ? !stratPoint.equals(that.stratPoint) : that.stratPoint != null) return false;
        return endPoint != null ? endPoint.equals(that.endPoint) : that.endPoint == null;
    }

    @Override
    public int hashCode() {
        int result = stratPoint != null ? stratPoint.hashCode() : 0;
        result = 31 * result + (endPoint != null ? endPoint.hashCode() : 0);
        return result;
    }
}
