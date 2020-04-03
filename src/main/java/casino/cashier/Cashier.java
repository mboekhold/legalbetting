package casino.cashier;

import casino.bet.Bet;
import casino.bet.MoneyAmount;

import java.util.HashMap;
import java.util.Map;

public class Cashier implements ICashier {

    Map<IPlayerCard, MoneyAmount> moneyAmounts = new HashMap<>();

    @Override
    public IPlayerCard distributeGamblerCard() {
        return null;
    }

    @Override
    public void returnGamblerCard(IPlayerCard card) {

    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) throws BetNotExceptedException {
        long cardBalance = moneyAmounts.get(card).getAmountInCents();

        return true;
    }

    @Override
    public void addAmount(IPlayerCard card, MoneyAmount amount) {
        moneyAmounts.put(card, amount);
    }

}
