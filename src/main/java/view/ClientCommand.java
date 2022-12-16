package view;

import java.util.Arrays;

public enum ClientCommand {
    ORDER(1),
    PAY(2),
    QUIT(3);

    private final int command;

    ClientCommand(int command) {
        this.command = command;
    }

    public static ClientCommand fromInput(int input) {
        return Arrays.stream(ClientCommand.values())
                .filter(it -> it.command == input)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("1,2,3만 입력할 수 있습니다"));
    }
}
