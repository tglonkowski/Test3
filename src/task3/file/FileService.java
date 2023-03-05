package task3.file;

import task3.Figure;
import task3.FiguresEnum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class FileService {
    public static final String FIGURY_TXT = "figury.txt";
    private final Map<String, FileOperation> operations;

    public FileService() {
        this.operations = new HashMap<>() {
            {
                put(FiguresEnum.RECTANGLE.getName(), new RectangleFileOperation());
                put(FiguresEnum.SQUARE.getName(), new SquareFileOperation());
                put(FiguresEnum.WHEEL.getName(), new WheelFileOperation());
            }
        };
    }

    public void saveFiguresToFile(List<Figure> figury) {
        try (PrintWriter writer = new PrintWriter(FIGURY_TXT)) {
            Optional.ofNullable(figury)
                    .orElseGet(Collections::emptyList)
                    .stream()
                    .filter(Objects::nonNull)
                    .forEach(figure -> {
                        String line = addLine(figure);
                        writer.println(line);
                    });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Figure> loadFigures() {
        List<Figure> figures = new ArrayList<>();
        File file = new File(FIGURY_TXT);
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                Figure figure = loadFigure(line);
                figures.add(figure);
            }
            return figures;
        } catch (FileNotFoundException e) {
            System.out.println("File " + FIGURY_TXT + " is not found");
        }
        return figures;
    }

    private String addLine(Figure figure) {
        return operations.get(figure.name()).applyLineToFile(figure);
    }

    private Figure loadFigure(String line) {
        String[] data = line.split(" ");
        String nameOfFigure = data[0];
        return Optional.ofNullable(operations.get(nameOfFigure))
                .orElseThrow(UnknownFigureException::new)
                .createFigure(data);
    }
}
