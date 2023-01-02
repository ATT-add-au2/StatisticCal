package unit_test_statutils;

import statutils.MeanCalculator;
import statutils.Scatter;
import statutils.SumCalculator;

import java.util.List;

public class Statutils {
    private final List<Double> exampleData;

    private final SumCalculator sumCalculator;
    private final MeanCalculator meanCalculator;
    private final Scatter scatter;

    public Statutils(List<Double> exampleData) {
        this.exampleData = exampleData;
        sumCalculator = new SumCalculator(exampleData);
        meanCalculator = new MeanCalculator(sumCalculator.sum());
        scatter = new Scatter(meanCalculator.mean(exampleData.size()), exampleData);
    }

    public Double mean() {
        return meanCalculator.mean(exampleData.size());
    }

    public Double sum() {
        return sumCalculator.sum();
    }

    public Double variance() {
        return scatter.variance();
    }

    public Double standardDeviation() {
        return scatter.standardDeviation();
    }

}
