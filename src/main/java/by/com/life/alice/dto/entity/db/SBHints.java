package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;


@Data
public class SBHints implements Serializable {
    private Long id;

    private String key;

    private String description;

    private String forRole;
}
