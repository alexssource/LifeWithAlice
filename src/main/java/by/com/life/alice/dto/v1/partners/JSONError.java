package by.com.life.alice.dto.v1.partners;

import lombok.Data;

/**
 * Created by Aleksey.Shitikov on 17.05.2017.
 */
@Data
public class JSONError {

    private int status;

    private String error;

    public JSONError() {
    }

    public JSONError(int status, String message) {
        this.status = status;
        this.error = message;
    }

    @Override
    public String toString() {
        return "JSONError{" +
                "status=" + status +
                ", error='" + error + '\'' +
                '}';
    }
}
