package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceTag implements Serializable {

    private Integer serviceTagId;
    private Integer tagId;
    private String lang;
    private String code;

    private Tag tag;
}
