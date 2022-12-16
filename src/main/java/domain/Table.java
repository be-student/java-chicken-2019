package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        orders.clear();
    }

    public boolean isId(int tableId) {
        return number == tableId;
    }

    public List<OrderDto> calculateOrder() {
        return orders.entrySet().stream()
                .filter(it -> it.getValue() > 0)
                .map(it -> toDto(it.getKey(), it.getValue()))
                .collect(Collectors.toList());
    }

    private OrderDto toDto(Menu menu, int count) {
        return new OrderDto(menu.getName(), count, menu.calculatePrice(count));
    }

    public boolean isOrdered() {
        return ordered;
    }
}
