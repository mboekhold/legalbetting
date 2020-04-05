package casino.idbuilder;

import org.junit.Test;

import static org.junit.Assert.*;

public class IDBuilderTest {

    @Test
    public void buildIDTest_ShouldReturnValidGeneralID(){
        //arrange
        IDBuilder builder = new IDBuilder();
        //act
        CardID cardID = builder.buildCardID();
        //assert
        assertNotNull(cardID.getTimeStamp());
        assertNotNull(cardID.getUniqueID());
    }
}