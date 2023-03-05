package task3;

import task3.file.FileService;

import java.util.List;

public class LoadingMain {

    public static void main(String[] args) {
        FileService fileService = new FileService();
        List<Figure> figures = fileService.loadFigures();
        for (Figure f : figures) {
            System.out.println(f);
        }
    }
}
