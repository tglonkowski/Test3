package task3.file;

import task3.Figure;
import task3.Rectangle;

class RectangleFileOperation implements FileOperation {
    @Override
    public String applyLineToFile(Figure figure) {
        return figure.name() + " " + ((Rectangle) figure).getSideA() + " " + ((Rectangle) figure).getSideB();
    }
    @Override
    public Figure createFigure(String[] data) {
        if (data.length <= 2){
            throw new WrongFormatFileException("No sides for rectangle");
        }
        return Figure.createRectangle(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
    }
}
