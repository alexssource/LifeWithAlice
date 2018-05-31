package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;

@Data
public class TariffTag implements Serializable {
    private Integer tariffTagId;
    private Integer tagId;
    private String lang;
    private String code;
    private Tag tag;
}
