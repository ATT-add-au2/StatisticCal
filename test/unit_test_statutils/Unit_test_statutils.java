/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test_statutils;

import java.util.*;
import java.util.Arrays;
import binmethod.*;
import statutils.*;

import org.apache.commons.math3.fitting.*;

public class Unit_test_statutils {

    public static void main(String[] args) {
       
        List<Double> exampleData = Arrays.asList(1., 2., 3., 4., 5., 6., 7., 8., 9., 10., 11.);

        Statutils mm = new Statutils(exampleData);

        System.out.println("Mean: " + mm.mean());
        System.out.println("Max: " + mm.max());
        System.out.println("Min: " + mm.min());

        exampleData.stream();

        //calculate Median
        double s = 0.;
        Collections.sort(exampleData);
        int size = exampleData.size();
        if (size % 2 != 1) {
            s = (exampleData.get(size / 2 - 1) + exampleData.get(size / 2) + 0.) / 2;
        } else {
            s = exampleData.get((size - 1) / 2);
        }
        System.out.println("Median： " + s);


        //calculate Variance and Standard Deviation
        System.out.println("Variance: " + mm.variance());
        System.out.println("Standard Deviation: " + mm.standardDeviation());

        //calculate the width and quntity of bin
        SturgesFormula sturgesinstance = new SturgesFormula(exampleData);
        sturgesinstance.calcNumOfBins();

        double width = (Collections.max(exampleData) - Collections.min(exampleData)) / sturgesinstance.getNumberOfBins();
        System.out.println("Width： " + width);
 
        List<Double> copy = exampleData;

        Collections.sort(copy);

        int eleNum = 1;
        int i, j;
        j = 0;

        for (i = 1; i < size; i++) {
            if ((copy.get(i) - copy.get(i - 1)) != 0) {
                eleNum++;
            }
        }
        System.out.println("Quntity: " + eleNum);
        //统计数组内每种元素的数量
        //b1统计了各个元素
        double[] b1 = new double[eleNum];
        double[] b2 = new double[eleNum];
        //把b2全部赋值成全一，不这么做，后面计算出各个元素的数量会全部少一个，因为数组从零开始
        //这个逻辑也很好理解，因为每个出现的元素，最少数量是1，不可能出现0的情况
        for (int inib2 = 0; inib2 < eleNum; inib2++) {
            b2[inib2] = 1;
        }
        for (int qi = 1; qi < copy.size(); qi++) {
            if ((copy.get(qi) - copy.get(qi - 1)) == 0) {
                b1[j] = copy.get(qi - 1);
                b2[j]++;
            } else {
                j++;
                b1[j] = copy.get(qi - 1);
            }

        }
      
        int pj;

        double denominator = 0.;
        for (pj = 0; pj < eleNum; pj++) {
            denominator = denominator + b2[pj];
        }
        System.out.println("归一化频率的分母是： " + denominator);

        Double[] newfreq = new Double[eleNum];

        for (int qj = 0; qj < eleNum; qj++) {

            newfreq[qj] = b2[qj] / denominator;
            //newfreq.set(qj,b2[qj]/denominator);
        }

        List<Double> normalisedfreq = Arrays.asList(newfreq);
        //java直接打印数组是数组的地址
        System.out.println("归一化频率是" + normalisedfreq);

        //每个bin中的数据点数量，就是各个元素归一化频率乘以元素总数

    }
}
