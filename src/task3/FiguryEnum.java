package task3;

public enum FiguryEnum {

    KOLO("Kolo"),
    KWADRAT("Kwadrat"),
    PROSTOKAT("Prostokat");

    private final String nazwa;

    FiguryEnum(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }
}
