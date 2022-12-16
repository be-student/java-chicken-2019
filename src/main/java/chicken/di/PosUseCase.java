package chicken.di;

import chicken.domain.OrderDto;
import java.util.List;

public interface PosUseCase {

    void order(OrderCommand orderCommand);

    List<OrderDto> findOrderByTable(FindOrderCommand findOrderCommand);

    int pay(PayCommand payCommand);
}
