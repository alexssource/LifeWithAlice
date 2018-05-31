package by.com.life.alice.dto.sentity;

import lombok.Data;

import java.util.Date;

@Data
public class Version {

    private String version;
    private String desc;
    private String type; //NORMAL or FORCE
    private Date dateCreation;
}
