package by.com.life.alice.dto.sentity;

import lombok.Data;

import java.util.Calendar;
import java.util.Date;

@Data
public class Banner {
    private Integer bannerId;
    private String type;
    private String url;
    private String position;
    private Date dateModification;
    private Date dateFrom;
    private Date dateTo;

    protected void onUpdate() {
        dateModification = Calendar.getInstance().getTime();
    }

    void createdAt() {
        dateModification = Calendar.getInstance().getTime();
    }

    private Integer bannerAttachmentId;

    private BannerType bannerType;

    private PossiblePosition possiblePosition;
   }
