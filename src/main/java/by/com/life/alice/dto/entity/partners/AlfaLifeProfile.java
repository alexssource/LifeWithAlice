package by.com.life.alice.dto.entity.partners;

import by.com.life.alice.dto.entity.db.LPHistoryEvent;
import lombok.Data;

import java.util.List;

/**
 * Created by Aleksey.Shitikov on 28.04.2017.
 */
@Data
public class AlfaLifeProfile {

    private String msisdn;

    private boolean isMyLifeMember;

    private boolean isAlfaLifeMember;

    private Integer lpBalance;

    private List<LPHistoryEvent> lpHistory;

}
