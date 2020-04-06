package casino;

import casino.bet.Bet;
import casino.cashier.IPlayerCard;
import casino.game.IGame;

import java.util.HashMap;


public class Casino implements ICasino {
    private HashMap<String, IGame> games;

    public Casino() {
        this.games = new HashMap<>();
    }

    @Override
    public void addGame(String gameName, IGame gameToAdd) {
        games.put(gameName, gameToAdd);
    }

    @Override
    public IGame getGame(String name) throws GameNotFoundException {
        IGame toReturn = games.get(name);
        if (toReturn != null) {
            return toReturn;
        } else {
            throw new GameNotFoundException();
        }
    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) {
        return card.getCardID() != null;
    }
}
