package by.com.life.alice.dto.v1.partners;

import by.com.life.alice.dto.entity.partners.AlfaLifeProfile;
import by.com.life.alice.dto.v1.JSONLPHistoryEvent;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Aleksey.Shitikov on 26.04.2017.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONAlfaLifeInfo implements Serializable {

    private static final long serialVersionUID = -1498337004454352994L;

    private String msisdn;

    private Boolean isMyLifeMember;

    private Boolean isAlfaLifeMember;

    private Integer lifePointsBalance;

    private List<JSONLPHistoryEvent> lifePointsHistory;

    public JSONAlfaLifeInfo(AlfaLifeProfile alfaLifeProfile) {
        this.msisdn = alfaLifeProfile.getMsisdn();
        this.isAlfaLifeMember = alfaLifeProfile.isAlfaLifeMember();
        if (isAlfaLifeMember) {
            this.isMyLifeMember = alfaLifeProfile.isMyLifeMember();
            this.lifePointsBalance = alfaLifeProfile.getLpBalance() == null ? 0 : alfaLifeProfile.getLpBalance();
            if (alfaLifeProfile.getLpHistory() != null) {
                this.lifePointsHistory = alfaLifeProfile.getLpHistory().stream()
                        .map(JSONLPHistoryEvent::new).collect(Collectors.toList());
            }
        }
    }

    @Override
    public String toString() {
        return "JSONAlfaLifeInfo{" +
                "msisdn='" + msisdn + '\'' +
                ", isMyLifeMember=" + isMyLifeMember +
                ", isAlfaLifeMember=" + isAlfaLifeMember +
                ", lifePointsBalance=" + lifePointsBalance +
                ", lifePointsHistory=" + lifePointsHistory +
                '}';
    }
}
