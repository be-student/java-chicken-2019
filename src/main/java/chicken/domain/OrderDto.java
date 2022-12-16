package chicken.domain;

public class OrderDto {

    private final String menu;
    private final int count;
    private final int money;

    public OrderDto(String menu, int count, int money) {
        this.menu = menu;
        this.count = count;
        this.money = money;
    }

    public int getCount() {
        return count;
    }

    public int getMoney() {
        return money;
    }

    public String getMenu() {
        return menu;
    }
}
