package by.com.life.alice.dto.v1;

import lombok.Data;

import java.util.Date;

@Data
public class JSONSharedBundleUserInf {
    private Long userIdFrom;
    private Long userIdTo;
    private Date lastModDate;
    private FieldData[] params;
}
