package casino.game;

public class NoCurrentRoundException extends Exception {

    public NoCurrentRoundException(String message) {
        super(message);
    }
}
