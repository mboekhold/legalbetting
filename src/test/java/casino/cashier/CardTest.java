package casino.cashier;

import casino.idbuilder.BetID;
import casino.idbuilder.IDBuilder;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class CardTest {
    Card card = new Card();
    @Test
    public void generateBetID_ValidBetID_NumberOfBetIDsIsOne() {
        // Arrange
        BetID betID = mock(BetID.class);
        int AMOUNTOFBETS = 1;

        // Act
        card.generateNewBetID();

        // Assert
        assertThat(AMOUNTOFBETS, is(card.getNumberOfBetIDs()));
    }

    @Test
    public void returnBetIDsAndClearCard_AddedOneBetToCard_BetIdSetIsSizeOne() {
        // Arrange
        BetID betID = mock(BetID.class);
        card.generateNewBetID();

        // Act
        Set<BetID> betIDs = card.returnBetIDsAndClearCard();
        // Assert
        assertThat(betIDs.size(), is(1));
    }

    @Test
    public void returnBetIDsAndClearCard_AddedOneBetToCard_BetIDsSizeResetToZero() {
        // Arrange
        BetID betID = mock(BetID.class);
        card.generateNewBetID();

        // Act
        Set<BetID> betIDs = card.returnBetIDsAndClearCard();
        // Assert
        assertThat(card.betIDs.size(), is(0));
    }

    @Test
    public void returnBetIdsShouldReturnNewSetOfBetIds(){
        Card card = new Card(new IDBuilder().buildCardID());

        Set<BetID> betIDS = card.returnBetIDs();

        assertThat(betIDS, is(new HashSet<BetID>()));
    }

}
