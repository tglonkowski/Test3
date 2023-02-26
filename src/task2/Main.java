package task2;

import task1.SolveService;

public class Main {
    public static void main(String[] args) {
        MyFileReader myFileReader = new MyFileReader(new SolveService());
        myFileReader.getResultFile();
    }
}
