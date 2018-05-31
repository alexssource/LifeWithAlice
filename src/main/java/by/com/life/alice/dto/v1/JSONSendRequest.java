package by.com.life.alice.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONSendRequest {
    private String receiverMsisdn;
    private String name;
    private String color;
    private String photoUrl;
    private Boolean sendNotifications;
}
