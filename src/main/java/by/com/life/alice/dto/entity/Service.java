package by.com.life.alice.dto.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Service {
    private String code;
    private String name;
    private String desc;
    private Integer duration;
    private Map params;
    private Map features;
    private List tags;
    private List types;
}
