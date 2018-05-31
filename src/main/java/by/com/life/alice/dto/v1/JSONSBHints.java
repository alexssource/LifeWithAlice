package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.db.SBHints;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by Sergey Horonzhyn on 5/8/15.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONSBHints {
    private String key;
    private String description;

    public JSONSBHints(SBHints hint) {
        this.key = hint.getKey();
        this.description = hint.getDescription();
    }
}
