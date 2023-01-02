/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit_test_statutils;

import java.util.*;
import java.util.Arrays;
// the bin rule formulae must be implemented in binmethod package
import binmethod.*;
import statutils.*;

import org.apache.commons.math3.fitting.*;

/**
 * @author kezhang
 */
public class Unit_test_statutils {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Double> exampleData = Arrays.asList(1., 1., 3., 2., 1., 2., 1., 3., 2., 3., 10., 99., -2.);

        //System.out.println(sum/exampleData.size());
        Statutils mm = new Statutils(exampleData);

        System.out.println("平均值: " + mm.mean());
        System.out.println("最大值: " + mm.max());
        System.out.println("最小值: " + mm.min());
        System.out.println("总和: " + mm.sum());

        exampleData.stream();

        //计算中位数
        double s = 0.;
        Collections.sort(exampleData);
        int size = exampleData.size();
        if (size % 2 != 1) {
            s = (exampleData.get(size / 2 - 1) + exampleData.get(size / 2) + 0.) / 2;
        } else {
            s = exampleData.get((size - 1) / 2);
        }
        System.out.println("中位数是： " + s);


        //计算母体方差，和母体标准差
        System.out.println("方差: " + mm.variance());
        System.out.println("标准差: " + mm.standardDeviation());

        //计算bin的宽度 task 2b
        SturgesFormula sturgesinstance = new SturgesFormula(exampleData);
        sturgesinstance.calcNumOfBins();

        double width = (Collections.max(exampleData) - Collections.min(exampleData)) / sturgesinstance.getNumberOfBins();
        System.out.println("bin的宽度是： " + width);
        System.out.println("bin的数量是; " + sturgesinstance.getNumberOfBins());

        //计算未归一化的频率
        //统计数组内元素的种类数
        //统计数组内每种元素的数量
        List<Double> copy = exampleData;

        Collections.sort(copy);
        System.out.println(copy);

        int eleNum = 1;
        int i, j;
        j = 0;
        System.out.println(size);

        for (i = 1; i < size; i++) {
            if ((copy.get(i) - copy.get(i - 1)) != 0) {
                eleNum++;
            }
        }
        System.out.println("NUMBER OF ELEMENTS IS : " + eleNum);
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
        System.out.println("copy的元素种类有几种" + eleNum);
        //显示有bug，如无显示必要不需要修改
        System.out.println("copy的不同元素有哪些" + b1);
        //b2储存了各个元素的数量，比如4个1三个2三个3
        System.out.println("copy的不同元素的数量：" + b2[0]);
        System.out.println(b2[1]);
        System.out.println(b2[2]);
        //种类数有了，每个种类的频率也有了，开始计算归一化频率
        //归一化频率等于每个bin的频率（非归一化）除以每个bin的频率（非归一化）乘以bin的宽度
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

        // List<Double> normalisedfreq = Arrays.asList(newfreq);
        //注意: java中 Double和double不一样
        List<Double> normalisedfreq = Arrays.asList(newfreq);
        //java直接打印数组是数组的地址
        System.out.println("归一化频率是" + normalisedfreq);

        //每个bin中的数据点数量，就是各个元素归一化频率乘以元素总数


        //第三题
        WeightedObservedPoints obs = new WeightedObservedPoints();

        for (int ti = 0; ti < b1.length; ti++) {

            obs.add(b1[ti], b2[ti]);
        }

        double[] parameters = GaussianCurveFitter.create().fit(obs.toList());

        System.out.printf("Normalization factor = %f\n", parameters[0]);
        System.out.printf("Mean = %f\n", parameters[1]);
        System.out.printf("Sigma = %f\n", parameters[2]);


    }
}
