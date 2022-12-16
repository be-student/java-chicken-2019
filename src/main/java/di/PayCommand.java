package di;

public class PayCommand {

    private final int table;
    private final int payOption;

    public PayCommand(int table, int payOption) {
        this.table = table;
        this.payOption = payOption;
    }

    public int getTable() {
        return table;
    }

    public int getPayOption() {
        return payOption;
    }
}
