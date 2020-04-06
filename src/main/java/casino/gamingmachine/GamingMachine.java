package casino.gamingmachine;

import bettingauthorityAPI.GamingMachineID;
import casino.bet.Bet;
import casino.bet.BetID;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.cashier.BetNotExceptedException;
import casino.cashier.Cashier;
import casino.cashier.ICashier;
import casino.cashier.IPlayerCard;
import casino.game.IGame;

import java.util.UUID;

public class GamingMachine implements IGamingMachine {
    private IGame game;
    private IPlayerCard card;
    private ICashier cashier;

    public GamingMachine(IGame game, ICashier cashier) {
        this.game = game;
        this.cashier = cashier;
    }

    public IGame getGame() {
        return game;
    }

    @Override
    public boolean placeBet(long amountInCents) throws NoPlayerCardException {
        if (card == null) throw new NoPlayerCardException();
        Bet bet = new Bet(new BetID(new UUID(123,123)), new MoneyAmount(amountInCents));
        try {
            cashier.checkIfBetIsValid(card, bet);
        } catch (BetNotExceptedException e) {
            return false;
        }
        return true;
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
