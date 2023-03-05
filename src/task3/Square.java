package task3;

import java.util.Comparator;
import java.util.Objects;

public class Square extends Figure {

    private int side;
    private int countSquare = countFigures++;

    Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    double area() {
        return side * side;
    }

    @Override
    double circuit() {
        return 4 * side;
    }

    @Override
    public String name() {
        return FiguresEnum.SQUARE.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Double.compare(square.side, side) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side);
    }

    @Override
    public String toString() {
        return "Figura nr " + countSquare + ": Kwadrat o boku " + side + ".";
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
