package by.com.life.alice.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONSharedBundleTariff {
    private String code;
    private String name;
    private String pictureUrl;
    private String descriptionUrl;
    private String enableTariffUrl;
    private Set<JSONTariffParameters> tariffParameters;
}
