package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.Balance;
import by.com.life.alice.dto.entity.Service;
import by.com.life.alice.dto.entity.Subscriber;
import by.com.life.alice.dto.entity.SubscriberStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class JSONLightSubscriber implements Serializable {

    private String msisdn;
    private String documentNo;
    private String givenName;
    private String familyName;
    private String middleName;
    private String email;
    private Timestamp birthday;
    private String usid;
    private String contractType;
    private SubscriberStatus status;
    private JSONLightTariff tariff;
    private List<JSONBalance> balances;
    private List<JSONLightService> services;

    /**
     * Build JSONLightSubscriber from real billing object
     * @param subscriber
     */
    public JSONLightSubscriber(Subscriber subscriber) {
        this.msisdn = subscriber.getMsisdn();
        this.documentNo = subscriber.getDocumentNo();
        this.givenName = subscriber.getGivenName();
        this.familyName = subscriber.getFamilyName();
        this.middleName = subscriber.getMiddleName();
        this.email = subscriber.getEmail();
        this.birthday = subscriber.getBirthday();
        this.contractType = subscriber.getContractType();
        this.status = subscriber.getStatus();
        this.tariff = new JSONLightTariff(subscriber.getTariff());
        if(subscriber.getBalances()!=null) {
            this.balances = new ArrayList<>(subscriber.getBalances().size());
            for (Balance balance : subscriber.getBalances()) {
                JSONBalance jsonBalance = new JSONBalance(balance);
                this.balances.add(jsonBalance);
            }
        }

        if (subscriber.getServices()!=null) {
            this.services = new ArrayList<>(subscriber.getServices().size());
            for (Service service : subscriber.getServices()) {
                JSONLightService jsonService = new JSONLightService(service);
                this.services.add(jsonService);
            }
        }
        this.usid = subscriber.getUsid();
    }
}