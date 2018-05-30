package by.com.life.alice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class AliceResponseDTO {
    private AliceResponsePayloadDTO response;
    private AliceSessionDTO session;
    private String version;
}
