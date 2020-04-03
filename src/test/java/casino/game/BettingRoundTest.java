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
    private Bet bet2 = mock(Bet.class);

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
    public void placeBetShouldReturnTrueAndAddedToPlacedBets(){
        //arrange

        //act
        boolean added = bettingRound.placeBet(bet);

        //assert
        assertTrue(added);
        assertTrue(bettingRound.getAllBetsMade().size() > 0);

    }

    @Test
    public void placeDuplicateBetShouldReturnFalseAndNotDuplicateBet(){
       //arrange

        //act
        bettingRound.placeBet(bet);
        boolean actual = bettingRound.placeBet(bet);

        //assert
        assertFalse(actual);
        assertEquals(1, bettingRound.getAllBetsMade().size());
    }


    @Test
    public void numberOfBetsMadeShouldReturnAmountOfBetsInBettingRound(){

    }

}