package casino.bet;

import casino.game.Game;
import casino.game.IGame;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    private Game game = new Game(12);

    @Test
    public void gameConstructorShouldSetTheInitialRoundAndFields(){
        //act

        //arrange
        int expectedBettingRounds = 1;
        int expectedMaxBets = 12;
        boolean expectedBettingRoundFinished = false;
        //assert

        Assert.assertEquals(expectedBettingRounds, game.getAmountOfBettingRounds());
        Assert.assertEquals(expectedMaxBets, game.getMaxBetsPerRound());
        Assert.assertEquals(expectedBettingRoundFinished, game.isBettingRoundFinished());
    }


}
