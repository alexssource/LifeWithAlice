package by.com.life.alice.dto.entity;

public enum SBHintsRoles {
    AUTHORIZED,
    UNAUTHORIZED;

    public static SBHintsRoles fromString(String value) {
        for (SBHintsRoles type : SBHintsRoles.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return type;
            }
        }

        return null;
    }
}
