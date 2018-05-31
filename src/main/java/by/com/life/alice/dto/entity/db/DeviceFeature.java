package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeviceFeature implements Serializable {

    private Long id;

    private String value;

}
