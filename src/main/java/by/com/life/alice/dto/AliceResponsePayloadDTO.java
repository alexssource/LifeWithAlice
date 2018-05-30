package by.com.life.alice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;


@Getter
@AllArgsConstructor
@ToString
public class AliceResponsePayloadDTO {
    private String text;
    private String tts;
    private List<AliceButtonDTO> buttons;

    @JsonProperty("end_session")
    private boolean endSession;
}
