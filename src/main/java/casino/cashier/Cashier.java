package casino.cashier;

import bettingauthorityAPI.IBetLoggingAuthority;
import casino.bet.Bet;
import casino.idbuilder.BetID;
import casino.idbuilder.CardID;
import casino.bet.MoneyAmount;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cashier implements ICashier {

    Map<IPlayerCard, MoneyAmount> moneyAmounts = new HashMap<>();
    Set<BetID> Logs = new HashSet<>();

    @Override
    public IPlayerCard distributeGamblerCard() {
        Card card = new Card();
        return card;
    }

    @Override
    public void returnGamblerCard(IPlayerCard card) {
        Set<BetID> BetIDs = card.returnBetIDsAndClearCard();
        Logs.addAll(BetIDs);
        moneyAmounts.remove(card);

    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) throws BetNotExceptedException {
        long cardBalance = moneyAmounts.get(card).getAmountInCents();

        if  (betToCheck.getMoneyAmount().getAmountInCents() > cardBalance) {
            throw new BetNotExceptedException();
        }

        return true;
    }

    public int getLogsSize() {
        return Logs.size();
    }

    @Override
    public void addAmount(IPlayerCard card, MoneyAmount amount) {
        moneyAmounts.put(card, amount);
    }


    long getAmountOfMoneyOnCard(IPlayerCard card) {
        return moneyAmounts.get(card) != null ? moneyAmounts.get(card).getAmountInCents(): 0;
    }
}
