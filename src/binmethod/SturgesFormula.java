
package binmethod;

import java.util.List;

public class SturgesFormula extends BinFormulae {

        public int calcNumOfBins() {
        return (int) Math.rint(3.3 * Math.log10(getData().size()) + 1);
    }
  
    public SturgesFormula(List<Double> _exampleData) {
        super(_exampleData);
    }

}
