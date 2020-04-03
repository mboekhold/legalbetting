package casino.idbuilder;

public abstract class GeneralID {

    private String timeStamp;
    private String uniqueID;

    public GeneralID(String timeStamp, String uniqueID) {
        this.timeStamp = timeStamp;
        this.uniqueID = uniqueID;
    }

    public GeneralID() {
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getUniqueID() {
        return uniqueID;
    }
}
