package task1;

import java.util.HashMap;
import java.util.Map;

public class SolveService {
    public static final String EQUATION_SPACE = " ";
    private final Map<String, Operation> operations;

    public SolveService() {
        this.operations = new HashMap<>() {
            {
                put("+", new Addition());
                put("-", new Subtraction());
                put("*", new Multiplication());
                put("/", new Division());
            }
        };
    }

    public double solve(String equation) {
        String[] strings = equation.split(EQUATION_SPACE);
        double firstDigit = Double.parseDouble(strings[0]);
        double secondDigit = Double.parseDouble(strings[2]);
        String operation = strings[1];
        return operations.get(operation).apply(firstDigit, secondDigit);
    }
}
