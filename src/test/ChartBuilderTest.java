package test;

import main.cl.uchile.dcc.neural.networks.service.services.ChartBuilder;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ChartBuilderTest {

    ChartBuilder chartBuilder = new ChartBuilder();

    @Test
    public void ShowLineChart_ShouldRenderLineChart(){
        chartBuilder.showClassificationChart(null, null);
    }

    @Test
    public void readFile(){
        try {

            File f = new File("dataset/echocardiogram.txt");

            BufferedReader b = new BufferedReader(new FileReader(f));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {
                System.out.println(readLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
