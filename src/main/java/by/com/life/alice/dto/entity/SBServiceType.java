package by.com.life.alice.dto.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr.Muravjev on 20.02.2017.
 */
public enum SBServiceType {
    S_SHARED_100_MINUTES,
    S_SHARED_INTERNET_1_GB;

    public static SBServiceType fromString(String serviceType) {
        for (SBServiceType type : SBServiceType.values()) {
            if (type.name().equalsIgnoreCase(serviceType)) {
                return type;
            }
        }
        return null;
    }

    public static boolean isExists(String serviceType) {
        for (SBServiceType type : SBServiceType.values()) {
            if (type.name().equalsIgnoreCase(serviceType)) {
                return true;
            }
        }
        return false;
    }

    public static List<String> getValuesAsString() {
        ArrayList<String> list = new ArrayList<>();
        for (SBServiceType type : SBServiceType.values()) {
            list.add(type.name());
        }
        return list;
    }
}
