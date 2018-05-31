package by.com.life.alice.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Set;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONTariffParameters {
    private Set<JSONTariffParametersProperty> tariffParametersProperties;
    private Integer parameterId;
    private String parameterType;
    private String key;
    private String value;
    private String valueExt;
    private Integer order;
}
