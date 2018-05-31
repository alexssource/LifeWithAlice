package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Device implements Serializable {

    private Long id;

    private String name;

    private String imageUrl;

    private String redirectUrl;

    private boolean published;

    private Date dateFrom;

    private Date dateTo;

    private List<DeviceFeature> features;

    private List<DevicePrice> prices;

}
