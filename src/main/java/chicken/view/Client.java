package chicken.view;

import chicken.di.FindOrderCommand;
import chicken.di.OrderCommand;
import chicken.di.PayCommand;
import chicken.di.PosUseCase;
import chicken.domain.Menu;
import chicken.domain.MenuRepository;
import chicken.domain.Table;
import chicken.domain.TableRepository;
import java.util.List;

public class Client {

    private final PosUseCase posUseCase;

    public Client(PosUseCase posUseCase) {
        this.posUseCase = posUseCase;
    }

    public void run() {
        while (true) {
            ClientCommand input = ClientCommand.fromInput(InputView.inputFunction());
            if (input == ClientCommand.QUIT) {
                return;
            }
            if (input == ClientCommand.PAY) {
                repeat(this::pay);
                continue;
            }
            repeat(this::order);
        }
    }

    private void order() {
        List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        int tableNumber = InputView.inputTableNumber();

        List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        int menuId = InputView.inputMenu();
        int menuCount = InputView.inputMenuCount();
        posUseCase.order(new OrderCommand(tableNumber, menuId, menuCount));
    }

    private void pay() {
        List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        int tableNumber = InputView.inputTableNumber();
        OutputView.printOrder(posUseCase.findOrderByTable(new FindOrderCommand(tableNumber)));

        int wayToPay = InputView.inputWayToPay(tableNumber);
        int totalMoney = posUseCase.pay(new PayCommand(tableNumber, wayToPay));
        OutputView.printTotalMoney(totalMoney);
    }

    private void repeat(Runnable runnable) {
        try {
            runnable.run();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            repeat(runnable);
        }
    }
}
