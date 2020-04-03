package casino.game;

import casino.idbuilder.BettingRoundID;
import casino.idbuilder.IDBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class BettingRoundTest {

    @Test
    public void bettingRoundConstructorShouldSetTheBettingRoundId(){
        //arrange
        BettingRoundID bettingRoundID;
        BettingRound bettingRound;
        //act
        bettingRoundID = new IDBuilder().buildBettingRoundId();
        bettingRound = new BettingRound(bettingRoundID);
        //assert
        assertNotNull(bettingRound.getBettingRoundID());
    }
}