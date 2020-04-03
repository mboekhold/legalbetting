package casino.game;

import bettingauthorityAPI.BetToken;
import bettingauthorityAPI.BetTokenAuthority;
import casino.bet.Bet;
import casino.idbuilder.BettingRoundID;

import java.util.Set;

public class BettingRound implements IBettingRound {

    private BetToken betToken;
    private BettingRoundID bettingRoundID;

    public BettingRound(BettingRoundID bettingRoundID, BetToken betToken) {
        this.bettingRoundID = bettingRoundID;
        this.betToken = betToken;
    }




    @Override
    public BettingRoundID getBettingRoundID() {
        return bettingRoundID;
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
        return betToken;
    }

    @Override
    public int numberOFBetsMade() {
        return 0;
    }
}
