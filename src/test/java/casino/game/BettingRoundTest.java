package casino.game;

import bettingauthorityAPI.BetToken;
import bettingauthorityAPI.BetTokenAuthority;
import casino.bet.Bet;
import casino.idbuilder.BettingRoundID;
import casino.idbuilder.IDBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BettingRoundTest {

    private BettingRoundID bettingRoundID = new IDBuilder().buildBettingRoundId();
    private IBettingRound bettingRound;
    private BetTokenAuthority betTokenAuthority = mock(BetTokenAuthority.class);
    private Bet bet = mock(Bet.class);

    @Before
    public void init(){
        when(betTokenAuthority.getBetToken(bettingRoundID)).thenReturn(new BetToken((bettingRoundID)));
        bettingRound = new BettingRound(bettingRoundID, betTokenAuthority.getBetToken(bettingRoundID));
    }

    @Test
    public void constructorShouldSetTheBettingRoundIdAndBetToken(){
        //arrange
        //act
        //assert
        assertNotNull(bettingRound.getBettingRoundID());
        assertNotNull(bettingRound.getBetToken());
        verify(betTokenAuthority).getBetToken(bettingRoundID);
    }

    @Test
    public void placeBetShouldAddBetToPlacedBets(){
        //arrange

        //act
        bettingRound.placeBet(bet);

        //assert
        assertTrue(bettingRound.getAllBetsMade().size() > 0);

    }

}