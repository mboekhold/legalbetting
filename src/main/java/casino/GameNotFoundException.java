package casino;

public class GameNotFoundException extends Exception {
    public GameNotFoundException() {
        super("A game by this name was not found");
    }
}
