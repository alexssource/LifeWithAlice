package by.com.life.alice.dto.entity;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Pocket {
    private String labelCode;
    private String code;
    private Timestamp start;
    private Timestamp end;
    private Double value;
}
