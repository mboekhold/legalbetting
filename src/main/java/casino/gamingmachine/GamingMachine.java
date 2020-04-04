package casino.gamingmachine;

import bettingauthorityAPI.GamingMachineID;
import casino.bet.BetResult;
import casino.cashier.IPlayerCard;
import casino.game.IGame;

public class GamingMachine implements IGamingMachine {
    private IGame game;

    private IPlayerCard card;

    public GamingMachine(IGame game) {
        this.game = game;
    }

    public IGame getGame() {
        return game;
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
        this.card = card;
    }

    public IPlayerCard getCard() {
        return card;
    }
}
