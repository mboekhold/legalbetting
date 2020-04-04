package casino.cashier;

import casino.bet.Bet;
import casino.bet.MoneyAmount;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cashier implements ICashier {

    Map<IPlayerCard, MoneyAmount> moneyAmounts = new HashMap<>();

    @Override
    public IPlayerCard distributeGamblerCard() {
        return new Card();
    }

    @Override
    public void returnGamblerCard(IPlayerCard card) {
        Set BetIDs = card.returnBetIDsAndClearCard();
    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) throws BetNotExceptedException {
        long cardBalance = moneyAmounts.get(card).getAmountInCents();

        if  (betToCheck.getMoneyAmount().getAmountInCents() > cardBalance) {
            throw new BetNotExceptedException();
        }

        return true;
    }

    @Override
    public void addAmount(IPlayerCard card, MoneyAmount amount) {
        moneyAmounts.put(card, amount);
    }

}
