package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;

@Data
public class SharedBundleUserInfPK implements Serializable {
    protected Long userIdFrom;
    protected Long userIdTo;
    protected String param;

    public SharedBundleUserInfPK(){}

    public SharedBundleUserInfPK(Long userIdFrom, Long userIdTo, String param){
        this.userIdFrom = userIdFrom;
        this.userIdTo = userIdTo;
        this.param = param;
    }
}
