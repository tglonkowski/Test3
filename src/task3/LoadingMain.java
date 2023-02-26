package task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class LoadingMain {

    public static final String FIGURY_TXT = "figury.txt";

    public List<Figura> wczytajFigury() {
        List<Figura> figury = new ArrayList<>();
        File file = new File(FIGURY_TXT);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                Figura figura = wczytajFigure(line);
                figury.add(figura);
            }
            return figury;
        } catch (FileNotFoundException e) {
            System.out.println("Plik " + FIGURY_TXT + " nie został znaleziony");
        }
        return figury;
    }

    private Figura wczytajFigure(String line) {
        String[] strings = line.split(" ");
        String nazwaFigury = strings[0];
        Optional<Figura> figura = Optional.empty();
        if (nazwaFigury.equals(FiguryEnum.KWADRAT.getNazwa())) {
            figura = Optional.of(Figura.stworzKwadrat(Integer.parseInt(strings[1])));
        } else if (nazwaFigury.equals(FiguryEnum.KOLO.getNazwa())) {
            figura = Optional.of(Figura.stworzKolo(Integer.parseInt(strings[1])));
        } else if (nazwaFigury.equals(FiguryEnum.PROSTOKAT.getNazwa())) {
            figura = Optional.of(Figura.stworzProstokat(Integer.parseInt(strings[1]), Integer.parseInt(strings[2])));
        }
        return figura.orElseThrow(NieznanaFiguraException::new);
    }

    public static void main(String[] args) {
        List<Figura> figury = new LoadingMain().wczytajFigury();
        for (Figura f : figury) {
            System.out.println(f);
        }
    }
}
