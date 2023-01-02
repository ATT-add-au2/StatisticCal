/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mathutils;

import statutils.*;
import binmethod.*;

import java.util.*;

import org.apache.commons.math3.fitting.*;

/**
 * @author kezhang This part calculates the parameters of PDF.
 */
public class Mathutils {

    private NormalisedFreqCalculator NormalisedFreqInstance;

    public Mathutils(NormalisedFreqCalculator _NormalisedFreqInstance) {

    }

    public void setData(NormalisedFreqCalculator _NormalisedFreqInstance) {
        NormalisedFreqInstance = _NormalisedFreqInstance;
    }

    /*return a double array contains the PDF parameters:
      The first element is the Normalization factor
      The second element is the Mean value which is the centre of the PDF
      The third element is the Sigma value which is the width of the PDF
     */

    public double[] getParameters(double[] EleTypeCollect, double[] EleNumCollect, int length) {
        WeightedObservedPoints obs = new WeightedObservedPoints();
        for (int i = 0; i < length; i++) {
            obs.add(EleTypeCollect[i], EleNumCollect[i]);
        }
        double[] parameters = GaussianCurveFitter.create().fit(obs.toList());
        return parameters;
    }

}
