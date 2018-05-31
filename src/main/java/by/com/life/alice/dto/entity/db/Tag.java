package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;

@Data
public class Tag implements Serializable {
    private Integer tagId;
    private String name;
    private String lang;
    private Language language;
}
