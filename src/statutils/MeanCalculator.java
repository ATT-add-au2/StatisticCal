
package statutils;

import java.util.*;

public class MeanCalculator {

    private double sum;
    
// calculate the sum
    
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
