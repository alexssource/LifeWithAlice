package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.Balance;
import by.com.life.alice.dto.entity.SubscriberForSharedBundles;
import by.com.life.alice.dto.entity.db.SharedBundleConstants;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONBundleProfile {
    private String msisdn;
    private String mainMsisdn;
    private String userName;
    private String color;
    private String photoUrl;
    private Long userId;
    private Long groupId;
    private String mainTariff;
    private JSONTariff tariff;
    private String lang;
    private String nextWriteOff;
    private Integer countDaysLeavesForTraffic;
    private String role;
    private Long totalCountOfMB;
    private Long totalCountOfMOC;
    private Long totalBuiltInOfMB;
    private Long totalBuiltInOfMOC;
    private JSONSharedBundleBalances balances;
    private List<JSONSharedBundleMember> members;
    private Boolean notificationsSendingStatus;

    public JSONBundleProfile(SubscriberForSharedBundles subscriber){
        this.setMsisdn(subscriber.getMsisdn());
        this.setMainMsisdn(subscriber.getMainMsisdn());
        this.setUserName(subscriber.getName());
        this.setColor(subscriber.getColor());
        this.setPhotoUrl(subscriber.getPhotoUrl());
        this.setUserId(subscriber.getUserId());
        this.setGroupId(subscriber.getGroupId());
        this.setMainTariff(subscriber.getMainTariff());
        if(subscriber.getNextWriteOff() != null) {
            this.setNextWriteOff(new SimpleDateFormat("dd.MM.yyyy").format(subscriber.getNextWriteOff()));
        }
        this.setCountDaysLeavesForTraffic(subscriber.getCountDaysLeavesForTraffic());
        this.setTotalCountOfMOC(subscriber.getTotalCountOfMOC());
        this.setTotalCountOfMB(subscriber.getTotalCountOfMB());
        this.setTotalBuiltInOfMB(subscriber.getTotalBuiltInOfMB());
        this.setTotalBuiltInOfMOC(subscriber.getTotalBuiltInOfMOC());
        this.setTariff(new JSONTariff(subscriber.getTariff()));
        this.setLang(subscriber.getLang());
        this.setBalances(new JSONSharedBundleBalances());
        this.getBalances().setLineMainBalance(
                getValueForSpecificBalance(subscriber.getBalances(), SharedBundleConstants.LINE_MAIN, 2));
        this.getBalances().setBundleMocNatShared(
                getValueForSpecificBalance(subscriber.getBalances(), SharedBundleConstants.MOC_BALANCE_NAME, 0));
        this.getBalances().setBundleGPRSShared(
                getValueForSpecificBalance(subscriber.getBalances(), SharedBundleConstants.GPRS_BALANCE_NAME, 0));
        this.setNotificationsSendingStatus(subscriber.getNotificationsSendingStatus());
    }

    private String getValueForSpecificBalance(List<Balance> balances, String nameOfBalance, int scale) {
        Optional<Balance> totalValue = balances.stream()
                .filter(x -> x.getCode().equalsIgnoreCase(nameOfBalance))
                .findFirst();
        if(totalValue.isPresent()) {
            Double resultDouble = Math.floor(totalValue.get().getTotal() * 100) / 100;
            if (!nameOfBalance.equalsIgnoreCase(SharedBundleConstants.LINE_MAIN)) {
                return String.valueOf(resultDouble.intValue());
            } else{
                return String.valueOf(resultDouble);
            }
        }
        return "";
    }
}
