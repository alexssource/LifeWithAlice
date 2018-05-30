package by.com.life.alice.command;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AliceMarkupCommand {
    @JsonProperty("dangerous_context")
    private boolean dangerousContext;
}
