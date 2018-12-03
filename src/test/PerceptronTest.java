package test;

import main.cl.uchile.dcc.neural.networks.service.PerceptonBuilder;
import main.cl.uchile.dcc.neural.networks.service.Perceptron;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;

public class PerceptronTest {

    private double INPUT_X_ONE = 1.0;
    private double INPUT_Y_ONE = 1.0;
    private double INPUT_X_ZERO = 0.0;
    private double INPUT_Y_ZERO = 0.0;
    private double ONE_OUTPUT = 1.0;
    private double ZERO_OUTPUT = 0.0;

    private PerceptonBuilder perceptonBuilder = new PerceptonBuilder();

    @Test
    public void WhenNandPerceptron_ShouldGenerateSucessfullOutput(){

        Perceptron nandPerceptron = perceptonBuilder.getNandPerceptron();

        assertEquals(nandPerceptron.feed(Arrays.asList(INPUT_X_ZERO, INPUT_Y_ZERO)), ONE_OUTPUT);
        assertEquals(nandPerceptron.feed(Arrays.asList(INPUT_X_ZERO, INPUT_Y_ONE)), ONE_OUTPUT);
        assertEquals(nandPerceptron.feed(Arrays.asList(INPUT_X_ONE, INPUT_Y_ZERO)), ONE_OUTPUT);
        assertEquals(nandPerceptron.feed(Arrays.asList(INPUT_X_ONE, INPUT_Y_ONE)), ZERO_OUTPUT);

    }

    @Test
    public void WhenOrPerceptron_ShouldGenerateSucessfullOutput(){

        Perceptron orPerceptron = perceptonBuilder.getOrPerceptron();

        assertEquals(orPerceptron.feed(Arrays.asList(INPUT_X_ZERO, INPUT_Y_ZERO)), ZERO_OUTPUT);
        assertEquals(orPerceptron.feed(Arrays.asList(INPUT_X_ZERO, INPUT_Y_ONE)), ONE_OUTPUT);
        assertEquals(orPerceptron.feed(Arrays.asList(INPUT_X_ONE, INPUT_Y_ZERO)), ONE_OUTPUT);
        assertEquals(orPerceptron.feed(Arrays.asList(INPUT_X_ONE, INPUT_Y_ONE)), ONE_OUTPUT);
    }

    @Test
    public void WhenAndPerceptron_ShouldGenerateSucessfullOutput(){

        Perceptron andPerceptron = perceptonBuilder.getAndPerceptron();

        assertEquals(andPerceptron.feed(Arrays.asList(INPUT_X_ZERO, INPUT_Y_ZERO)), ZERO_OUTPUT);
        assertEquals(andPerceptron.feed(Arrays.asList(INPUT_X_ZERO, INPUT_Y_ONE)), ZERO_OUTPUT);
        assertEquals(andPerceptron.feed(Arrays.asList(INPUT_X_ONE, INPUT_Y_ZERO)), ZERO_OUTPUT);
        assertEquals(andPerceptron.feed(Arrays.asList(INPUT_X_ONE, INPUT_Y_ONE)), ONE_OUTPUT);

    }


    @Test
    public void testCharAscii(){
        String randomWord = generateRandomWordSequence(4, "");
        System.out.println(randomWord);
    }

    private String generateRandomWordSequence(int maxLength, String word){
        //ASCII 97 - 122
        if(maxLength == 0){
            return word;
        } else {
            char randomCharacter = (char) getRandomIntFromRange(97, 122);
            return generateRandomWordSequence(maxLength - 1, word.concat(Character.toString(randomCharacter)));
        }
    }

    public int getRandomIntFromRange(int from, int to){
        return (int) (Math.random()*((to - from) + 1)) + from;
    }
}
