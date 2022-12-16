package chicken.view;

import chicken.domain.Menu;
import chicken.domain.OrderDto;
import chicken.domain.Table;
import java.util.List;

public class OutputView {

    private static final String TOP_LINE = "┏ - ┓";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "┗ - ┛";
    private static final String BOTTOM_CHECKED_LINE = "┗ # ┛";
    private static final String ERROR_PREFIX = "[ERROR]";

    public static void printTables(List<Table> tables) {
        System.out.println();
        System.out.println("## 테이블 목록");
        int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottom(tables);
    }

    public static void printMenus(List<Menu> menus) {
        System.out.println();
        for (Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(String line, int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottom(List<Table> tables) {
        for (Table table : tables) {
            if (table.isOrdered()) {
                System.out.print(BOTTOM_CHECKED_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    private static void printTableNumbers(List<Table> tables) {
        for (Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }

    public static void printOrder(List<OrderDto> orders) {
        System.out.println();
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        for (OrderDto order : orders) {
            System.out.println(order.getMenu() + " " + order.getCount() + " " + order.getMoney());
        }
    }

    public static void printTotalMoney(int totalMoney) {
        System.out.println();
        System.out.println("## 최종 결제할 금액");
        System.out.println(totalMoney + "원");
    }
}
