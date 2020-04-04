package casino.gamingmachine;

import casino.bet.Bet;
import casino.bet.BetID;
import casino.bet.MoneyAmount;
import casino.cashier.BetNotExceptedException;
import casino.cashier.Cashier;
import casino.cashier.ICashier;
import casino.cashier.IPlayerCard;
import casino.game.IGame;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class GamingMachineTest {

    @Test
    public void gamingMachineConstructor_GameIsSet() {
        // Arrange
        IGame game = mock(IGame.class);
        ICashier cashier = mock(Cashier.class);
        // Act
        GamingMachine gamingMachine = new GamingMachine(game, cashier);

        // Assert
        assertThat(game, is(gamingMachine.getGame()));
    }

    @Test
    public void connectCard_ValidCard_CardFieldSet() {
        // Arrange
        IGame game = mock(IGame.class);
        IPlayerCard card = mock(IPlayerCard.class);
        ICashier cashier = mock(Cashier.class);
        GamingMachine gamingMachine = new GamingMachine(game, cashier);
        // Act
        gamingMachine.connectCard(card);
        // Assert
        assertThat(card, is(gamingMachine.getCard()));
    }

    @Test
    public void placeBet_ValidAmount_CashierCheckIfBetIsValidCalled() throws NoPlayerCardException, BetNotExceptedException {
        // Arrange
        IGame game = mock(IGame.class);
        Cashier cashier = mock(Cashier.class);
        IPlayerCard card = mock(IPlayerCard.class);
        Bet bet =  new Bet(new BetID(new UUID(123,123)), new MoneyAmount((long) -1.0));
        GamingMachine gamingMachine = new GamingMachine(game, cashier);
        gamingMachine.connectCard(card);
        // Act
        gamingMachine.placeBet((long) -1.0);
        // Assert
        verify(cashier).checkIfBetIsValid(card, bet);
    }

    @Test(expected = NoPlayerCardException.class)
    public void placeBet_NoPlayerCard_NoPlayerCardException() throws NoPlayerCardException {
        // Arrange
        IGame game = mock(IGame.class);
        IPlayerCard card = mock(IPlayerCard.class);
        ICashier cashier = mock(Cashier.class);
        GamingMachine gamingMachine = new GamingMachine(game, cashier);
        // Act
        gamingMachine.placeBet((long) -1.0);
    }

}
