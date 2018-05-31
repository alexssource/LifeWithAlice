package by.com.life.alice.domain;

import by.com.life.alice.dto.v1.JSONLightSubscriber;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class AliceKnowledge {
    private String msisdn;
    private JSONLightSubscriber profile;


    public boolean hasMsisdn() {
        return !StringUtils.isEmpty(msisdn);
    }

    public boolean hasProfile() {
        return profile != null;
    }
}
