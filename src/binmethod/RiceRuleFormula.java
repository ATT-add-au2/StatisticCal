/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binmethod;

import java.util.List;

/**
 * @author kezhang
 */
public class RiceRuleFormula extends BinFormulae {

    public RiceRuleFormula(List<Double> _exampleData) {
        super(_exampleData);
    }

    @Override
    public int calcNumOfBins() {

        return (int) (2 * Math.pow(getData().size(), 1 / 3.));

    }
    // @Override


}
