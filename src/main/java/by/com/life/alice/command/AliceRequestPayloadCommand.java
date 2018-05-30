package by.com.life.alice.command;

import by.com.life.alice.domain.AliceInputType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AliceRequestPayloadCommand {
    private String command;

    @JsonProperty("original_utterance")
    private String originalUtterance;

    private AliceInputType type;
    private AliceMarkupCommand markup;
    private Object payload;
}
