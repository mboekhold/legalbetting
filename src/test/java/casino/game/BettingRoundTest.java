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
    private BetTokenAuthority betTokenAuthority = mock(BetTokenAuthority.class);
    private Bet bet = mock(Bet.class);


    @Test
    public void constructorShouldSetTheBettingRoundIdAndBetToken(){
        //arrange
        when(betTokenAuthority.getBetToken(bettingRoundID)).thenReturn(new BetToken((bettingRoundID)));
        IBettingRound bettingRound = new BettingRound(bettingRoundID, betTokenAuthority.getBetToken(bettingRoundID));
        //act
        //assert
        assertNotNull(bettingRound.getBettingRoundID());
        assertNotNull(bettingRound.getBetToken());
        verify(betTokenAuthority).getBetToken(bettingRoundID);
    }

    @Test
    public void placeBetShouldAddBetToPlacedBets(){
        //arrange
        IBettingRound bettingRound = new BettingRound(bettingRoundID, betTokenAuthority.getBetToken(bettingRoundID));

        //act
        bettingRound.placeBet(bet);

        //assert
        assertTrue(bettingRound.getAllBetsMade().size() > 0);

    }

}