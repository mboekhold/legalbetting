package casino;

import casino.game.IGame;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class CasinoTest {

    private IGame validGame = mock(IGame.class);
    @Test
    public void retrieveGameByNameShouldReturnValidGame(){
        //arrange
        ICasino casino = new Casino();

        //act
        String gameName = "candy crush";
        casino.addGame(gameName, validGame);
        IGame game = casino.getGame(gameName);

        //assert
        assertEquals(validGame, game);

    }
}