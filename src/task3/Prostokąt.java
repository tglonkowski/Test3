package task3;

import java.util.Comparator;
import java.util.Objects;

class Prostokąt extends Figura {

    private int bokA;
    private int bokB;
    private int licznikProstokątu = licznikFigur++;

    Prostokąt(int bokA, int bokB) {
        this.bokA = bokA;
        this.bokB = bokB;
    }

    public int getBokA() {
        return bokA;
    }

    public int getBokB() {
        return bokB;
    }

    @Override
    double pole() {
        return bokA * bokB;
    }

    @Override
    double obwod() {
        return 2 * bokA + 2 * bokB;
    }

    @Override
    String nazwa() {
        return FiguryEnum.PROSTOKAT.getNazwa();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prostokąt prostokąt = (Prostokąt) o;
        return Double.compare(prostokąt.bokA, bokA) == 0 && Double.compare(prostokąt.bokB, bokB) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bokA, bokB);
    }

    @Override
    public String toString() {
        return "Figura nr " + licznikProstokątu + ": Prostokąt o bokach " + bokA + "x" + bokB + ".";
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
