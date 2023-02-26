package task3;

import java.util.Comparator;
import java.util.Objects;

class Kwadrat extends Figura {

    private int bok;
    private int licznikKwadratu = licznikFigur++;

    Kwadrat(int bok) {
        this.bok = bok;
    }

    public int getBok() {
        return bok;
    }

    @Override
    double pole() {
        return bok * bok;
    }

    @Override
    double obwod() {
        return 4 * bok;
    }

    @Override
    String nazwa() {
        return FiguryEnum.KWADRAT.getNazwa();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kwadrat kwadrat = (Kwadrat) o;
        return Double.compare(kwadrat.bok, bok) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bok);
    }

    @Override
    public String toString() {
        return "Figura nr " + licznikKwadratu + ": Kwadrat o boku " + bok + ".";
    }

    @Override
    public int compareTo(Figura o) {
        if (domyslneSortowanie == KRYTERUM_NAZWA) {
            Comparator<Figura> comparator = Comparator.comparing(Figura::nazwa).thenComparing(Figura::pole);
            return comparator.compare(this, o);
        } else
            return Double.compare(this.pole(), o.pole());
    }
}
