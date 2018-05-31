package by.com.life.alice.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONTariffParametersProperty {
    private Long id;
    private String propertyName;
    private String propertyValue;
}
