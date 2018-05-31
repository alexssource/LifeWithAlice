package by.com.life.alice.dto.v1;

import java.io.Serializable;

/**
 * Created by Sergey Horonzhyn on 5/29/15.
 */
public class JSONRequestFields implements Serializable{

    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSONRequestFields that = (JSONRequestFields) o;

        return !(field != null ? !field.equals(that.field) : that.field != null);

    }

    @Override
    public int hashCode() {
        return field != null ? field.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "JSONRequestPassword{" +
                "field='" + field + '\'' +
                '}';
    }
}
