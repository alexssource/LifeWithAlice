package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.Balance;
import by.com.life.alice.dto.entity.Pocket;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class JSONBalance  implements Serializable  {

	private static final long serialVersionUID = -4286032254444926277L;

	private String code;
    private String name;
    private String unit;
    private Double total;
    private List<JSONPocket> pockets;

    public JSONBalance(Balance balance){
    	this.code = balance.getCode();
    	this.name = balance.getName();
    	this.unit = balance.getUnit();
        if (balance.getPockets()!=null && balance.getPockets().size()>0) {
            pockets = new ArrayList<>(balance.getPockets().size());
            for (Pocket pocket : balance.getPockets()) {
                JSONPocket jsonPocket = new JSONPocket(pocket);
                pockets.add(jsonPocket);
            }
        }
    	this.total = balance.getTotal(); 	
    }
    

}
