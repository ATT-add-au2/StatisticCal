/* 
 Client code to test the binmethod package
*/

package Test_binmethod;

import java.util.Arrays;
import java.util.List;
import binmethod.*;

public class Test_binmethod {

    public static void main(String[] args) {
        // Create array of data
        List<Double> exampleData = Arrays.asList(1., 2., 3., 4., 5., 6., 7., 8., 9., 10., 11.);
        // test SturgesFormula class
        SturgesFormula SturgesInstance = new SturgesFormula(exampleData);
        SturgesInstance.calcNumOfBins();
        System.out.printf("By Sturges Formula: %d  \n", SturgesInstance.calcNumOfBins());
        System.out.printf("size: %d  \n", SturgesInstance.getData().size());
        // test SquareRootChoice class
        SquareRootChoiceFormula SquareRootChoiceInstance = new SquareRootChoiceFormula(exampleData);
        SquareRootChoiceInstance.calcNumOfBins();
        System.out.printf("By Square Root Formula: %d \n", SquareRootChoiceInstance.calcNumOfBins());
        System.out.printf("size: %d  \n", SquareRootChoiceInstance.getData().size());
        // test RiceRule class
        RiceRuleFormula RiceRuleInstance = new RiceRuleFormula(exampleData);
        RiceRuleInstance.calcNumOfBins();
        System.out.printf("By Rice Rule Formula: %d \n", RiceRuleInstance.calcNumOfBins());
        System.out.printf("size: %d  \n", RiceRuleInstance.getData().size());

    }


}
