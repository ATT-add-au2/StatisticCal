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
public class SturgesFormula extends BinFormulae {


    public SturgesFormula(List<Double> _exampleData) {
        super(_exampleData);
    }

    @Override
    public int calcNumOfBins() {

        return (int) Math.rint(3.3 * Math.log10(getData().size()) + 1);

    }


}
