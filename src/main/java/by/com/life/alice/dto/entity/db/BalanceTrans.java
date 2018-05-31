package by.com.life.alice.dto.entity.db;

import by.com.life.alice.dto.entity.Balance;
import lombok.Data;

import java.io.Serializable;

@Data
public class BalanceTrans extends Balance implements Serializable {
    private String lang;
    private Language language;
}
