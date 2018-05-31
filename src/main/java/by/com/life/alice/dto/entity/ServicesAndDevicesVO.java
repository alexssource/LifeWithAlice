package by.com.life.alice.dto.entity;

import lombok.Data;

/**
 * Created by Aleksandr.Muravjev on 09.02.2017.
 */
@Data
public class ServicesAndDevicesVO {
    public ServicesAndDevicesVO() {
    }

    public ServicesAndDevicesVO(Long id, String name, String imageUrl, String redirectUrl, String description, String type) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.redirectUrl = redirectUrl;
        this.description = description;
        this.type = type;
    }

    private Long id;
    private String name;
    private String imageUrl;
    private String redirectUrl;
    private String description;
    private String type;
}
