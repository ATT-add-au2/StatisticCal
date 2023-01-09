
package statutils;

import java.util.*;
import binmethod.*;

public class NormalisedFreqCalculator {
    private List<Double> exampleData;

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
    public double[] getEleTypeCollect() {
        double[] EleTypeCollect = new double[getTypeOfEle()];
        int j = 0;

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
        //normalisation
        for (int j = 0; j < getTypeOfEle(); j++) {
            normalisedFreq[j] = EleNumCollect[j] / denominator;
        }
        return normalisedFreq;

    }

}
