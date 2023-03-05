package task3;

import java.util.Comparator;
import java.util.Objects;

public class Wheel extends Figure {

    private int radius;
    private int countWheel = countFigures++;

    Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    double circuit() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String name() {
        return FiguresEnum.WHEEL.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wheel wheel = (Wheel) o;
        return Double.compare(wheel.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public String toString() {
        return "Figura nr " + countWheel + ": Koło o promieniu " + radius + ".";
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
