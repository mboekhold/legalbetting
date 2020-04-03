package casino.gamingmachine;

import casino.game.Game;

public class GamingMachine {
    private Game game;

    public GamingMachine(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}
