package task1;

public class Main {
    public static void main(String[] args) {
        SolveService solveService = new SolveService();
        double r1 = solveService.solve("2 + 2.5");
        System.out.println(r1);
        double r2 = solveService.solve("10 * 51");
        System.out.println(r2);
    }
}
