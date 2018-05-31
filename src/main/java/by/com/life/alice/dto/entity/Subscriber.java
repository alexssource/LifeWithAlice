package by.com.life.alice.dto.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Data
public class Subscriber {
    private String msisdn;
    private String documentNo;
    private Date activationDate;
    private Date deactivationDate;
    private String lang;
    private String givenName;
    private String familyName;
    private String middleName;
    private String email;
    private Timestamp birthday;
    private String contractType;
    private String puk1;
    private String puk2;
    private String pin1;
    private String pin2;
    private String imsi;
    private String simCode;
    private String usid;
    private SubscriberStatus status;
    private Tariff tariff;
    private List<Balance> balances;
    private List<Service> services;
    private String accountId;
}
