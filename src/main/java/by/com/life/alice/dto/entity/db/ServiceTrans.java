package by.com.life.alice.dto.entity.db;

import by.com.life.alice.dto.entity.Service;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class ServiceTrans extends Service implements Serializable {
    private String lang;
    private Language language;
    private Integer orderBy;
    private Set<ServiceParameter> paramsData;
    private Set<ServiceTag> tagsData;
    private Set<ServiceType> typesData;
    private Set<ServiceFeature> featuresData;
}
