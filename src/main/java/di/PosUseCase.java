package di;

import domain.OrderDto;

public interface PosUseCase {

    void order(OrderCommand orderCommand);

    OrderDto findOrderByTable(FindOrderCommand findOrderCommand);

    int pay(PayCommand payCommand);
}
