package by.com.life.alice.dto.entity.db;

import lombok.Data;

import java.io.Serializable;

@Data
public class SharedBundleGroupListPK implements Serializable {
    protected Long groupId;
    protected String mainMsisdn;

    public SharedBundleGroupListPK(){ }

    public SharedBundleGroupListPK(Long groupId, String mainMsisdn){
        this.groupId = groupId;
        this.mainMsisdn = mainMsisdn;
    }
}
