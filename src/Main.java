import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import cl.uchile.dcc.neural.networks.Curve;
import cl.uchile.dcc.neural.networks.Perceptron;
import cl.uchile.dcc.neural.networks.Plotter;
import cl.uchile.dcc.neural.networks.Point;

public class Main extends JFrame {

    public static final int ON_CURVE = 1;
    public static final int UNDER_CURVE = 0;
    public static final int MAX_ELEMENT = 50;
    public static final int MIN_ELEMENT = 0;

    public static void main(String[] args) {

        List<Double>  weights = new ArrayList<>();
        weights.add(-2d);
        weights.add(-2d);

        Perceptron perceptron1 = new Perceptron(weights, 3);
        Perceptron perceptron2 = new Perceptron(weights, 3);
        Perceptron perceptron3 = new Perceptron(weights, 3);
        Perceptron perceptron4 = new Perceptron(weights, 3);
        Perceptron perceptron5 = new Perceptron(weights, 3);

        Integer x = 1;
        Integer y = 1;

        double resultP1 = perceptron1.feed(Arrays.asList(x, y));
        double resultP2 = perceptron2.feed(Arrays.asList(x, (int)resultP1));
        double resultP3 = perceptron3.feed(Arrays.asList((int)resultP1, y));
        double resultP5 = perceptron5.feed(Arrays.asList((int)resultP2, (int)resultP3));

        double resultP4 = perceptron4.feed(Arrays.asList((int)resultP1, (int)resultP1));

        System.out.println("suma (resultP5) = " + resultP5 + ", carry (resultP4) = " + resultP4);


        perceptron1.train(generateTrainingPoints(new Curve(0, 1, 1)));
        List<Point> points = generatePoints();

        List<Double> xUpper = new ArrayList<>();
        List<Double> yUpper = new ArrayList<>();

        List<Double> xLower = new ArrayList<>();
        List<Double> yLower = new ArrayList<>();

        points.forEach(point -> {

            double classified = perceptron1.feed(Arrays.asList(point.getX(), point.getY()));
            point.setClassification(classified);

            if(classified == 1){
                xUpper.add(new Double(point.getX()));
                yUpper.add(new Double(point.getY()));
            } else {
                xLower.add(new Double(point.getX()));
                yLower.add(new Double(point.getY()));
            }
        });

        SwingUtilities.invokeLater(() -> {
            Plotter plotter = new Plotter("Scatter Plot");
            plotter.setSize(800, 400);
            plotter.setLocationRelativeTo(null);
            plotter.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            plotter.setVisible(true);
        });

    }


    public static List<Point> generateTrainingPoints(Curve curve){
        Random r = new Random();
        Point point;
        List<Point> pointList = new ArrayList<>();
        for(int i = MIN_ELEMENT; i < MAX_ELEMENT; i ++){
            point = new Point();
            point.setX(r.ints(MIN_ELEMENT, MAX_ELEMENT).findFirst().getAsInt());
            point.setY(r.ints(MIN_ELEMENT, MAX_ELEMENT).findFirst().getAsInt());

            if(point.getY() > curve.getY()){
                point.setClassification(ON_CURVE);
            } else {
                point.setClassification(UNDER_CURVE);
            }

            pointList.add(point);
        }
        return pointList;
    }


    public static List<Point> generatePoints(){
        Random r = new Random();
        List<Point> pointList = new ArrayList<>();
        Point point;
        for(int i = MIN_ELEMENT; i < MAX_ELEMENT; i ++){
            point = new Point();
            point.setX(r.ints(MIN_ELEMENT, MAX_ELEMENT).findFirst().getAsInt());
            point.setY(r.ints(MIN_ELEMENT, MAX_ELEMENT).findFirst().getAsInt());

            pointList.add(point);
        }
        return pointList;
    }

}
