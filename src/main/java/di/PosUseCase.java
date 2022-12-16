package di;

public interface PosUseCase {

    void order(OrderCommand orderCommand);

    int pay(PayCommand payCommand);
}
