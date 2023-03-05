package task3.file;

import task3.Figure;
import task3.Wheel;

class WheelFileOperation implements FileOperation {
    @Override
    public String applyLineToFile(Figure figure) {
        return figure.name() + " " + ((Wheel) figure).getRadius();
    }

    @Override
    public Figure createFigure(String[] data) {
        if (data.length <= 1){
            throw new WrongFormatFileException("No radius for wheel");
        }
        return Figure.createWheel(Integer.parseInt(data[1]));
    }
}
