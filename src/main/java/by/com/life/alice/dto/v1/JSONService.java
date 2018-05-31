package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Sergey Horonzhyn on 5/29/15.
 */
public class JSONService implements Serializable {

    private String code;
    private String name;
    private String desc;
    private Integer duration;
//    private Long total;

    private Map<Integer, FieldData> params;
    //    private Map features;
    private List tags;
    private List types;

    public JSONService(Service service) {
        this.code = service.getCode();
        this.name = service.getName();
        this.desc = service.getDesc();
        this.duration = service.getDuration();
//        this.total = service.getTotal();
        this.types = service.getTypes();


        // fill ordered params data
//        Map<String, String> paramsMap = service.getParams();
//        if (paramsMap!=null && paramsMap.size()>0) {
//            int orderBy = 1;
//            params = new HashMap<>();
//            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
//                String key = entry.getKey();
//                String value = entry.getValue();
//                FieldData data = new FieldData(key, value);
//                params.put(orderBy, data);
//                orderBy++;
//            }
//        }
        this.params = service.getParams();
//        this.features = service.getFeatures();
        this.tags = service.getTags();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

//    public Long getTotal() {
//        return total;
//    }
//
//    public void setTotal(Long total) {
//        this.total = total;
//    }


    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

//    public Map getFeatures() {
//        return features;
//    }
//
//    public void setFeatures(Map features) {
//        this.features = features;
//    }

    public List getTags() {
        return tags;
    }

    public void setTags(List tags) {
        this.tags = tags;
    }

    public List getTypes() {
        return types;
    }

    public void setTypes(List types) {
        this.types = types;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSONService that = (JSONService) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (desc != null ? !desc.equals(that.desc) : that.desc != null) return false;
        if (duration != null ? !duration.equals(that.duration) : that.duration != null) return false;
        if (params != null ? !params.equals(that.params) : that.params != null) return false;
//        if (features != null ? !features.equals(that.features) : that.features != null) return false;
        if (tags != null ? !tags.equals(that.tags) : that.tags != null) return false;
        return !(types != null ? !types.equals(that.types) : that.types != null);

    }

    @Override
    public int hashCode() {
        int result = code != null ? code.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (params != null ? params.hashCode() : 0);
//        result = 31 * result + (features != null ? features.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (types != null ? types.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JSONService{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", duration=" + duration +
                ", params=" + params +
//                ", features=" + features +
                ", tags=" + tags +
                ", types=" + types +
                '}';
    }
}
