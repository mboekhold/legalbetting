package casino.bet;

import casino.game.Game;
import casino.game.IGame;
import casino.game.NoCurrentRoundException;
import casino.gamingmachine.IGamingMachine;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class GameTest {

    private Game game = new Game();
    private IGamingMachine gamingMachine = Mockito.mock(IGamingMachine.class);

    @Test
    public void gameConstructorShouldSetTheInitialRoundAndFields(){
        //act

        //arrange
        int expectedBettingRounds = 1;
        int expectedMaxBets = 12;
        //assert

        Assert.assertEquals(expectedBettingRounds, game.getAmountOfBettingRounds());
        Assert.assertEquals(expectedMaxBets, game.getMaxBetsPerRound());
        Assert.assertTrue(game.isBettingRoundFinished());
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

    @Test
    public void stopBettingRoundShouldSetTheBettingRoundFinishedToTrue(){
        //act

        //arrange
        game.startBettingRound();
        game.endBettingRound();
        //assert
        Assert.assertTrue(game.isBettingRoundFinished());
    }

    @Test
    public void acceptValidBetAfterGameIsStartedShouldReturnTrue() throws NoCurrentRoundException {
        //act
        Bet bet = Mockito.mock(Bet.class);
        //arrange
        game.startBettingRound();
        boolean result = game.acceptBet(bet, gamingMachine);
        //assert
        Assert.assertTrue(result);
    }

    @Test(expected = NoCurrentRoundException.class)
    public void acceptValidBetWhenGameIsNotStartedShouldThrowNoCurrentRoundException() throws NoCurrentRoundException {
        //act
        Bet bet = Mockito.mock(Bet.class);
        //arrange
        game.startBettingRound();
        game.endBettingRound();
        game.acceptBet(bet, gamingMachine);
        //assert
    }




}
