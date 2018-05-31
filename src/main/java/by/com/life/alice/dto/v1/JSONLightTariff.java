package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.Tariff;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class JSONLightTariff implements Serializable {

	private String code;
    private Double fee;

    public JSONLightTariff(Tariff tariff) {
    	this.code = tariff.getCode();
        this.fee = tariff.getFee();
    }
}