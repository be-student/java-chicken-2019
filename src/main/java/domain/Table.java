package domain;

public class Table {

    private final int number;
    private boolean ordered = false;

    public Table(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void ordered() {
        ordered = true;
    }

    public void payed() {
        ordered = false;
    }

    public boolean isOrdered() {
        return ordered;
    }
}
