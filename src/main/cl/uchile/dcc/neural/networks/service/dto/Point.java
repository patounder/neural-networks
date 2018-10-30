package main.cl.uchile.dcc.neural.networks.service.dto;

public class Point {

    private double abscissa;
    private double ordinate;
    private int classification;

    public Point() {
        super();
    }

    public Point(double abscissa, double ordinate) {
        super();
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

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    @Override
    public String toString() {
        return "Point{" +
                "abscissa=" + abscissa +
                ", ordinate=" + ordinate +
                ", classification=" + classification +
                '}';
    }
}
