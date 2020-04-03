package casino.idbuilder;


/**
 * Factory for creation of GeneralID objects.
 * creation of the right object is done by specifying the type to create
 * the specified type is case insensitive
 *
 * when the type is not present, null is returned.
 */
public class IDBuilder {

    public BettingRoundID buildBettingRoundId(){
        return null;
    }

    public CardID buildCardID(){
        return new CardID();
    }

    public GamingMachineID buildMachineId(){
        return null;
    }

    public BetID buildBetId(){
        return null;
    }
}
