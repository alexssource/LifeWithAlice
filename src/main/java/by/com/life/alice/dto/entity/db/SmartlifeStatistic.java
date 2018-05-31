package by.com.life.alice.dto.entity.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmartlifeStatistic {

    private Long id;

    private Date actionDate;

    private String userMSISDN;

    private String userAgentHeader;

    private String actionType;

    private String additionalInfo;
}
