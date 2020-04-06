package casino;

import casino.bet.Bet;
import casino.cashier.IPlayerCard;
import casino.game.Game;
import casino.game.IGame;
import casino.idbuilder.IDBuilder;
import org.junit.Test;
import org.mockito.Mockito;

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


    @Test //Our Assumption is that a card is invalid if the CardID has not been set
    public void invalidCardCheckBetShouldReturnFalse(){
        //arrange
        //act
        boolean actual = casino.checkIfBetIsValid(playerCard, bet);
        //assert
        assertFalse(actual);
    }


    @Test //Our Assumption is that a card is valid if the CardID has been set
    public void validCardCheckBetShouldReturnTrue(){
        //arrange
        //act
        when(playerCard.getCardID()).thenReturn(new IDBuilder().buildCardID());
        boolean actual = casino.checkIfBetIsValid(playerCard, bet);
        //assert
        assertTrue(actual);
    }

    @Test //Our Assumption is that a card is valid if the CardID has been set
    public void CheckIfTheCasinoCanRunMoreThanOneGames(){
        //arrange
        IGame game1 = Mockito.mock(IGame.class);
        IGame game2 = Mockito.mock(IGame.class);
        IGame game3 = Mockito.mock(IGame.class);
        casino.addGame("Gardenscapes", game1);
        casino.addGame("Subway Surfers", game2);
        casino.addGame("8 Ball Pool", game3);
        //act
        casino.getGame("Gardenscapes").startBettingRound();
        casino.getGame("Subway Surfers").startBettingRound();
        casino.getGame("8 Ball Pool").startBettingRound();
        //assert
        verify(game1).startBettingRound();
        verify(game2).startBettingRound();
        verify(game3).startBettingRound();
    }

}