package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;

@Data
public class SharedBundleGroupList implements Serializable{

    private Long groupId;

    private String mainMsisdn;
}
