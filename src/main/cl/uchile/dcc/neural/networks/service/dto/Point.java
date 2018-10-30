package main.cl.uchile.dcc.neural.networks.service.dto;

public class Point {

    private double abscissa;
    private double ordinate;

    public Point(double abscissa, double ordinate) {
        this.abscissa = abscissa;
        this.ordinate = ordinate;
    }

    public double getAbscissa() {
        return abscissa;
    }

    public void setAbscissa(double abscissa) {
        this.abscissa = abscissa;
    }

    public double getOrdinate() {
        return ordinate;
    }

    public void setOrdinate(double ordinate) {
        this.ordinate = ordinate;
    }

    @Override
    public String toString() {
        return "Point{" +
                "abscissa=" + abscissa +
                ", ordinate=" + ordinate +
                '}';
    }
}
