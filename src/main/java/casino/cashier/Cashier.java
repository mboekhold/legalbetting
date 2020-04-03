package casino.cashier;

import casino.bet.Bet;
import casino.bet.MoneyAmount;

public class Cashier implements ICashier {
    @Override
    public IPlayerCard distributeGamblerCard() {
        return null;
    }

    @Override
    public void returnGamblerCard(IPlayerCard card) {

    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) throws BetNotExceptedException {
        return false;
    }

    @Override
    public void addAmount(IPlayerCard card, MoneyAmount amount) {

    }
}
