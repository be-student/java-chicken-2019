package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println();
        System.out.println("## 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputFunction() {
        printMain();
        System.out.println();
        System.out.println("## 원하는 기능을 선택하세요.");
        return scanner.nextInt();
    }

    private static void printMain() {
        System.out.println();
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static int inputMenu() {
        System.out.println();
        System.out.println("## 등록할 메뉴를 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenuCount() {
        System.out.println();
        System.out.println("## 메뉴의 수량을 입력하세요.");
        return scanner.nextInt();
    }
}
