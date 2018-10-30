package main.cl.uchile.dcc.neural.networks.service.dto;

public class Line {

    private double intersection;
    private double slope;

    public Line(double intersection, double slope) {
        this.intersection = intersection;
        this.slope = slope;
    }

    public double getIntersection() {
        return intersection;
    }

    public void setIntersection(double intersection) {
        this.intersection = intersection;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    @Override
    public String toString() {
        return "Line{" +
                "intersection=" + intersection +
                ", slope=" + slope +
                '}';
    }
}
