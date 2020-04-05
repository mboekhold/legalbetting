package casino.bet;

import casino.game.AbstractGame;
import casino.game.IBettingRound;
import casino.game.IGame;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.assertEquals;

public class GameTest {

    AbstractGame game;

    @Test //Test that a game can be created with maximum bets per round
    public void ConstructorShouldSetTheMaxAmountOfBetsPerRound() {
        //ARRANGE
        AbstractGame game = new AbstractGame(12);
        //ACT

        //ASSERT
        assertEquals(12, game.getMaxBetsPerRound());
    }

    @Test //Test if the new betting round has been created
    public void NewBettingRoundHasBeenCreated() {
        //ARRANGE
        AbstractGame game = mock(AbstractGame.class);
        //ACT

        game.startBettingRound();
        //ASSERT
        verify(game).startBettingRound();
        assertTrue(game.isBettingRoundFinished());
    }

}
