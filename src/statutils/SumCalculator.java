
package statutils;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class SumCalculator {
    private List<Double> exampleData;

    public SumCalculator(List<Double> _exampleData) {
        setData(_exampleData);
    }

    public void setData(List<Double> _exampleData) {
        exampleData = _exampleData;
    }

    public List<Double> getData() {
        return exampleData;
    }

    //calculate the sum of the dataset
    public double sum() {
        double sum = 0.;
        for (Iterator<Double> it = exampleData.iterator(); it.hasNext(); ) {
            sum = sum + it.next();
        }
        return sum;
    }
}
