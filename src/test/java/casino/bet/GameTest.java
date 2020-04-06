package casino.bet;

import bettingauthorityAPI.BetTokenAuthority;
import bettingauthorityAPI.IBetLoggingAuthority;
import casino.game.Game;
import casino.game.IBettingRound;
import casino.game.IGame;
import casino.game.NoCurrentRoundException;
import casino.gamingmachine.IGamingMachine;
import casino.idbuilder.BetID;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {

    private Game game = new Game();
    private IGamingMachine gamingMachine = Mockito.mock(IGamingMachine.class);

    @Test
    public void gameConstructorShouldSetTheInitialRoundAndFields(){
        //act

        //arrange
        //assert
        Assert.assertTrue(game.getMaxBetsPerRound() > 0);
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
        Bet bet1 = new Bet(new BetID(new UUID(123, 123)), new MoneyAmount(5000));
        Bet bet2 = new Bet(new BetID(new UUID(456, 456)), new MoneyAmount(5000));
        Bet bet3 = new Bet(new BetID(new UUID(789, 789)), new MoneyAmount(5000));
        BetTokenAuthority betTokenAuthority = Mockito.mock(BetTokenAuthority.class);

        //act
        game.startBettingRound();
        when(betTokenAuthority.getRandomInteger(game.getCurrentBettingRound().getBetToken())).thenReturn(1);
        game.acceptBet(bet1, gamingMachine);
        game.acceptBet(bet2, gamingMachine);
        game.acceptBet(bet3, gamingMachine);
        game.endBettingRound();
        BetResult betResult = game.determineWinner(betTokenAuthority.getRandomInteger
                (game.getCurrentBettingRound().getBetToken()), game.getCurrentBettingRound().getAllBetsMade());
        //assert
        Assert.assertThat(betResult.getWinningBet(), is(bet2));
    }

    @Test
    public void checkIfBetLoggingAuthorityHasLoggedTheStartOfABettingRound() {
        //arrange
        IBetLoggingAuthority iBetLoggingAuthority = Mockito.mock(IBetLoggingAuthority.class);

        //act
        game.setBetLoggingAuthority(iBetLoggingAuthority);
        game.startBettingRound();
        IBettingRound iBettingRound = game.getCurrentBettingRound();
        //assert
        verify(iBetLoggingAuthority).startBettingRound(iBettingRound);
    }




}
