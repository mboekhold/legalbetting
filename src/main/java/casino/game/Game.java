package casino.game;

import bettingauthorityAPI.BetToken;
import bettingauthorityAPI.BettingAuthority;
import casino.idbuilder.BettingRoundID;
import casino.idbuilder.IDBuilder;

import java.util.HashSet;
import java.util.Set;

public class Game extends AbstractGame{

    Set<IBettingRound> bettingRounds;
    private BettingAuthority bettingAuthority;


    public Game(int maxBetsPerRound) {
        super(maxBetsPerRound);
        bettingRounds = new HashSet<>();
        bettingAuthority = new BettingAuthority();
        IDBuilder builder = new IDBuilder();
        BettingRoundID bettingRoundID = builder.buildBettingRoundId();
        BetToken betToken = bettingAuthority.getTokenAuthority().getBetToken(bettingRoundID);
        bettingRounds.add(new BettingRound(bettingRoundID, betToken));
    }

    public int getAmountOfBettingRounds(){
        return bettingRounds.size();
    }

    @Override
    public void startBettingRound() {

    }
}
