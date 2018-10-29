package main;

import main.cl.uchile.dcc.neural.networks.service.PerceptonBuilder;
import main.cl.uchile.dcc.neural.networks.service.Perceptron;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        PerceptonBuilder perceptonBuilder = new PerceptonBuilder();

        Perceptron perceptron1 = perceptonBuilder.getNandPerceptron();
        Perceptron perceptron2 = perceptonBuilder.getNandPerceptron();
        Perceptron perceptron3 = perceptonBuilder.getNandPerceptron();
        Perceptron perceptron4 = perceptonBuilder.getNandPerceptron();
        Perceptron perceptron5 = perceptonBuilder.getNandPerceptron();

        Double x = 1.0;
        Double y = 1.0;

        double resultP1 = perceptron1.feed(Arrays.asList(x, y));
        double resultP2 = perceptron2.feed(Arrays.asList(resultP1, y));
        double resultP3 = perceptron3.feed(Arrays.asList(resultP1, x));
        double resultP5 = perceptron5.feed(Arrays.asList(resultP2, resultP3));
        double resultP4 = perceptron4.feed(Arrays.asList(resultP1, resultP1));

        System.out.println("Inputs: x="+x+", y="+y);
        System.out.println("suma (resultP5) = " + resultP5 + ", carry (resultP4) = " + resultP4);

        Perceptron orPerceptron = perceptonBuilder.getOrPerceptron();
        System.out.println("OR Perceptron output="+orPerceptron.feed(Arrays.asList(x, y)));

        Perceptron andPerceptron = perceptonBuilder.getAndPerceptron();
        System.out.println("AND Perceptron output="+andPerceptron.feed(Arrays.asList(x, y)));

    }

}
