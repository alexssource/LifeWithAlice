package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.db.SharedBundleGroupList;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONSharedBundleInvite {
    private String senderMsisdn;
    private Long groupId;

    public JSONSharedBundleInvite(SharedBundleGroupList invite) {
        this.senderMsisdn = invite.getMainMsisdn();
        this.groupId = invite.getGroupId();
    }
}
