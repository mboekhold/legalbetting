package casino.cashier;

import casino.idbuilder.BetID;
import casino.idbuilder.CardID;

import java.util.HashSet;
import java.util.Set;

public class Card implements IPlayerCard {

    Set<BetID> betIDs;

    public Card() {
        this.betIDs = new HashSet<>();
    }

    @Override
    public Set<BetID> returnBetIDs() {
        return new HashSet<>(betIDs);
    }

    @Override
    public Set<BetID> returnBetIDsAndClearCard() {
        Set<BetID> copy = new HashSet<>(betIDs);
        betIDs.clear();
        return copy;
    }

    @Override
    public BetID generateNewBetID() {
        return null;
    }

    @Override
    public int getNumberOfBetIDs() {
        return betIDs.size();
    }

    @Override
    public CardID getCardID(){ return null; }

    public void addBetID(BetID betID) {
        betIDs.add(betID);
    }
}
