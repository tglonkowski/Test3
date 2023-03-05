package task3;

public enum FiguresEnum {

    WHEEL("Kolo"),
    SQUARE("Kwadrat"),
    RECTANGLE("Prostokat");

    private final String name;

    FiguresEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
