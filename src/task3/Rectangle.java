package task3;

import java.util.Comparator;
import java.util.Objects;

public class Rectangle extends Figure {

    private int sideA;
    private int sideB;
    private int countRectangle = countFigures++;

    Rectangle(int sideA, int sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public int getSideA() {
        return sideA;
    }

    public int getSideB() {
        return sideB;
    }

    @Override
    double area() {
        return sideA * sideB;
    }

    @Override
    double circuit() {
        return 2 * sideA + 2 * sideB;
    }

    @Override
    public String name() {
        return FiguresEnum.RECTANGLE.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.sideA, sideA) == 0 && Double.compare(rectangle.sideB, sideB) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideA, sideB);
    }

    @Override
    public String toString() {
        return "Figura nr " + countRectangle + ": Prostokąt o bokach " + sideA + "x" + sideB + ".";
    }

    @Override
    public int compareTo(Figure o) {
        if (domyslneSortowanie == NAME) {
            Comparator<Figure> comparator = Comparator.comparing(Figure::name).thenComparing(Figure::area);
            return comparator.compare(this, o);
        } else
            return Double.compare(this.area(), o.area());
    }
}
