package by.com.life.alice.dto.entity;

/**
 * Created by Aleksandr.Muravjev on 15.02.2017.
 */
public enum SBRequestStatus {
    UNREAD,
    READED;

    public static SBRequestStatus fromString(String value) {
        for (SBRequestStatus type : SBRequestStatus.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
