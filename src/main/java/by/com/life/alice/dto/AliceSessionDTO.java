package by.com.life.alice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@ToString
public class AliceSessionDTO {
    @JsonProperty("session_id")
    private String sessionId;

    @JsonProperty("message_id")
    private Long messageId;

    @JsonProperty("user_id")
    private String userId;
}
