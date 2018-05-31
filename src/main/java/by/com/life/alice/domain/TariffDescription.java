package by.com.life.alice.domain;


import lombok.*;


@Getter
@AllArgsConstructor
@ToString
public class TariffDescription {
    private String plan;
    private String description;
    private String internetTraffic;
    private String internetTrafficUnit;
    private String minutes;
    private String minutesUnit;
    private String price;
    private String priceUnit;
    private String link;
    private String code;

    public TariffDescription(String plan, String description, String internetTraffic, String internetTrafficUnit, String minutes, String minutesUnit, String price, String priceUnit, String link) {
        this.plan = plan;
        this.description = description;
        this.internetTraffic = internetTraffic;
        this.internetTrafficUnit = internetTrafficUnit;
        this.minutes = minutes;
        this.minutesUnit = minutesUnit;
        this.price = price;
        this.priceUnit = priceUnit;
        this.link = link;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
