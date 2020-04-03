package casino.cashier;

import casino.bet.Bet;
import casino.bet.MoneyAmount;
import casino.player.Player;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CashierTest {

    @Test
    public void addAmount_ValidCardAndAmount_MapSizeIsOne() throws BetNotExceptedException{
        Cashier cashier = new Cashier();
        Card card = mock(Card.class);
        MoneyAmount moneyAmount = mock(MoneyAmount.class);

        cashier.addAmount(card, moneyAmount);

        assertThat(cashier.moneyAmounts.size(), is(1));
    }
}
