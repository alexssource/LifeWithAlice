package by.com.life.alice.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@ToString
public class AliceButtonDTO {
    private String title;
    private Object payload;
    private String url;
    private boolean hide;
}
