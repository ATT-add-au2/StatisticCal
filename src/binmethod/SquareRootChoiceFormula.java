
package binmethod;

import java.util.List;


public class SquareRootChoiceFormula extends BinFormulae {
    
    public int calcNumOfBins() {
        return (int) Math.pow(getData().size(), 0.5);
    }
    
    public SquareRootChoiceFormula(List<Double> _exampleData) {
        super(_exampleData);
    }
}
