package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.util.Date;

@Data
public class SharedServiceHistory {

    private Long id;

    private Long userId;

    private String serviceCode;

    private Long counter;

    private Date activationDate;
}
