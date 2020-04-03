package casino.gamingmachine;

import casino.game.Game;
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
}
