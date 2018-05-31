package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SBServicesInfo implements Serializable {
    private Long id;

    private String name;

    private String imageUrl;

    private String redirectUrl;

    private String desc;

    private boolean enabled;

    private Date dateFrom;

    private Date dateTo;
}
