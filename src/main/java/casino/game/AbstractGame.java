package casino.game;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.gamingmachine.IGamingMachine;

import java.util.HashSet;
import java.util.Set;

public class AbstractGame implements IGame, IGameRule {




    public AbstractGame(){

    }

    @Override
    public void startBettingRound() {

    }

    @Override
    public void endBettingRound() {

    }

    @Override
    public boolean acceptBet(Bet bet, IGamingMachine gamingMachine) throws NoCurrentRoundException {
        return false;
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
        return 3;
    }
}
