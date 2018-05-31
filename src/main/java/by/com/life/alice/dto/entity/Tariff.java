package by.com.life.alice.dto.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Tariff {
    private String code;
    private String name;
    private String desc;
    private Double fee;
    private Map params;
    private Map features;
    private List tags;
    private String cost;
}
