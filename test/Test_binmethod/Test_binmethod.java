/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_binmethod;

import java.util.Arrays;
import java.util.List;

import binmethod.*;

/**
 * @author kezhang
 */
public class Test_binmethod {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
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
