package casino.gamingmachine;

import bettingauthorityAPI.GamingMachineID;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.cashier.IPlayerCard;
import casino.game.Game;
import casino.player.Player;

public class GamingMachine implements IGamingMachine {
    private Game game;

    public GamingMachine(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void checkBet(Player player, Bet bet) {

    }

    @Override
    public boolean placeBet(long amountInCents) throws NoPlayerCardException {
        return false;
    }

    @Override
    public void acceptWinner(BetResult winResult) {

    }

    @Override
    public GamingMachineID getGamingMachineID() {
        return null;
    }

    @Override
    public void connectCard(IPlayerCard card) {

    }
}
