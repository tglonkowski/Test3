package task3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public abstract class Figura implements Comparable<Figura> {

    public static final int KRYTERUM_POLE = 1;
    public static final int KRYTERUM_NAZWA = 2;

    protected static int licznikFigur = 1;
    protected static int domyslneSortowanie = KRYTERUM_POLE;

    abstract double pole();

    abstract double obwod();

    abstract String nazwa();

    public static Kwadrat stworzKwadrat(int bok) {
        return new Kwadrat(bok);
    }

    public static Prostokąt stworzProstokat(int bokA, int bokB) {
        return new Prostokąt(bokA, bokB);
    }

    public static Kolo stworzKolo(int promien) {
        return new Kolo(promien);
    }

    public static Figura figuraZNajwiekszymObwodem(List<Figura> figury) {
        return Optional.ofNullable(figury)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Figura::obwod))
                .orElseThrow();
    }

    public static Figura figuraZNajwiekszymPolem(List<Figura> figury) {
        return Optional.ofNullable(figury)
                .orElseGet(Collections::emptyList)
                .stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparing(Figura::pole))
                .orElseThrow();
    }

    public static void ustalDomyslneSortowanie(int kryterium) {
        if (kryterium == KRYTERUM_POLE || kryterium == KRYTERUM_NAZWA) {
            domyslneSortowanie = kryterium;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static void zapiszFiguryDoPliku(List<Figura> figury) {
        try (PrintWriter writer = new PrintWriter("figury.txt")) {
            Optional.ofNullable(figury)
                    .orElseGet(Collections::emptyList)
                    .stream()
                    .filter(Objects::nonNull)
                    .forEach(figura -> {
                        String line = dodajLinieWZaleznosciOdFigury(figura);
                        writer.println(line);
                    });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String dodajLinieWZaleznosciOdFigury(Figura figura) {
        String line = "";
        if (figura instanceof Kwadrat) {
            line = figura.nazwa() + " " + ((Kwadrat) figura).getBok();
        } else if (figura instanceof Kolo) {
            line = figura.nazwa() + " " + ((Kolo) figura).getPromien();
        } else if (figura instanceof Prostokąt) {
            line = figura.nazwa() + " " + ((Prostokąt) figura).getBokA() + " " + ((Prostokąt) figura).getBokB();
        }
        return line;
    }
}
