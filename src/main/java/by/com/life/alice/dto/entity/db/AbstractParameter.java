package by.com.life.alice.dto.entity.db;

import lombok.Data;

@Data
public abstract class AbstractParameter {
    private Integer parameterId;
    private String key;
    private String value;
    private String parameterType;
    private Integer orderBy;
    private String appType;
    private String valueExt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractParameter that = (AbstractParameter) o;

        if (!getParameterId().equals(that.getParameterId())) return false;
        if (getKey() != null ? !getKey().equals(that.getKey()) : that.getKey() != null) return false;
        if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null) return false;
        if (getParameterType() != null ? !getParameterType().equals(that.getParameterType()) : that.getParameterType() != null)
            return false;
        if (getAppType() != null ? !getAppType().equals(that.getAppType()) : that.getAppType() != null)
            return false;
        if (getValueExt() != null ? !getValueExt().equals(that.getValueExt()) : that.getValueExt() != null)
            return false;
        return getOrderBy() != null ? getOrderBy().equals(that.getOrderBy()) : that.getOrderBy() == null;
    }

    @Override
    public int hashCode() {
        int result = getParameterId().hashCode();
        result = 31 * result + (getKey() != null ? getKey().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        result = 31 * result + (getParameterType() != null ? getParameterType().hashCode() : 0);
        result = 31 * result + (getAppType() != null ? getAppType().hashCode() : 0);
        result = 31 * result + (getValueExt() != null ? getValueExt().hashCode() : 0);
        result = 31 * result + (getOrderBy() != null ? getOrderBy().hashCode() : 0);
        return result;
    }
}
