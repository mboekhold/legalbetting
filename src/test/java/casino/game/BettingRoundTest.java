package casino.game;

import casino.idbuilder.BettingRoundID;
import casino.idbuilder.IDBuilder;
import org.junit.Test;

import static org.junit.Assert.*;

public class BettingRoundTest {

    private BettingRoundID bettingRoundID = new IDBuilder().buildBettingRoundId();
    private IBettingRound bettingRound = new BettingRound(bettingRoundID);

    @Test
    public void constructorShouldSetTheBettingRoundId(){
        //arrange
        //act
        //assert
        assertNotNull(bettingRound.getBettingRoundID());
    }

    @Test
    public void constructorShouldSetTheGamblingToken(){
        //arrange

        //act
        assertNotNull(bettingRound.getBetToken());
        //assert
    }
}