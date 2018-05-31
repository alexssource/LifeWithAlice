package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.db.LPHistoryEvent;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * Created by Aleksey.Shitikov on 26.04.2017.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONLPHistoryEvent implements Serializable {

    private static final long serialVersionUID = 5838049980560524314L;
    // format: DD.MM.YY HH:MM:SS
    private String eventDate;

    private String eventType;

    private Integer amount;

    // format: DD.MM.YY HH:MM:SS
    private String validFrom;

    // format: DD.MM.YY HH:MM:SS
    private String validTo;

    private String description;

    public JSONLPHistoryEvent(LPHistoryEvent lpHistoryEvent) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd.MM.yyyy hh:MM:ss");
        this.eventDate = sdf.format(lpHistoryEvent.getEventDate());
        this.eventType = lpHistoryEvent.getEventType();
        this.amount = lpHistoryEvent.getAmount() == null ? 0 : lpHistoryEvent.getAmount().intValue();
        if (lpHistoryEvent.getDateFrom() != null) {
            this.validFrom = sdf.format(lpHistoryEvent.getDateFrom());
        }
        if (lpHistoryEvent.getDateTo() != null) {
            this.validTo = sdf.format(lpHistoryEvent.getDateTo());
        }
        this.description = lpHistoryEvent.getDescription();
    }

}
