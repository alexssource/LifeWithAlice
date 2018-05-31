package by.com.life.alice.dto.v1;

/**
 * Created by Sergey Horonzhyn on 8/21/15.
 */
public class FieldData {

    private String key;
    private String value;

    public FieldData(){}

    public FieldData(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
