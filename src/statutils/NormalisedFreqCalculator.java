/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statutils;

import java.util.*;

import binmethod.*;

/**
 * @author kezhang
 * This part claculates the normalised frequency of the input dataset
 * It also contains some side statistical functionalities, for example calculate
 * how many types of element the input dataset has and calculate the number of elements
 * that every type collects.
 */
public class NormalisedFreqCalculator {
    private List<Double> exampleData;

    /*constructor
       The parameter is the dataset contains many datapoints
    */
    public NormalisedFreqCalculator(List<Double> _exampleData) {
        setData(_exampleData);
    }

    public void setData(List<Double> _exampleData) {
        exampleData = _exampleData;
    }

    // return the input data;
    public List<Double> getData() {
        return exampleData;
    }

    //retrun an int which reflects how many tpyes of element the dataset has
    public int getTypeOfEle() {
        Collections.sort(exampleData);
        int i, j, EleType;
        j = 0;
        EleType = 1;
        for (i = 1; i < exampleData.size(); i++) {
            if ((exampleData.get(i) - exampleData.get(i - 1)) != 0) {
                EleType++;
            }
        }
        return EleType;
    }

    //return a double array which collects the element types.
    //In this array, every elements are different reflecting how many types of elements the dataset has.
    public double[] getEleTypeCollect() {
        double[] EleTypeCollect = new double[getTypeOfEle()];
        int j = 0;
        //check the list head
        //this is for special case which the first element is different from the second one
        if (exampleData.get(0) != exampleData.get(1))
            EleTypeCollect[0] = exampleData.get(0);

        for (int i = 1; i < exampleData.size(); i++) {
            if ((exampleData.get(i) - exampleData.get(i - 1)) == 0) {
                EleTypeCollect[j] = exampleData.get(i - 1);

            } else {
                j++;
                EleTypeCollect[j] = exampleData.get(i);
            }
        }
        return EleTypeCollect;
    }

    //return a double array which collects the number of every elements
    //this is far from the above function getEleTypeCollect()
    public double[] getEleNumCollect() {
        double[] EleNumCollect = new double[getTypeOfEle()];
        int j = 0;
        for (int i = 0; i < getTypeOfEle(); i++) {
            EleNumCollect[i] = 1;
        }
        for (int i = 1; i < exampleData.size(); i++) {
            if ((exampleData.get(i) - exampleData.get(i - 1)) == 0) {
                EleNumCollect[j]++;

            } else {
                j++;
            }
        }
        return EleNumCollect;
    }

    //return a double array which the elements contains the normalised frequencies.
    public double[] getNormalisedFreq() {
        double denominator = 0.;
        double[] EleNumCollect = getEleNumCollect();
        double[] normalisedFreq = new double[getTypeOfEle()];
        //calculate the denominator
        for (int i = 0; i < getTypeOfEle(); i++) {
            denominator = denominator + EleNumCollect[i] * (Collections.max(exampleData) - Collections.min(exampleData)) / getTypeOfEle();
        }
        //start normalisation
        for (int j = 0; j < getTypeOfEle(); j++) {
            normalisedFreq[j] = EleNumCollect[j] / denominator;
        }
        return normalisedFreq;

    }

}
