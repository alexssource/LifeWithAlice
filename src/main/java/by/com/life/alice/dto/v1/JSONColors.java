package by.com.life.alice.dto.v1;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JSONColors {
    private List<String> colors = new ArrayList<>();

}
