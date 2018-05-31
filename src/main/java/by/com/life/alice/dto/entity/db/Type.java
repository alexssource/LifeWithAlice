package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;

@Data
public class Type implements Serializable {
    private Integer typeId;
    private String name;
    private String lang;
    private Language language;
}
