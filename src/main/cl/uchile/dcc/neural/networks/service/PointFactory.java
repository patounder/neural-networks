package main.cl.uchile.dcc.neural.networks.service;

import main.cl.uchile.dcc.neural.networks.service.dto.Point;

import java.util.ArrayList;
import java.util.List;

public class PointFactory {

    private static final int qtyPoints = 10;
    private static final int minRange = -10;
    private static final int maxRange = 10;

    public static List<Point> getRandomPoints(){

        List<Point> pointList = new ArrayList<>(qtyPoints);
        Point auxPoint;

        for(int i = 0; i < qtyPoints; i++){
            auxPoint = new Point();
            auxPoint.setAbscissa(getRandomNumberBetweenRange(minRange, maxRange));
            pointList.add(auxPoint);
        }

        return pointList;
    }

    public static double getRandomNumberBetweenRange(double min, double max){
        double randomNumber = (int) (Math.random()*((max - min) + 1)) + min;
        return randomNumber;
    }
}
