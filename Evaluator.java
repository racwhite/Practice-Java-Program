import java.util.*;

public class Evaluator {
    private static Evaluator evaluator = new Evaluator();

    private Evaluator(){}

    public static Evaluator getEvaluator() {
        return evaluator;
    }

    public static double computeAverage(ArrayList<Integer> data) {
        double total = 0.0;

        for (Integer datum : data) {
            total += datum;
        }

        if (data.size() > 0) {
            return total / data.size();
        } else {
            return Double.NaN;
        }
    }
}