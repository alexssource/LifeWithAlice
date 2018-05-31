package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.Tariff;
import by.com.life.alice.dto.entity.db.SharedBundleMember;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONSharedBundleMemberExt extends JSONSharedBundleMember{
    private JSONTariff tariffOfMain;

    public JSONSharedBundleMemberExt(SharedBundleMember member, Tariff mainTariff){
        super(member);
        this.tariffOfMain = new JSONTariff(mainTariff);
    }
}
