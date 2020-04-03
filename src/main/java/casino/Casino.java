package casino;

import casino.bet.Bet;
import casino.cashier.IPlayerCard;
import casino.game.IGame;


public class Casino implements ICasino {



    @Override
    public void addGame(String gameName, IGame gameToAdd) {

    }

    @Override
    public IGame getGame(String name) {
        return null;
    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) {
        return false;
    }
}
