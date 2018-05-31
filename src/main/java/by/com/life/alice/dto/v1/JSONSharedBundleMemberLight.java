package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.SharedBundleStatusEnum;
import by.com.life.alice.dto.entity.db.SharedBundleMember;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * Created by Aleksandr.Muravjev on 22.02.2017.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONSharedBundleMemberLight {
    private String msisdn;
    private SharedBundleStatusEnum status;
    private Long initialCountOfSharedMOC;
    private Long initialCountOfSharedGPRS;
    private Long initialCountOfSharedMOCOnNextMonth;
    private Long initialCountOfSharedGPRSOnNextMonth;
    private String photoUrl;
    private String color;
    private String userName;

    public JSONSharedBundleMemberLight(SharedBundleMember member) {
        this.msisdn = member.getMsisdn();
        this.status = member.getStatus();
        this.initialCountOfSharedMOC = member.getInitialCountOfSharedMOC();
        this.initialCountOfSharedGPRS = member.getInitialCountOfSharedGPRS();
        this.initialCountOfSharedMOCOnNextMonth = member.getInitialCountOfSharedMOCOnNextMonth();
        this.initialCountOfSharedGPRSOnNextMonth = member.getInitialCountOfSharedGPRSOnNextMonth();
        this.photoUrl = member.getPhotoUrl();
        this.color = member.getColor();
        this.userName = member.getUserName();
    }
}
