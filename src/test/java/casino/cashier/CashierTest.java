package casino.cashier;

import casino.bet.Bet;
import casino.player.Player;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;

public class CashierTest {

    @Test(expected = Test.None.class)
    public void checkIfBetIsValid_ValidPlayerAndBetParameter_ReturnTrue() throws BetNotExceptedException {
        // Arrange
        Cashier cashier = new Cashier();
        Card card = mock(Card.class);
        Bet bet = mock(Bet.class);
        boolean BETISVALID = true;

        // Act
        Boolean betStatus = cashier.checkIfBetIsValid(card, bet);

        // Assert
        assertThat(BETISVALID, is(betStatus));
    }
}
