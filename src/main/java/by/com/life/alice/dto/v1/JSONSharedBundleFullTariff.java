package by.com.life.alice.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONSharedBundleFullTariff extends JSONSharedBundleTariff{
    private String description;
}
