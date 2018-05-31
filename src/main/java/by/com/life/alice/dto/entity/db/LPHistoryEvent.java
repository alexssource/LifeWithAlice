package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Aleksey.Shitikov on 27.04.2017.
 */
@Data
public class LPHistoryEvent {

    private String id;

    private Long accountId;

    private String msisdn;

    private Date eventDate;

    private BigDecimal amount;

    private String eventType;

    private String description;

    private Date dateFrom;

    private Date dateTo;

}
