package casino.game;

import bettingauthorityAPI.BetToken;
import bettingauthorityAPI.BettingAuthority;
import casino.bet.Bet;
import casino.gamingmachine.IGamingMachine;
import casino.idbuilder.BettingRoundID;
import casino.idbuilder.IDBuilder;

import java.util.HashSet;
import java.util.Set;

public class Game extends AbstractGame{

    Set<IBettingRound> bettingRounds;
    private BettingAuthority bettingAuthority;
    private boolean isBettingRoundStarted;


    public Game() {
        bettingRounds = new HashSet<>();
        bettingAuthority = new BettingAuthority();
        IDBuilder builder = new IDBuilder();
        BettingRoundID bettingRoundID = builder.buildBettingRoundId();
        BetToken betToken = bettingAuthority.getTokenAuthority().getBetToken(bettingRoundID);
        bettingRounds.add(new BettingRound(bettingRoundID, betToken));
        isBettingRoundStarted = false;
    }

    public int getAmountOfBettingRounds(){
        return bettingRounds.size();
    }

    @Override
    public void startBettingRound() {
        isBettingRoundStarted = true;
    }

    @Override
    public void endBettingRound() {
        isBettingRoundStarted = false;
    }

    @Override
    public boolean isBettingRoundFinished() {
        return !isBettingRoundStarted;
    }

    @Override
    public boolean acceptBet(Bet bet, IGamingMachine gamingMachine) throws NoCurrentRoundException {
        return false;
    }
}
