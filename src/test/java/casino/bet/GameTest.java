package casino.bet;

import bettingauthorityAPI.BetToken;
import bettingauthorityAPI.BetTokenAuthority;
import casino.game.AbstractGame;
import casino.game.Game;
import casino.game.IBettingRound;
import casino.game.IGame;
import casino.gamingmachine.IGamingMachine;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class GameTest {

    AbstractGame abstractGame;
    Game game;
    private int mockMaxBetsPerRound = 12;
    private int mockMoneyAmount = 5000;

    @Test //Test that a game can be created with maximum bets per round
    public void ConstructorShouldSetTheMaxAmountOfBetsPerRound() {
        //ARRANGE
        AbstractGame abstractGame = new AbstractGame(mockMaxBetsPerRound);
        //ACT

        //ASSERT
        assertEquals(mockMaxBetsPerRound, abstractGame.getMaxBetsPerRound());
    }

    @Test //Test if the new betting round has been created
    public void NewBettingRoundHasBeenCreated() {
        //ARRANGE
        game = new Game(mockMaxBetsPerRound);
        //ACT
        game.startBettingRound();
        //ASSERT
        assertFalse(game.isBettingRoundFinished());
    }

    @Test //Test which player has won a betting round
    public void DetermineWinnerIsOnlyOnePlayer() {
        //ARRANGE
        game = new Game(mockMaxBetsPerRound);
        BetID betID1 = new BetID();
        BetID betID2 = new BetID();
        BetID betID3 = new BetID();
        MoneyAmount moneyAmount = new MoneyAmount(mockMoneyAmount);

        Set<Bet> bets = new HashSet<Bet>();
        Bet betFromPlayer1 = new Bet(betID1, moneyAmount);
        Bet betFromPlayer2 = new Bet(betID2, moneyAmount);
        Bet betFromPlayer3 = new Bet(betID3, moneyAmount);

        BetTokenAuthority betTokenAuthority = new BetTokenAuthority();//mock (BetTokenAuthority.class);
        IBettingRound iBettingRound = mock(IBettingRound.class);
        BetToken betToken = new BetToken(iBettingRound.getBettingRoundID());

        //ACT
        bets.add(betFromPlayer1);
        bets.add(betFromPlayer2);
        bets.add(betFromPlayer3);
        BetResult betResult = game.determineWinner(betTokenAuthority.getRandomInteger(betToken), bets);
        Bet winningBet = betResult.getWinningBet();
        //ASSERT
        int counter = 0;
        if (winningBet == betFromPlayer1) {
            counter ++;
        } else if (winningBet == betFromPlayer2) {
            counter ++;
        } else if (winningBet == betFromPlayer3) {
            counter ++;
        }
        assertEquals(1, counter);

    }

}
