package by.com.life.alice.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AliceMetaCommand {
    private String locale;
    private String timezone;

    @JsonProperty("client_id")
    private String clientId;
}
