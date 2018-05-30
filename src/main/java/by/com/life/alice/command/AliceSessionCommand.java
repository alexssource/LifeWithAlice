package by.com.life.alice.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AliceSessionCommand {

    @JsonProperty("new")
    private boolean newSession;

    @JsonProperty("message_id")
    private Long messageId;

    @JsonProperty("session_id")
    private String sessionId;

    @JsonProperty("skill_id")
    private String skillId;

    @JsonProperty("user_id")
    private String userId;
}
