package domain;

public class Table {

    private final int number;
    private final Map<Menu, Integer> orders = new HashMap<>();
    private boolean ordered = false;

    public Table(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void ordered(Menu menu, int count) {
        ordered = true;
        orders.put(menu, orders.getOrDefault(menu, 0) + count);
    }

    public void payed() {
        ordered = false;
    public boolean isId(int tableId) {
        return number == tableId;
    }

    public boolean isOrdered() {
        return ordered;
    }
}
