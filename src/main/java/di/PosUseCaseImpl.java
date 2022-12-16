package di;

import domain.OrderDto;
import java.util.List;

public class PosUseCaseImpl implements PosUseCase {

    @Override
    public void order(OrderCommand orderCommand) {
    
    }

    @Override
    public List<OrderDto> findOrderByTable(FindOrderCommand findOrderCommand) {
        return null;
    }

    @Override
    public int pay(PayCommand payCommand) {
        return 0;
    }
}
