package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.Service;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Sergey Horonzhyn on 5/29/15.
 */
@NoArgsConstructor
public class JSONLightService implements Serializable {

    private String code;

    //Build JSONLightService from real billing object
    public JSONLightService(Service service) {
        this.code = service.getCode();
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSONLightService that = (JSONLightService) o;

        return !(code != null ? !code.equals(that.code) : that.code != null);

    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "JSONLightService{" +
                "code='" + code + '\'' +
                '}';
    }
}
