package by.com.life.alice.domain;

import by.com.life.alice.dto.v1.JSONLightSubscriber;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;


@Getter
@Setter
@ToString
public class AliceKnowledge {
    private String msisdn;
    private JSONLightSubscriber profile;
    private boolean changed;
    private final String sessionId;

    public AliceKnowledge(String sessionId) {
        this.sessionId = sessionId;
    }


    public boolean hasMsisdn() {
        return !StringUtils.isEmpty(msisdn);
    }

    public boolean hasProfile() {
        return profile != null;
    }
}
