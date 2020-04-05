package casino.bet;

import casino.game.Game;
import casino.game.IGame;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

    private Game game = new Game(12);

    @Test
    public void gameConstructorShouldSetTheInitialRound(){
        //act

        //arrange
        int expectedBettingRounds = 1;
        //assert

        Assert.assertEquals(expectedBettingRounds, game.getAmountBettingRounds());
    }

}
