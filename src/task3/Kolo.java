package task3;

import java.util.Comparator;
import java.util.Objects;

class Kolo extends Figura {

    private int promien;
    private int licznikKola = licznikFigur++;

    Kolo(int promien) {
        this.promien = promien;
    }

    public int getPromien() {
        return promien;
    }

    @Override
    double pole() {
        return Math.PI * Math.pow(promien, 2);
    }

    @Override
    double obwod() {
        return 2 * Math.PI * promien;
    }

    @Override
    String nazwa() {
        return FiguryEnum.KOLO.getNazwa();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kolo kolo = (Kolo) o;
        return Double.compare(kolo.promien, promien) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(promien);
    }

    @Override
    public String toString() {
        return "Figura nr " + licznikKola + ": Koło o promieniu " + promien + ".";
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
