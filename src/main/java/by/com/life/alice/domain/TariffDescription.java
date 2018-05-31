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
}
