package casino.game;

import casino.bet.Bet;
import casino.bet.BetResult;

import java.util.Set;

public class AbstractGame implements IGame, IGameRule {

    private int maxBetsPerRound;
    private boolean isBettingRoundStarted;

    public AbstractGame(int maxBetsPerRound){
        this.maxBetsPerRound = maxBetsPerRound;
        isBettingRoundStarted = false;
    }

    @Override
    public void startBettingRound() {
        this.isBettingRoundStarted = true;
    }

    @Override
    public void determineWinner() {

    }

    @Override
    public boolean isBettingRoundFinished() {
        return isBettingRoundStarted;
    }

    @Override
    public BetResult determineWinner(Integer randomWinValue, Set<Bet> bets) {
        return null;
    }

    @Override
    public int getMaxBetsPerRound() {
        return maxBetsPerRound;
    }
}
