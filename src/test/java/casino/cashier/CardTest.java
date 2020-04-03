package casino.cashier;

import casino.bet.BetID;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CardTest {

    @Test
    public void addBetID_ValidBetID_NumberOfBetIDsIsOne() {
        // Arrange
        Card card = new Card();
        BetID betID = mock(BetID.class);
        int AMOUNTOFBETS = 1;

        // Act
        card.addBetID(betID);

        // Assert
        assertThat(AMOUNTOFBETS, is(card.getNumberOfBetIDs()));
    }
}
