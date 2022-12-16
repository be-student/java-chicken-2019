import di.PosUseCaseImpl;
import view.Client;

public class Application {

    // TODO 구현 진행
    public static void main(String[] args) {
        Client client = new Client(new PosUseCaseImpl());
        client.run();
    }
}
