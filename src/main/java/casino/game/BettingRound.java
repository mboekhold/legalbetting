package casino.game;

import bettingauthorityAPI.BetToken;
import bettingauthorityAPI.BettingRoundID;
import casino.bet.Bet;

import java.util.Set;

public class BettingRound implements IBettingRound {


    public BettingRound() {
    }


    @Override
    public BettingRoundID getBettingRoundID() {
        return null;
    }

    @Override
    public boolean placeBet(Bet bet) {
        return false;
    }

    @Override
    public Set<Bet> getAllBetsMade() {
        return null;
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
