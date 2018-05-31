package by.com.life.alice.dto.v1;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class JSONSharedBundleTraffic {
    @NotNull
    @NotEmpty
    private List<JSONSharedBundleTrafficForMember> sharedTraffics;
    private Boolean needSave;

    private Boolean autoTransfer;
    private String mainMsisdn;
}
