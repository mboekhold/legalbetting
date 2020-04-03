package casino.idbuilder;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class GeneralID {

    private String timeStamp;
    private String uniqueID;

    public GeneralID() {
        this.timeStamp = LocalDateTime.now().toString();
        this.uniqueID = UUID.randomUUID().toString();
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getUniqueID() {
        return uniqueID;
    }
}
