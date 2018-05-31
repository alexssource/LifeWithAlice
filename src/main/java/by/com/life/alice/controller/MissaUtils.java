package by.com.life.alice.controller;

import by.com.life.alice.dto.TockenDTO;
import by.com.life.alice.dto.v1.JSONLightSubscriber;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.TreeMap;

public class MissaUtils {
    private static TreeMap<String, String> passwords = new TreeMap<String, String>() {
        {
            put("375256257211", "73165752");
        }
    };

    public static JSONLightSubscriber getProfile(String phone) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", "Basic bW9iaWxlX2FwcDo7S0cqOF82VWQwcUIqVXg=");
        HttpEntity<?> entity = new HttpEntity<>(headers);
        String password = "73165752";
        ResponseEntity<TockenDTO> responce1 = restTemplate.exchange("https://missaauthtest.life.com.by/oauth/token?grant_type=password&username=" + phone + "&password=" + passwords.get(phone), HttpMethod.POST, entity, TockenDTO.class);
        headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", "Bearer " + responce1.getBody().getAccess_token());
        entity = new HttpEntity<>(headers);
        ResponseEntity<JSONLightSubscriber> responce2 = restTemplate.exchange("http://srv-missa-p01:8085/api/v1/subscriber/profile", HttpMethod.GET, entity, JSONLightSubscriber.class);
        return responce2.getBody();
    }

    public static Boolean sendSms(String s) {
        return false;
    }

    public static Boolean verifyPhone(String code) {
        return false;
    }
}
