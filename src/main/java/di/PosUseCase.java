package di;

import domain.OrderDto;
import java.util.List;

public interface PosUseCase {

    void order(OrderCommand orderCommand);

    List<OrderDto> findOrderByTable(FindOrderCommand findOrderCommand);

    int pay(PayCommand payCommand);
}
