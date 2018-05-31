package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.db.ServiceTrans;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONServiceForSharedBundles {
    private String code;
    private String name;
    private String desc;
    private String price;

    public JSONServiceForSharedBundles(ServiceTrans service) {
        this.code = service.getCode();
        this.name = service.getName();
        this.desc = service.getDesc();
        service.getParamsData().stream()
                .filter(x -> x.getKey().equalsIgnoreCase("Цена пакета"))
                .findFirst()
                .ifPresent(x -> setPrice(x.getValue()));
    }
}
