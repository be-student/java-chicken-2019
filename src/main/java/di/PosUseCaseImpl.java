package di;

import domain.Menu;
import domain.MenuRepository;
import domain.OrderDto;
import domain.Table;
import domain.TableRepository;
import domain.WayToPay;
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
