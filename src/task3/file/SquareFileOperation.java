package task3.file;

import task3.Figure;
import task3.Square;

 class SquareFileOperation implements FileOperation{
    @Override
    public String applyLineToFile(Figure figure) {
        return figure.name() + " " + ((Square) figure).getSide();
    }

    @Override
    public Figure createFigure(String[] data) {
        if (data.length <= 1){
            throw new WrongFormatFileException("No side for square");
        }
        return Figure.createSquare(Integer.parseInt(data[1]));
    }
}
