/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statutils;

import java.util.*;

/**
 * @author kezhang
 */
public class ExtremumCalculator {

    private List<Double> exampleData;

    public ExtremumCalculator(List<Double> _exampleData) {
        setData(_exampleData);
    }

    public void setData(List<Double> _exampleData) {
        exampleData = _exampleData;
    }

    public List<Double> getData() {
        return exampleData;
    }

    // calculate max
    public double max() {
        return Collections.max(exampleData);
    }

    // calculate min
    public double min() {
        return Collections.min(exampleData);
    }

}
