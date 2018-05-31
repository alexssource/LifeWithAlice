package by.com.life.alice.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONLightDevice {
    protected Long id;

    protected String name;

    protected List<JSONDeviceFeature> features;

    protected List<JSONDevicePrice> prices;

    protected String imageUrl;

    protected String redirectUrl;

}
