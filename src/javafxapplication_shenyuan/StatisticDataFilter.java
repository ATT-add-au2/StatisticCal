
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication_shenyuan;

import statutils.*;
import mathutils.*;
import javafx.scene.control.TextArea;

/**
 * @author kezhang
 * This part displays calculated parameters according to user's dataset
 */

public class StatisticDataFilter {
    /*
    Print the standard statistic data info, max, min, mean, variance,standard deviation
    param: TextArea statisticTextArea
    
    */
    public static void showStatisticData(TextArea statisticTextArea) {
        ExtremumCalculator extremum = new ExtremumCalculator(IOOperation.getInputData());
        SumCalculator sum = new SumCalculator(IOOperation.getInputData());
        MeanCalculator mean = new MeanCalculator(sum.sum());
        Scatter scatter = new Scatter(mean.mean(IOOperation.getInputData().size()), IOOperation.getInputData());
        statisticTextArea.setText("Data Statistic Parameters:\nMax: " + extremum.max() + "\nMin: " + extremum.min() + "\nMean: " + mean.mean(IOOperation.getInputData().size()) + "\nVariance: " + scatter.variance() + "\nStandard Deviation: " + scatter.standardDeviation());
    }

    /*
    Print the PDF parameters
    param: TextArea gaussianTextArea
    */
    public static void showPDFparameters(TextArea gaussianTextArea) {
        NormalisedFreqCalculator calcnormalisedfreq = new NormalisedFreqCalculator(IOOperation.getInputData());
        Mathutils mathutils = new Mathutils(calcnormalisedfreq);
        // double [] mathutilsArray = new double [3];
        double[] mathutilsArray = mathutils.getParameters(calcnormalisedfreq.getEleTypeCollect(), calcnormalisedfreq.getNormalisedFreq(), calcnormalisedfreq.getTypeOfEle());
        gaussianTextArea.setText("PDF parameters:\nNormalisation coefficient" + 10E5 * mathutilsArray[0] + "\nCentre of the PDF" + mathutilsArray[1] + "\nWidth of the PDF" + mathutilsArray[2]);
    }


}
