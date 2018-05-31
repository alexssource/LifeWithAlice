package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.Tariff;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONTariff implements Serializable {
   
	private String code;
    private String name;
    private String desc;
    private Double fee;
    private Map params;
    private List tags;
    private String cost;

    public JSONTariff(Tariff tariff) {
    	this.code = tariff.getCode();
        this.name = tariff.getName();
        this.desc = tariff.getDesc();
        this.fee = tariff.getFee();
        this.params = tariff.getParams();
        this.tags = tariff.getTags();
        this.cost = tariff.getCost();
    }

}
