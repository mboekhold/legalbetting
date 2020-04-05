package casino.bet;

import bettingauthorityAPI.BetTokenAuthority;
import casino.game.Game;
import casino.game.IGame;
import casino.game.NoCurrentRoundException;
import casino.gamingmachine.IGamingMachine;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

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

    @Test
    public void acceptValidBetsWhenMaxBetsHasBeenReachedShouldReturnFalse() throws NoCurrentRoundException {
        //act
        //Max bets is 3
        Bet bet1 = Mockito.mock(Bet.class);
        Bet bet2 = Mockito.mock(Bet.class);
        Bet bet3 = Mockito.mock(Bet.class);
        Bet bet4 = Mockito.mock(Bet.class);
        //arrange
        game.startBettingRound();
        boolean bet1Result = game.acceptBet(bet1, gamingMachine);
        boolean bet2Result = game.acceptBet(bet2, gamingMachine);
        boolean bet3Result = game.acceptBet(bet3, gamingMachine);
        boolean bet4Result = game.acceptBet(bet4, gamingMachine);
        //assert
        Assert.assertTrue(bet1Result);
        Assert.assertTrue(bet2Result);
        Assert.assertTrue(bet3Result);
        Assert.assertFalse(bet4Result);
    }

    @Test
    public void determineWinnerShouldOnlyBeOneBetPerBettingRound() throws NoCurrentRoundException {
        //arrange
        Bet bet1 = Mockito.mock(Bet.class);
        Bet bet2 = Mockito.mock(Bet.class);
        Bet bet3 = Mockito.mock(Bet.class);
        BetTokenAuthority betTokenAuthority = Mockito.mock(BetTokenAuthority.class);

        //act
        when(betTokenAuthority.getRandomInteger(game.getCurrentBettingRound().getBetToken())).thenReturn(1);
        game.startBettingRound();
        game.acceptBet(bet1, gamingMachine);
        game.acceptBet(bet2, gamingMachine);
        game.acceptBet(bet3, gamingMachine);
        game.endBettingRound();
        BetResult betResult = game.determineWinner(betTokenAuthority.getRandomInteger
                (game.getCurrentBettingRound().getBetToken()), game.getCurrentBettingRound().getAllBetsMade());
        //assert
        int counter = 0;
        Assert.assertTrue(betResult.getWinningBet() == bet1);
    }




}
