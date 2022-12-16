package chicken.di;

import chicken.domain.Menu;
import chicken.domain.MenuRepository;
import chicken.domain.OrderDto;
import chicken.domain.Table;
import chicken.domain.TableRepository;
import chicken.domain.WayToPay;
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
        Table targetTable = TableRepository.findById(findOrderCommand.getTableId());
        return targetTable.calculateOrder();
    }

    @Override
    public int pay(PayCommand payCommand) {
        Table targetTable = TableRepository.findById(payCommand.getTable());
        WayToPay option = WayToPay.from(payCommand.getPayOption());
        int totalMoney = targetTable.calculateOrder()
                .stream()
                .map(OrderDto::getMoney)
                .reduce(0, Integer::sum);
        targetTable.payed();
        return option.calculateFee(totalMoney);
    }
}
