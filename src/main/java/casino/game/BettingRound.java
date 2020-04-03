package casino.game;

import bettingauthorityAPI.BetToken;
import casino.bet.Bet;
import casino.idbuilder.BettingRoundID;

import java.util.HashSet;
import java.util.Set;

public class BettingRound implements IBettingRound {

    private BetToken betToken;
    private BettingRoundID bettingRoundID;
    private Set<Bet> bets;

    public BettingRound(BettingRoundID bettingRoundID, BetToken betToken) {
        this.bettingRoundID = bettingRoundID;
        this.betToken = betToken;
        this.bets = new HashSet<>();
    }




    @Override
    public BettingRoundID getBettingRoundID() {
        return bettingRoundID;
    }

    @Override
    public boolean placeBet(Bet bet) {
        return bets.add(bet);
    }

    @Override
    public Set<Bet> getAllBetsMade() {
        return (Set<Bet>) bets;
    }

    @Override
    public BetToken getBetToken() {
        return betToken;
    }

    @Override
    public int numberOFBetsMade() {
        return bets.size();
    }
}
