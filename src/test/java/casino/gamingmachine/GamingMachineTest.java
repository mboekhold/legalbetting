package casino.gamingmachine;

import casino.bet.Bet;
import casino.game.Game;
import casino.player.Player;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;

public class GamingMachineTest {

    @Test
    public void gamingMachineConstructor_GameIsSet() {
        // Arrange
        Game game = mock(Game.class);

        // Act
        GamingMachine gamingMachine = new GamingMachine(game);

        // Assert
        assertThat(game, is(gamingMachine.getGame()));
    }

    @Test(expected = Test.None.class)
    public void checkBet_ValidPlayerAndBetParameter_NoExceptionThrown() {
        // Arrange
        Game game = mock(Game.class);
        GamingMachine gamingMachine = new GamingMachine(game);
        Player player = mock(Player.class);
        Bet bet = mock(Bet.class);

        // Act
        gamingMachine.checkBet(player, bet);
    }
}
