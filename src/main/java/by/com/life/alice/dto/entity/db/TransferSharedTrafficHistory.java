package by.com.life.alice.dto.entity.db;

import by.com.life.alice.dto.entity.SharedTrafficType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TransferSharedTrafficHistory implements Serializable {
    private Long id;

    private Long userIdFrom;

    private Long userIdTo;

    private String value;

    private SharedTrafficType type;

    private Date date;

    private boolean needSave;
}
