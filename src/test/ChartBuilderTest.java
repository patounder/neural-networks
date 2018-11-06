package test;

import main.cl.uchile.dcc.neural.networks.service.services.ChartBuilder;
import org.junit.Test;

public class ChartBuilderTest {

    ChartBuilder chartBuilder = new ChartBuilder();

    @Test
    public void ShowLineChart_ShouldRenderLineChart(){
        chartBuilder.showClassificationChart();
    }

}
