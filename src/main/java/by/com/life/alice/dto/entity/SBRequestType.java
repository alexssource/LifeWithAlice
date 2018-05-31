package by.com.life.alice.dto.entity;

/**
 * Created by Aleksandr.Muravjev on 15.02.2017.
 */
public enum SBRequestType {
    MB,
    MIN,
    RUB,
    MESSAGE;

    public static SBRequestType fromString(String value) {
        for (SBRequestType type : SBRequestType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }
        return null;
    }
}
