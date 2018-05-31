package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.db.SharedBundleMember;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONSharedBundleMember extends JSONSharedBundleMemberLight{
    private Long userId;
    private Long groupId;
    private String dateFrom;
    private String dateTo;
    private Double lineMainBalance;
    private Long currentCountOfSharedMOC;
    private Long currentCountOfSharedGPRS;
    private Long countOfGPRSOnNextMonth;
    private Long countOfMOCOnNextMonth;
    private Boolean notificationsSendingStatus;
    private String photoUrl;
    private String color;
    private String userName;

    public JSONSharedBundleMember(SharedBundleMember member){
        super(member);
        this.userId = member.getUserId();
        this.groupId = member.getGroupId();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        this.dateFrom = dateFormat.format(member.getDateFrom());
        this.dateTo = dateFormat.format(member.getDateTo());
        if(member.getLineMainBalance() != null) {
            this.lineMainBalance = new BigDecimal(member.getLineMainBalance())
                    .setScale(2, BigDecimal.ROUND_DOWN).doubleValue();
        }
        this.currentCountOfSharedGPRS = member.getCurrentCountOfSharedGPRS();
        this.currentCountOfSharedMOC = member.getCurrentCountOfSharedMOC();
        this.countOfGPRSOnNextMonth = member.getCountOfGPRSOnNextMonth();
        this.countOfMOCOnNextMonth = member.getCountOfMocOnNextMonth();
        this.photoUrl = member.getPhotoUrl();
        this.color = member.getColor();
        this.userName = member.getUserName();
        this.setNotificationsSendingStatus(member.getNotificationSendingStatus());
    }
}
