package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.Pocket;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class JSONPocket {
    public JSONPocket(Pocket pocket) {
        this.code = pocket.getCode();
        this.start = pocket.getStart();
        this.end = pocket.getEnd();
        this.value = pocket.getValue();
    }
    private String code;
    private Timestamp start;
    private Timestamp end;
    private Double value;
}
