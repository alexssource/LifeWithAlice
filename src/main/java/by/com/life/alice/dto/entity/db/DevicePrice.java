package by.com.life.alice.dto.entity.db;

import by.com.life.alice.dto.entity.PriceType;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class DevicePrice implements Serializable {

    private Long id;

    private PriceType type;

    private BigDecimal value;

}
