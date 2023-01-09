
package binmethod;

import java.util.List;

public class RiceRuleFormula extends BinFormulae {

    public RiceRuleFormula(List<Double> _exampleData) {
        super(_exampleData);
    }

    
    public int calcNumOfBins() {

        return (int) (2 * Math.pow(getData().size(), 1 / 3.));

    }
    
}
