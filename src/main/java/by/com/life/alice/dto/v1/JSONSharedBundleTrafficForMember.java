package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.SharedBundleSharedTraffic;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

@Data
public class JSONSharedBundleTrafficForMember {
    @NotNull
    @NotEmpty
    private String msisdn;
    private String gprsAmount;
    private String mocNatAmount;

    public SharedBundleSharedTraffic convertToSharedTrafficEntity(){
        SharedBundleSharedTraffic result = new SharedBundleSharedTraffic();
        result.setMsisdn(this.getMsisdn());
        result.setGprsAmount(this.getGprsAmount());
        result.setMocNatAmount(this.getMocNatAmount());
        return result;
    }
}
