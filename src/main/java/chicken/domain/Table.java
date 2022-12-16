package chicken.domain;

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
        int alreadyOrderedCount = orders.getOrDefault(menu, 0);
        if (alreadyOrderedCount + count > 99) {
            throw new IllegalArgumentException("한 테이블에서 주문할 수 있는 내용은 99개까지 입니다");
        }
        orders.put(menu, alreadyOrderedCount + count);
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
