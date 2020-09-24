import java.util.List;

public class Maximum implements Operation{

    @Override
    public double calculate(List<Double> numbers) {
        double max = Double.MIN_VALUE;
        for(double num: numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
