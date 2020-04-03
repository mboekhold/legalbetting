package casino;

import casino.bet.Bet;
import casino.cashier.IPlayerCard;
import casino.game.IGame;
import casino.idbuilder.IDBuilder;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class CasinoTest {

    private IGame validGame = mock(IGame.class);
    private Bet bet = mock(Bet.class);
    private IPlayerCard playerCard = mock(IPlayerCard.class);
    private ICasino casino = new Casino();

    @Test
    public void retrieveGameByNameShouldReturnValidGame(){
        //arrange

        //act
        String gameName = "candy crush";
        casino.addGame(gameName, validGame);
        IGame game = casino.getGame(gameName);

        //assert
        assertEquals(validGame, game);

    }

    //Our Assumption is that a card is invalid if the CardID has not been set
    @Test
    public void invalidCardCheckBetShouldReturnFalse(){
        //arrange

        //act
        boolean actual = casino.checkIfBetIsValid(playerCard, bet);
        //assert
        assertFalse(actual);
    }

    //Our Assumption is that a card is valid if the CardID has been set
    @Test
    public void validCardCheckBetShouldReturnTrue(){
        //arrange

        //act
        when(playerCard.getCardID()).thenReturn(new IDBuilder().buildCardID());
        boolean actual = casino.checkIfBetIsValid(playerCard, bet);
        //assert
        assertTrue(actual);
    }
}