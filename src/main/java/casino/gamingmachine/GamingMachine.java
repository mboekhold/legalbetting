package casino.gamingmachine;

import casino.bet.Bet;
import casino.game.Game;
import casino.player.Player;

public class GamingMachine {
    private Game game;

    public GamingMachine(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void checkBet(Player player, Bet bet) {

    }
}
