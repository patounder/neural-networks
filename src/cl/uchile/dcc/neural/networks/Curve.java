package cl.uchile.dcc.neural.networks;

public class Curve {
    private int x;
    private int y;
    private int slope;

    public Curve(int x, int y, int slope) {
        this.x = x;
        this.y = y;
        this.slope = slope;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSlope() {
        return slope;
    }

    public void setSlope(int slope) {
        this.slope = slope;
    }
}
