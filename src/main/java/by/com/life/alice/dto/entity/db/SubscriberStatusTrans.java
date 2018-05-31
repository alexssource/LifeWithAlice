package by.com.life.alice.dto.entity.db;

import by.com.life.alice.dto.entity.SubscriberStatus;
import lombok.Data;

import java.io.Serializable;

@Data
public class SubscriberStatusTrans extends SubscriberStatus implements Serializable {
    private String lang;
}
