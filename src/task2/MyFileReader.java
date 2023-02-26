package task2;

import task1.SolveService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFileReader {
    private final static String SOURCE_FILE_NAME = "equations.txt";
    private final static String RESULT_FILE_NAME = "results.txt";

    private final SolveService solveService;

    public MyFileReader(SolveService solveService) {
        this.solveService = solveService;
    }

    public void getResultFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(SOURCE_FILE_NAME));
             PrintWriter writer = new PrintWriter(RESULT_FILE_NAME)) {
            reader.lines()
                    .parallel()
                    .forEach(line -> {
                        String result = getResult(line);
                        String resultLine = line + " = " + result;
                                writer.println(resultLine);
                            }
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getResult(String line) {
        String result;
        try {
            result = String.valueOf(solveService.solve(line));
        } catch (NullPointerException e) {
            result = "Błąd, nieznany operator: " + line.split(SolveService.EQUATION_SPACE)[1];
        } catch (NumberFormatException e) {
            result = "Błąd, równanie ma zły format";
        }
        return result;
    }
}
