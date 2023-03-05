package task3;

import java.util.*;

public abstract class Figure implements Comparable<Figure> {

    public static final int FIELD = 1;
    public static final int NAME = 2;

    protected static int countFigures = 1;
    protected static int domyslneSortowanie = FIELD;

    abstract double area();

    abstract double circuit();

    public abstract String name();

    public static Square createSquare(int side) {
        return new Square(side);
    }

    public static Rectangle createRectangle(int sideA, int sideB) {
        return new Rectangle(sideA, sideB);
    }

    public static Wheel createWheel(int radius) {
        return new Wheel(radius);
    }

    public static Figure figureWithTheMostCircuit(List<Figure> figures) {
        return Optional.ofNullable(figures)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Figure::circuit))
                .orElseThrow();
    }

    public static Figure figureWithTheMostArea(List<Figure> figures) {
        return Optional.ofNullable(figures)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Figure::area))
                .orElseThrow();
    }

    public static void setDefaultSort(int kryterium) {
        if (kryterium == FIELD || kryterium == NAME) {
            domyslneSortowanie = kryterium;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
