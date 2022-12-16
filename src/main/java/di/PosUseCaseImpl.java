package di;

import domain.Menu;
import domain.MenuRepository;
import domain.OrderDto;
import domain.Table;
import domain.TableRepository;
import java.util.List;

public class PosUseCaseImpl implements PosUseCase {

    @Override
    public void order(OrderCommand orderCommand) {
        Menu targetMenu = MenuRepository.findById(orderCommand.getMenu());
        Table targetTable = TableRepository.findById(orderCommand.getTable());
        int count = orderCommand.getCount();
        targetTable.ordered(targetMenu, count);
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
