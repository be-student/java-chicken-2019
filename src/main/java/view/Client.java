package view;

import di.PosUseCase;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import java.util.List;

public class Client {

    private final PosUseCase posUseCase;

    public Client(PosUseCase posUseCase) {
        this.posUseCase = posUseCase;
    }

    public void run() {
        List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        int tableNumber = InputView.inputTableNumber();

        List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
