package by.com.life.alice.dto.entity.db;

import lombok.Data;

@Data
public abstract class AbstractFeature {

    private String featureId;
    private String key;
    private String value;

    private Feature feature;
}
