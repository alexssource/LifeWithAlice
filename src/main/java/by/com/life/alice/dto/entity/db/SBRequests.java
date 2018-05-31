package by.com.life.alice.dto.entity.db;

import by.com.life.alice.dto.entity.SBRequestStatus;
import by.com.life.alice.dto.entity.SBRequestType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SBRequests implements Serializable {

    private Long id;

    private String sender;

    private String recipient;

    private Date date;

    private SBRequestType requestType;

    private String value;

    private String description;

    private SBRequestStatus status;
}
