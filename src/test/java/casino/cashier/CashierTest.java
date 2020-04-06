package casino.cashier;

import bettingauthorityAPI.IBetLoggingAuthority;
import casino.bet.Bet;
import casino.idbuilder.BetID;
import casino.bet.MoneyAmount;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

public class CashierTest {
    private Cashier cashier = new Cashier();


    @Test
    public void addAmount_ValidCardAndAmount_MapSizeIsOne() {
        // Arrange
        IPlayerCard card = mock(IPlayerCard.class);
        MoneyAmount moneyAmount = mock(MoneyAmount.class);
        // Acr
        cashier.addAmount(card, moneyAmount);
        // Assert
        assertThat(cashier.moneyAmounts.size(), is(1));
    }

    @Test
    public void checkIfBetIsValid_ValidCardAndBet_ReturnTrue() throws BetNotExceptedException{
        IPlayerCard card = mock(IPlayerCard.class);
        Bet bet = mock(Bet.class);
        cashier.addAmount(card, mock(MoneyAmount.class));
        when(bet.getMoneyAmount()).thenReturn(mock(MoneyAmount.class));
        when(bet.getMoneyAmount().getAmountInCents()).thenReturn((long) 0.0);

        Boolean ValidBet = cashier.checkIfBetIsValid(card, bet);

        assertThat(ValidBet, is(true));
    }

    @Test(expected = BetNotExceptedException.class)
    public void checkIfBetIsValid_ValidCardAndBettTooHigh_ThrowException() throws BetNotExceptedException{
        IPlayerCard card = mock(IPlayerCard.class);
        Bet bet = mock(Bet.class);
        cashier.addAmount(card, mock(MoneyAmount.class));
        when(bet.getMoneyAmount()).thenReturn(mock(MoneyAmount.class));
        when(bet.getMoneyAmount().getAmountInCents()).thenReturn((long) 10.0);

        Boolean ValidBet = cashier.checkIfBetIsValid(card, bet);
    }

    @Test
    public void distributeGamblerCard_ReturnValidPlayerCard() {
        // Act
        IPlayerCard card = cashier.distributeGamblerCard();
        // Assert
        assertThat(card, is(IPlayerCard.class));
    }

    @Test
    public void returnGamblerCard_returnBetIDsAndClearCardCalled() {
        IPlayerCard card = mock(IPlayerCard.class);
        // Act
        cashier.returnGamblerCard(card);

        // Assert
        verify(card).returnBetIDsAndClearCard();
    }

    @Test
    public void returnGamblerCard_BetIDsAreLoggedBetIDsSizeIsOne() {
        IPlayerCard card = mock(IPlayerCard.class);
        Set<BetID> BetIds = new HashSet<>();
        BetIds.add(new BetID(new UUID(123,123)));
        when(card.returnBetIDsAndClearCard()).thenReturn(BetIds);
        // Act
        cashier.returnGamblerCard(card);

        // Assert
        assertThat(cashier.getLogsSize(), is(1));
    }

    @Test
    public void returnGamblerCard_ClearAllMoneyAmountsLinkedToCardInHashMap() {
        IPlayerCard card = mock(IPlayerCard.class);
        cashier.addAmount(card, new MoneyAmount(123));

        // Act
        cashier.returnGamblerCard(card);

        // Assert
        assertThat(cashier.getAmountOfMoneyOnCard(card), is((long) 0));
    }

}