package by.com.life.alice.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONDevicePrice {
    private Long id;
    private String type;
    private BigDecimal value;
}
