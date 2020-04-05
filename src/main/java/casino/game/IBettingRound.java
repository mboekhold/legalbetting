package casino.game;

import bettingauthorityAPI.BetToken;
import casino.bet.Bet;
import casino.idbuilder.BettingRoundID;

import java.util.Set;

public interface IBettingRound {
    BettingRoundID getBettingRoundID();

    /**
     * A gambler can only place one bet per betting round.
     * @param bet
     * @return
     */
    boolean placeBet(Bet bet);

    Set<Bet> getAllBetsMade();

    BetToken getBetToken();

    int numberOFBetsMade();
}
