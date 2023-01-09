
package javafxapplication_shenyuan;

import statutils.*;
import mathutils.*;
import javafx.scene.control.TextArea;

public class StatisticDataFilter {
    /*
    Print the standard statistic data, max, min, mean, variance and standard deviation
    */
    public static void showStatisticData(TextArea statisticTextArea) {
        MaxandMinCalculator extremum = new MaxandMinCalculator(IOOperation.getInputData());
        SumCalculator sum = new SumCalculator(IOOperation.getInputData());
        MeanCalculator mean = new MeanCalculator(sum.sum());
        Scatter scatter = new Scatter(mean.mean(IOOperation.getInputData().size()), IOOperation.getInputData());
        statisticTextArea.setText("Data Statistic Parameters:\nMax: " + extremum.max() + "\nMin: " + extremum.min() + "\nMean: " + mean.mean(IOOperation.getInputData().size()) + "\nVariance: " + scatter.variance() + "\nStandard Deviation: " + scatter.standardDeviation());
    }

    /*
    Print the PDF parameters
    */
    public static void showPDFparameters(TextArea gaussianTextArea) {
        NormalisedFreqCalculator calcnormalisedfreq = new NormalisedFreqCalculator(IOOperation.getInputData());
        Mathutils mathutils = new Mathutils(calcnormalisedfreq);
        double[] mathutilsArray = mathutils.getParameters(calcnormalisedfreq.getEleTypeCollect(), calcnormalisedfreq.getNormalisedFreq(), calcnormalisedfreq.getTypeOfEle());
        gaussianTextArea.setText("PDF parameters:\nNormalisation coefficient α=" + 10E5 * mathutilsArray[0] + "\nCentre of the PDF μ=" + mathutilsArray[1] + "\nWidth of the PDF σ=" + mathutilsArray[2]);
    }


}
