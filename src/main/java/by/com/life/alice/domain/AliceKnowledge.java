package by.com.life.alice.domain;

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


    public boolean hasMsisdn() {
        return !StringUtils.isEmpty(msisdn);
    }
}
