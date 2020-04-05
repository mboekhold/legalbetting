package casino.game;

import bettingauthorityAPI.BetToken;
import bettingauthorityAPI.BettingRoundID;
import casino.bet.Bet;

import java.util.HashSet;
import java.util.Set;

public class BettingRound implements IBettingRound {
    private BettingRoundID bettingRoundID;
    private Set<Bet> bets;

    public BettingRound() {
        bettingRoundID = new BettingRoundID();
        bets = new HashSet<>();
    }

    @Override
    public BettingRoundID getBettingRoundID() {
        return bettingRoundID;
    }

    @Override
    public boolean placeBet(Bet bet) {
        this.bets.add(bet);
        return true;
    }

    @Override
    public Set<Bet> getAllBetsMade() {
        return this.bets;
    }

    @Override
    public BetToken getBetToken() {
        return null;
    }

    @Override
    public int numberOFBetsMade() {
        return 0;
    }
}
