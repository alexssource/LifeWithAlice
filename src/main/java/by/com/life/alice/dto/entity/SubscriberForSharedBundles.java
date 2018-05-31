package by.com.life.alice.dto.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SubscriberForSharedBundles {
    private String msisdn;
    private String mainMsisdn;
    private String name;
    private String color;
    private String photoUrl;
    private Long userId;
    private Long groupId;
    private String mainTariff;
    private Tariff tariff;
    private String lang;
    private Date nextWriteOff;
    private Integer countDaysLeavesForTraffic;
    private Long totalCountOfMB;
    private Long totalCountOfMOC;
    private Long totalBuiltInOfMB;
    private Long totalBuiltInOfMOC;
    private List<Balance> balances;
    private Boolean notificationsSendingStatus;

    public SubscriberForSharedBundles(Subscriber subscriber) {
        if(subscriber != null){
            this.setMsisdn(subscriber.getMsisdn());
            this.setTariff(subscriber.getTariff());
            this.setLang(subscriber.getLang());
            this.setBalances(subscriber.getBalances());
        }
    }
}
