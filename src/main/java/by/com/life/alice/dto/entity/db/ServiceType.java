package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceType implements Serializable {
    private Integer serviceTypeId;
    private Integer typeId;
    private String lang;
    private String code;
    private Type type;
}
