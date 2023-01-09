
package binmethod;

import java.util.*;

public abstract class BinFormulae {
    //parameter declariation

    private int NumOfBins;
    private List<Double> exampleData;
    

    //abstract constructer
    public BinFormulae(List<Double> _exampleData) {
        setData(_exampleData);
    }

    //set the input data
    public void setData(List<Double> _exampleData) {
        exampleData = _exampleData;
    }
    //get the number of Bins

    public int getNumberOfBins() {
        return NumOfBins;
    }

    public void setNumberOfBins(int _NumOfBins) {
        NumOfBins = _NumOfBins;
    }

    public double widthOfBins() {
        return (Collections.max(exampleData) - Collections.min(exampleData)) / calcNumOfBins();
    }

    //get the private exampleData
    public List<Double> getData() {
        return exampleData;
    }

    //calcuate the number of bins
    public abstract int calcNumOfBins();

}
