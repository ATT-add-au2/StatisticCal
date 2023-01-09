
package statutils;

import binmethod.*;

import java.util.*;

public class BinInfo {

    public BinFormulae binmethod;
    private List<Double> exampleData;

    public BinInfo(BinFormulae _binmethod, List<Double> _exampleData) {
        binmethod = _binmethod;
        exampleData = _exampleData;
    }

    //Collect bin
    public double[] getBinIndex() {
        double[] binindex = new double[binmethod.calcNumOfBins() + 1];
        for (int i = 0; i < binmethod.calcNumOfBins(); i++) {
            binindex[i] = Collections.min(binmethod.getData()) + i * binmethod.widthOfBins();
        }
        return binindex;
    }

    // calculate the number of dataponts in binindex
    public double[] getBinContent(double[] binindex) {
        double[] binContent = new double[binmethod.calcNumOfBins()];
        int j = 0;
        for (int i = 0; i < exampleData.size(); i++) {
            if (binindex[j + 1] > exampleData.get(i) && binindex[j] <= exampleData.get(i)) {
                binContent[j]++;
            } else if (binindex[j + 1] <= exampleData.get(i) && j < binmethod.calcNumOfBins() - 1) {
                j++;
                binContent[j]++;
            }
        }
        return binContent;
    }

}
