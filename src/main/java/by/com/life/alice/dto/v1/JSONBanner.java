package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.sentity.Banner;

import java.io.Serializable;

public class JSONBanner implements Serializable  {

	private static final long serialVersionUID = -7039929428774855006L;
	
	private Integer bannerId;
    private String type;
    private String url;
    private String position;

    public JSONBanner(Banner banner){
    	this.bannerId = banner.getBannerId();
    	this.type = banner.getType();
    	this.url = banner.getUrl();
    	this.position = banner.getPosition(); 	
    }
    
    public Integer getBannerId() {
        return bannerId;
    }

    public void setBannerId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JSONBanner banner = (JSONBanner) o;
        
        if (bannerId != null ? !bannerId.equals(banner.bannerId) : banner.bannerId != null) return false;
        if (type != null ? !type.equals(banner.type) : banner.type != null) return false;
        if (url != null ? !url.equals(banner.url) : banner.url != null) return false;
        return !(position != null ? !position.equals(banner.position) : banner.position != null);

    }

    @Override
    public int hashCode() {
    	   	
        int result = bannerId != null ? bannerId.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
  	
        return "Banner{" +
                "bannerId='" + bannerId + '\'' +
                ", type='" + type + '\'' +
                ", url='" + url + '\'' +
                ", position=" + position +
                '}';
    }   
}

