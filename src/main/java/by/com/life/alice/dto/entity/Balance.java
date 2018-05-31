package by.com.life.alice.dto.entity;

import lombok.Data;

import java.util.List;

@Data
public class Balance {
    private String code;
    private String name;
    private String unit;
    private Integer flag;
    private Double total;
    private List<Pocket> pockets;
}
