package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SharedBundleUserInf implements Serializable {

    private Long userIdFrom;

    private Long userIdTo;

    private String param;

    private String value;

    private Date lastModDate;
}
