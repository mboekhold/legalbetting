package casino.gamingmachine;

import casino.bet.Bet;
import casino.cashier.BetNotExceptedException;
import casino.cashier.Cashier;
import casino.cashier.IPlayerCard;
import casino.game.IGame;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class GamingMachineTest {

    @Test
    public void gamingMachineConstructor_GameIsSet() {
        // Arrange
       IGame game = mock(IGame.class);

        // Act
        GamingMachine gamingMachine = new GamingMachine(game);

        // Assert
        assertThat(game, is(gamingMachine.getGame()));
    }

    @Test
    public void connectCard_ValidCard_CardFieldSet() {
        // Arrange
        IGame game = mock(IGame.class);
        IPlayerCard card = mock(IPlayerCard.class);
        GamingMachine gamingMachine = new GamingMachine(game);
        // Act
        gamingMachine.connectCard(card);
        // Assert
        assertThat(card, is(gamingMachine.getCard()));
    }

    @Test
    public void placeBet_ValidAmount_CashierCheckIfBetIsValidCAlled() throws NoPlayerCardException, BetNotExceptedException {
        // Arrange
        IGame game = mock(IGame.class);
        Cashier cashier = mock(Cashier.class);
        IPlayerCard card = mock(IPlayerCard.class);
        Bet bet = mock(Bet.class);
        GamingMachine gamingMachine = new GamingMachine(game);
        gamingMachine.connectCard(card);
        // Act
        gamingMachine.placeBet((long) -1.0);
        // Assert
        verify(cashier).checkIfBetIsValid(card, bet);
    }

}
