package casino.bet;

import casino.game.AbstractGame;
import casino.game.IGame;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class GameTest {

    @Test
    public void ConstructorShouldSetTheMaxAmountOfBetsPerRound(){
        //ARRANGE
        AbstractGame game = new AbstractGame(12);
        //ACT

        //ASSERT
        assertEquals(12, game.getMaxBetsPerRound());
    }



}
