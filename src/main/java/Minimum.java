import java.util.List;

public class Minimum implements Operation {

    @Override
    public double calculate(List<Double> numbers) {
        double min = Double.MAX_VALUE;
        for(double num: numbers) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }
}
