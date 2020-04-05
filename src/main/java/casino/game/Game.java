package casino.game;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.gamingmachine.IGamingMachine;

import java.util.HashSet;
import java.util.Set;

public class Game extends AbstractGame{

    private Set<BettingRound> bettingRoundSet;
    private BettingRound currentBettingRound;

    public Game(int maxBetsPerRound) {
        super(maxBetsPerRound);
        bettingRoundSet = new HashSet<>();
        currentBettingRound = new BettingRound();
        bettingRoundSet.add(currentBettingRound);

    }

    public BettingRound GetCurrentBettingRound() {
        return this.currentBettingRound;
    }

    @Override
    public boolean acceptBet(Bet bet, IGamingMachine gamingMachine) throws NoCurrentRoundException {
//        BettingRound newBettingRound = new BettingRound();
//        bettingRoundSet.add(newBettingRound);
//        newBettingRound.placeBet(bet);
        currentBettingRound.placeBet(bet);

        return true;
    }

    @Override
    public BetResult determineWinner(Integer randomWinValue, Set<Bet> bets) {
        int counter = 0;
        for(Bet b : bets){
            if (randomWinValue == counter) {
                return new BetResult(b, b.getMoneyAmount());
            }
            counter++;
        }
        return null;
    }


}
