import java.util.List;

public class Average implements Operation {
    @Override
    public double calculate(List<Double> numbers) {
        double sum = 0;
        for(double num: numbers) {
            sum += num;
        }
        return sum / numbers.size();
    }
}
