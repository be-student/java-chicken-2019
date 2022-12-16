package chicken.di;

public class OrderCommand {

    private final int table;
    private final int menu;
    private final int count;

    public OrderCommand(int table, int menu, int count) {
        this.table = table;
        this.menu = menu;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int getMenu() {
        return menu;
    }

    public int getTable() {
        return table;
    }
}
