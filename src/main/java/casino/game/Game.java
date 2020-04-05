package casino.game;

import casino.bet.Bet;
import casino.gamingmachine.IGamingMachine;

import java.util.HashSet;
import java.util.Set;

public class Game extends AbstractGame{
    private Set<IBettingRound> bettingRoundSet;

    public Game(int maxBetsPerRound) {
        super(maxBetsPerRound);
        bettingRoundSet = new HashSet<>();

    }

    @Override
    public boolean acceptBet(Bet bet, IGamingMachine gamingMachine) throws NoCurrentRoundException {
        return false;
    }


}
