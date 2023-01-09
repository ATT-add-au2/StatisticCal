
package statutils;

import java.util.*;

public class Scatter {

    private double mean;
    private List<Double> exampleData;

    /*Constructor
    Parameters: _mean, mean value of the exampleData
                _exampleData, input dataset
     */
    public Scatter(double _mean, List<Double> _exampleData) {
        setData(_mean, _exampleData);
    }

    public void setData(double _mean, List<Double> _exampleData) {
        mean = _mean;
        exampleData = _exampleData;
    }

    //return the common part of variance and standard deviation
    public double getVarianceNumerator() {
        double varianceNumerator = 0;
        for (Iterator<Double> it = exampleData.iterator(); it.hasNext(); ) {
            varianceNumerator = varianceNumerator + Math.pow((it.next() - mean), 2);

        }
        return varianceNumerator;
    }

    //return the variance of exampleData
    public double variance() {
        return getVarianceNumerator() / exampleData.size();
    }

    //return the standard deviation of exampleData
    public double standardDeviation() {
        return Math.pow((getVarianceNumerator() / exampleData.size()), 0.5);
    }

}
