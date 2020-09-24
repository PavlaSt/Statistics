import java.util.*;


public class StatisticsOOP {

    final private Scanner scanner = new Scanner(System.in);
    final private Map<String, Operation> operationsMap = new HashMap<>();
    private int countOfNumbers;
    private List<Double> numbers = new ArrayList<>();
    private String operation;

    public StatisticsOOP() {
        this.operationsMap.put("MIN", new Minimum());
        this.operationsMap.put("MAX", new Maximum());
        this.operationsMap.put("AVG", new Average());
    }

    void setCount(int countOfNumbers) {
        this.countOfNumbers = countOfNumbers;
    }

    int scanCount() {
        while (true) {
            try {
                System.out.println("Zadej počet vkládaných hodnot: ");
                countOfNumbers = Integer.parseInt(scanner.next());
                if (countOfNumbers > 0) {
                    return countOfNumbers;
                } else {
                    System.out.println("Počet hodnot musí být větší než 0!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Chybný vstup");
            }
        }
    }

    void setArrayList(List<Double> numbers) {
        this.numbers = numbers;
    }

    List<Double> scanArrayList() {
        numbers.clear();
        for (int i = 0; i < countOfNumbers; i++) {
            while (true) {
                try {
                    System.out.printf("Zadej %d. hodnotu:  ", i + 1);
                    numbers.add(Double.parseDouble(scanner.next()));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Chybný vstup");
                }
            }
        }
        return numbers;
    }

    void setOperation(String operation) {
        this.operation = operation;
    }

    String scanOperation() {
        while (true) {
            System.out.println("Zadej operaci: MIN, MAX, AVG ");
            operation = scanner.next().toUpperCase();
            if (operation.equals("MIN") || operation.equals("MAX") || operation.equals("AVG")) {
                return operation;
            } else {
                System.out.println("Zadej správnou operaci: MIN, MAX nebo AVG.");
            }
        }
    }

    void printResult(double result) {
        System.out.printf("Výsledek je %.2f. ", result);
    }

    boolean decideIfNextOperation() {
        System.out.println(" Chceš pokračovat další operací operací?  ANO / NE ");
        return !scanner.next().toUpperCase().equals("NE");
    }

    boolean decideIfNewData() {
        System.out.println("Chceš pokračovat s jinými daty?  ANO / NE ");
        return !scanner.next().toUpperCase().equals("NE");
    }

    public static void main(String[] args) {

        boolean checker = true;
        boolean operationChecker;

//      print introduction
        System.out.println("Program Statistika.");
        System.out.println("-------------------");
        System.out.println("Ze zadaných celých čísel spočítá minimum, maximum a průměr.");

//      create object
        StatisticsOOP statistics = new StatisticsOOP();

        while (checker) {

//          get input data
            statistics.setCount(statistics.scanCount());
            statistics.setArrayList(statistics.scanArrayList());

            operationChecker = true;
            while (operationChecker) {
//          get operation
                statistics.setOperation(statistics.scanOperation());

//          perform operation and print result

                Operation myOperation = statistics.operationsMap.get(statistics.operation);

                statistics.printResult(myOperation.calculate(statistics.numbers));

//          decide if continue with different operation
                operationChecker = statistics.decideIfNextOperation();
            }

//          decide if continue  with different data
            checker = statistics.decideIfNewData();

        }
    }
}
