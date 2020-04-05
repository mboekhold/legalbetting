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
        //assert

        Assert.assertEquals(expectedBettingRounds, game.getAmountOfBettingRounds());
        Assert.assertEquals(expectedMaxBets, game.getMaxBetsPerRound());
        Assert.assertFalse(game.isBettingRoundFinished());
    }

    @Test
    public void startRoundShouldSetIsBettingRoundFinishedToFalse(){
        //We assume games will automatically start with on the first round
        //act

        //arrange
        game.startBettingRound();

        //assert
        Assert.assertFalse(game.isBettingRoundFinished());
    }




}
