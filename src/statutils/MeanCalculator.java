/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statutils;

import java.util.*;

/**
 * @author kezhang This part calculate the mean value of the input dataset
 */
public class MeanCalculator {

    private double sum;

    /*constructor
      The parameter _sum is the sum of the dataset
     */
    public MeanCalculator(double _sum) {
        setData(_sum);
    }

    public void setData(double _sum) {
        sum = _sum;
    }

    //return the mean value of the dataset.
    public double mean(int size) {
        double mean = sum / size;
        return mean;
    }
}
