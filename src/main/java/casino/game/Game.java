package casino.game;

import bettingauthorityAPI.BetLoggingAuthority;
import bettingauthorityAPI.BetToken;
import bettingauthorityAPI.BettingAuthority;
import bettingauthorityAPI.IBetLoggingAuthority;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.gamingmachine.IGamingMachine;
import casino.idbuilder.BettingRoundID;
import casino.idbuilder.IDBuilder;

import java.util.HashSet;
import java.util.Set;

public class Game extends AbstractGame{

    Set<IBettingRound> bettingRounds;
    private BettingAuthority bettingAuthority;
    private IBetLoggingAuthority betLoggingAuthority;
    private boolean isBettingRoundStarted;
    private IBettingRound currentBettingRound;
    private IDBuilder builder;
    private BetResult betResult;

    public BetResult getBetResult() {
        return betResult;
    }

    public IBetLoggingAuthority getBetLoggingAuthority() {
        return betLoggingAuthority;
    }

    public void setBetLoggingAuthority(IBetLoggingAuthority betLoggingAuthority) {
        this.betLoggingAuthority = betLoggingAuthority;
    }

    public IBettingRound getCurrentBettingRound() {
        return currentBettingRound;
    }

    public Game() {
        bettingRounds = new HashSet<>();
        bettingAuthority = new BettingAuthority();
        betLoggingAuthority = new BetLoggingAuthority();
        isBettingRoundStarted = false;
        builder = new IDBuilder();
    }

    public int getAmountOfBettingRounds(){
        return bettingRounds.size();
    }

    @Override
    public void startBettingRound() {
        isBettingRoundStarted = true;
        BettingRoundID bettingRoundID = builder.buildBettingRoundId();
        BetToken betToken = bettingAuthority.getTokenAuthority().getBetToken(bettingRoundID);
        currentBettingRound = new BettingRound(bettingRoundID, betToken);
        bettingRounds.add(currentBettingRound);

        betLoggingAuthority.startBettingRound(this.currentBettingRound);
    }

    @Override
    public void endBettingRound() {
        isBettingRoundStarted = false;
        betLoggingAuthority.endBettingRound(currentBettingRound, betResult);
    }

    @Override
    public boolean isBettingRoundFinished() {
        return !isBettingRoundStarted;
    }

    @Override
    public int getMaxBetsPerRound() {
        return super.getMaxBetsPerRound();
    }

    @Override
    public void determineWinner() {
        super.determineWinner();
    }

    @Override
    public BetResult determineWinner(Integer randomWinValue, Set<Bet> bets) {
        int counter = 0;
        for(Bet b : bets){
            if (randomWinValue == counter) {
                this.betResult = new BetResult(b, b.getMoneyAmount());
                return betResult;
            }
            counter++;
        }
        return null;
    }

    @Override
    public boolean acceptBet(Bet bet, IGamingMachine gamingMachine) throws NoCurrentRoundException {
       if (isBettingRoundStarted && getMaxBetsPerRound() > currentBettingRound.numberOFBetsMade()){
           currentBettingRound.placeBet(bet);
           return true;
       }
       else if (!isBettingRoundStarted){
           throw new NoCurrentRoundException("Game has no active round");
       }
        return false;
    }

}
