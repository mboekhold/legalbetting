package casino.game;

import bettingauthorityAPI.BetToken;
import bettingauthorityAPI.BettingAuthority;
import casino.idbuilder.BettingRoundID;
import casino.idbuilder.IDBuilder;

import java.util.HashSet;
import java.util.Set;

public class Game extends AbstractGame{

    Set<BettingRound> bettingRounds;
    public Game(int maxBetsPerRound) {
        super(maxBetsPerRound);
        bettingRounds = new HashSet<>();
    }

    public int getAmountBettingRounds() {
        return 0;
    }
}
