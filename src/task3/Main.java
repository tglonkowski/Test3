package task3;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figura> figury = Arrays.asList(Figura.stworzKwadrat(10), Figura.stworzKolo(20), Figura.stworzProstokat(10, 20),
                Figura.stworzKwadrat(15));
        for (Figura f : figury) {
            System.out.println(f);
        }

        System.out.println();
        System.out.println(Figura.figuraZNajwiekszymObwodem(figury));
        System.out.println(Figura.figuraZNajwiekszymPolem(figury));

        System.out.println();
        System.out.println(figury.contains(new Kwadrat(10)));
        System.out.println();

//        System.out.println("Sortowanie:");
//        Collections.sort(figury);
//        System.out.println(figury);
//        System.out.println("Sortowanie po kryterium:");
//        Figura.ustalDomyslneSortowanie(Figura.KRYTERUM_NAZWA);
//        Collections.sort(figury);
//
//        System.out.println(figury);
        Figura.zapiszFiguryDoPliku(figury);
    }
}
