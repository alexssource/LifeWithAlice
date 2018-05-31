package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.SBRequestStatus;
import by.com.life.alice.dto.entity.SBRequestType;
import by.com.life.alice.dto.entity.db.SBRequests;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Aleksandr.Muravjev on 15.02.2017.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONSBRequests implements Serializable {
    private Long id;
    private String sender;
    private String recipient;
    private Date date;
    private SBRequestType requestType;
    private String value;
    private String description;
    private SBRequestStatus status;

    public JSONSBRequests() {
    }

    public JSONSBRequests(SBRequests sbRequests) {
        this.id = sbRequests.getId();
        this.sender = sbRequests.getSender();
        this.recipient = sbRequests.getRecipient();
        this.date = sbRequests.getDate();
        this.requestType = sbRequests.getRequestType();
        this.value = sbRequests.getValue();
        this.description = sbRequests.getDescription();
        this.status = sbRequests.getStatus();
    }

    @Override
    public String toString() {
        return "JSONSBRequests{" +
                "id=" + id +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", date=" + date +
                ", requestType=" + requestType +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
