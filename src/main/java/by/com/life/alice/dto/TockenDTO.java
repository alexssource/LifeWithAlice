package by.com.life.alice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TockenDTO {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
}
