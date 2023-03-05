package task3;

import task3.file.FileService;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = Arrays.asList(Figure.createSquare(10), Figure.createWheel(20), Figure.createRectangle(10, 20),
                Figure.createSquare(15));
        for (Figure f : figures) {
            System.out.println(f);
        }

        System.out.println();
        System.out.println(Figure.figureWithTheMostCircuit(figures));
        System.out.println(Figure.figureWithTheMostArea(figures));

        System.out.println();
        System.out.println(figures.contains(new Square(10)));
        System.out.println();

//        System.out.println("Sortowanie:");
//        Collections.sort(figures);
//        System.out.println(figures);
//        System.out.println("Sortowanie po kryterium:");
//        Figura.ustalDomyslneSortowanie(Figura.KRYTERUM_NAZWA);
//        Collections.sort(figures);
//
//        System.out.println(figures);
        FileService fileService = new FileService();
        fileService.saveFiguresToFile(figures);
    }
}
