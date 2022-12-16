package domain;

import java.util.Arrays;

public enum WayToPay {
    CREDIT_CARD(1, 0),
    CACHE(2, 0.95);

    private final int id;
    private final double discountRate;

    WayToPay(int id, double discountRate) {
        this.id = id;
        this.discountRate = discountRate;
    }

    public static WayToPay from(int id) {
        return Arrays.stream(WayToPay.values())
                .filter(it -> it.id == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 결제수단입니다"));
    }

    public int calculateFee(int fee) {
        return (int) (fee * (1 - discountRate));
    }
}
