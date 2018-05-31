package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.sentity.Version;

/**
 * Created by Sergey Horonzhyn on 9/3/15.
 */
public class JSONVersion {

    private String version;
    private String desc;
    private String type; //NORMAL or FORCE

    public JSONVersion(Version version) {
        this.version = version.getVersion();
        this.desc = version.getDesc();
        this.type = version.getType();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSONVersion that = (JSONVersion) o;

        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        return !(type != null ? !type.equals(that.type) : that.type != null);

    }

    @Override
    public int hashCode() {
        int result = version != null ? version.hashCode() : 0;
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JSONVersion{" +
                "version='" + version + '\'' +
                ", desc='" + desc + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
