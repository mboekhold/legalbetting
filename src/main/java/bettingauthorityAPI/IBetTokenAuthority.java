package bettingauthorityAPI;

import casino.idbuilder.BettingRoundID;

public interface IBetTokenAuthority {
    BetToken getBetToken(BettingRoundID bettingRoundID);

    Integer getRandomInteger(BetToken betToken);
}
