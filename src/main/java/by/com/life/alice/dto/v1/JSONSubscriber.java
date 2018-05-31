package by.com.life.alice.dto.v1;

import by.com.life.alice.dto.entity.*;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class JSONSubscriber implements Serializable {

    private String msisdn;
    private String documentNo;
    private String givenName;
    private String familyName;
    private String middleName;
    private String email;
    private Timestamp birthday;
    private SubscriberStatus status;
    private Tariff tariff;
    private List<Balance> balances;
    private List<Service> services;

    public JSONSubscriber(Subscriber subscriber) {
        this.msisdn = subscriber.getMsisdn();
        this.documentNo = subscriber.getDocumentNo();
        this.givenName = subscriber.getGivenName();
        this.familyName = subscriber.getFamilyName();
        this.middleName = subscriber.getMiddleName();
        this.email = subscriber.getEmail();
        this.birthday = subscriber.getBirthday();
        this.status = subscriber.getStatus();
        this.tariff = subscriber.getTariff();
        this.balances = subscriber.getBalances();
        this.services = subscriber.getServices();
    }
}