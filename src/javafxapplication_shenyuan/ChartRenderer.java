
package javafxapplication_shenyuan;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import binmethod.*;
import java.util.Collections;
import javafx.scene.chart.LineChart;
import statutils.*;

public class ChartRenderer {

    /*
    draw bar chart
    param: BarChart barChart
           BinFormulae binmethod
     */
    public static void drawBarChart(BarChart barChart, BinFormulae binmethod) {

        XYChart.Series dataSeries1 = new XYChart.Series();
        BinInfo b = new BinInfo(binmethod, IOOperation.getInputData());
        double[] binindex = b.getBinIndex();
        double[] binContent = b.getBinContent(binindex);
        //add data points
        for (int i = 0; i < binmethod.calcNumOfBins(); i++) {
            dataSeries1.getData().add(new XYChart.Data(String.valueOf(binindex[i]), binContent[i]));

        }
        barChart.getData().addAll(dataSeries1);
    }

    /*
    draw bar chart
    param: LineChart linChart
           BinFormulae binmethod
     */
    public static void drawLineChart(LineChart linChart, BinFormulae binmethod) {

        XYChart.Series dataSeries2 = new XYChart.Series();
        BinInfo b = new BinInfo(binmethod, IOOperation.getInputData());
        double[] binindex = b.getBinIndex();
        double[] binContent = b.getBinContent(binindex);
        double[] normalisedFreq = new double[binmethod.calcNumOfBins()];
        double denominator = 0.;
        for (int i = 0; i < binmethod.calcNumOfBins() - 1; i++) {
            denominator = denominator + binContent[i] * (Collections.max(IOOperation.getInputData()) - Collections.min(IOOperation.getInputData())) / binmethod.calcNumOfBins();
        }
        //start normalisation
        for (int j = 0; j < binmethod.calcNumOfBins() - 1; j++) {
            normalisedFreq[j] = binContent[j] / denominator;
        }
        //add data points
        for (int i = 0; i < binmethod.calcNumOfBins(); i++) {

            dataSeries2.getData().add(new XYChart.Data(String.valueOf(binindex[i]), normalisedFreq[i]));
        }


        linChart.getData().addAll(dataSeries2);

    }

}
