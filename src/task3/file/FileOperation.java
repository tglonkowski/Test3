package task3.file;

import task3.Figure;

public interface FileOperation {

    String applyLineToFile(Figure figure);

    Figure createFigure(String[] data);
}
