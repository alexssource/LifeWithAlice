package by.com.life.alice.dto.entity.db;

import by.com.life.alice.dto.entity.SharedBundleStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class SharedBundleMember implements Serializable {

    private Long userId;

    private Long groupId;

    private String msisdn;

    private SharedBundleStatusEnum status;

    private Date dateFrom;

    private Date dateTo;

    private String photoUrl;

    private String color;

    private String userName;

    private Long initialCountOfSharedMOC;

    private Long initialCountOfSharedGPRS;

    private Long initialCountOfSharedMOCOnNextMonth;

    private Long initialCountOfSharedGPRSOnNextMonth;


    private Long currentCountOfSharedMOC;


    private Long currentCountOfSharedGPRS;


    private Long countOfGPRSOnNextMonth;


    private Long countOfMocOnNextMonth;


    private Boolean notificationSendingStatus;


    private Double lineMainBalance;
}
