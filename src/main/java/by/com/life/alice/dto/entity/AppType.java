package by.com.life.alice.dto.entity;

public enum AppType {
    MOBILE_APP,
    WEB_APP;

    public static AppType fromString(String value) {
        for (AppType type : AppType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }

        return null;
    }
}
