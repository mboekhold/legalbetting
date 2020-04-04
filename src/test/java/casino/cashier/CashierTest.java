package casino.cashier;

import casino.bet.Bet;
import casino.bet.MoneyAmount;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CashierTest {

    @Test
    public void addAmount_ValidCardAndAmount_MapSizeIsOne() {
        // Arrange
        Cashier cashier = new Cashier();
        Card card = mock(Card.class);
        MoneyAmount moneyAmount = mock(MoneyAmount.class);
        // Acr
        cashier.addAmount(card, moneyAmount);
        // Assert
        assertThat(cashier.moneyAmounts.size(), is(1));
    }

    @Test
    public void checkIfBetIsValid_ValidCardAndBet_ReturnTrue() throws BetNotExceptedException{
        Cashier cashier = new Cashier();
        Card card = mock(Card.class);
        Bet bet = mock(Bet.class);
        cashier.addAmount(card, mock(MoneyAmount.class));
        when(bet.getMoneyAmount()).thenReturn(mock(MoneyAmount.class));
        when(bet.getMoneyAmount().getAmountInCents()).thenReturn((long) 0.0);

        Boolean ValidBet = cashier.checkIfBetIsValid(card, bet);

        assertThat(ValidBet, is(true));
    }

    @Test(expected = BetNotExceptedException.class)
    public void checkIfBetIsValid_ValidCardAndBettTooHigh_ThrowException() throws BetNotExceptedException{
        Cashier cashier = new Cashier();
        Card card = mock(Card.class);
        Bet bet = mock(Bet.class);
        cashier.addAmount(card, mock(MoneyAmount.class));
        when(bet.getMoneyAmount()).thenReturn(mock(MoneyAmount.class));
        when(bet.getMoneyAmount().getAmountInCents()).thenReturn((long) 10.0);

        Boolean ValidBet = cashier.checkIfBetIsValid(card, bet);
    }

    @Test
    public void distributeGamblerCard_ReturnValidPlayerCard() {
        // Arrange
        Cashier cashier = new Cashier();

        // Act
        IPlayerCard card = cashier.distributeGamblerCard();
        // Assert
        assertThat(card, is(IPlayerCard.class));
    }
}
