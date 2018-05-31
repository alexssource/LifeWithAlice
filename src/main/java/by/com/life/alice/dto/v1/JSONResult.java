package by.com.life.alice.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Sergey Horonzhyn on 5/8/15.
 */
@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONResult implements Serializable {
    private String message;
    private String errCode;
    private boolean success;


    public JSONResult(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
