package di;

public class FindOrderCommand {

    private final int tableId;

    public FindOrderCommand(int tableId) {
        this.tableId = tableId;
    }

    public int getTableId() {
        return tableId;
    }
}
