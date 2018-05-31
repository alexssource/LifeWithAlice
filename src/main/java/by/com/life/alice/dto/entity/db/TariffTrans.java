package by.com.life.alice.dto.entity.db;

import by.com.life.alice.dto.entity.Tariff;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class TariffTrans extends Tariff implements Serializable {
    private String lang;
    private Language language;
    private Integer orderBy;
    private boolean forSharedBundles;
    private String pictureUrl;
    private String descriptionUrl;
    private String enableTariffUrl;
    private Set<TariffParameter> paramsData;
    private Set<TariffTag> tagsData;
    private Set<TariffFeature> featuresData;
}
