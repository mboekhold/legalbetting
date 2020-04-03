package casino.game;

import casino.bet.Bet;
import casino.bet.BetResult;

import java.util.Set;

public class AbstractGame implements IGame, IGameRule {

    public AbstractGame(int maxBetsPerRound){

    }

    @Override
    public void startBettingRound() {

    }

    @Override
    public void determineWinner() {

    }

    @Override
    public boolean isBettingRoundFinished() {
        return false;
    }

    @Override
    public BetResult determineWinner(Integer randomWinValue, Set<Bet> bets) {
        return null;
    }

    @Override
    public int getMaxBetsPerRound() {
        return 0;
    }
}
