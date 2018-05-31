package by.com.life.alice.dto.entity.db;


import lombok.Data;

/**
 * Created by Sergey.Shiman on 25.01.2017.
 */

@Data
public class SharedBundleSharedBalance {
    private String id;

    private Long userId;

    private String msisdn;

    private String balanceName;

    private String pl;

    private String type;

    private String value;
}
