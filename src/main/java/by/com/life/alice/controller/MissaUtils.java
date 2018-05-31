package by.com.life.alice.controller;

import by.com.life.alice.dto.MissaTockenDTO;
import by.com.life.alice.dto.v1.JSONLightSubscriber;
import lombok.Data;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.logging.Logger;

public class MissaUtils {
    static Logger logger = Logger.getLogger(MissaUtils.class.getName());
    static {
        disableSslVerification();
    }

    private static void disableSslVerification() {
        logger.info("disableSslVerification");
        try
        {
            // Create a trust manager that does not validate certificate chains
            TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {
                }
                public void checkServerTrusted(X509Certificate[] certs, String authType) {
                }
            }
            };

            // Install the all-trusting trust manager
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Create all-trusting host name verifier
            HostnameVerifier allHostsValid = new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            };

            // Install the all-trusting host verifier
            HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }
    private static TreeMap<String, AlisaUser> passwords = new TreeMap<String, AlisaUser>() {
        {
            //не существующий
            put("375256257210", new AlisaUser("375256257210","73165752"));
            //тестовый в миссе (не менять!!!)
            put("375256257211", new AlisaUser("375256257211","73165752"));
            //тестовые
            put("375255501525", new AlisaUser("375255501525","123456"));
            put("375256257331", new AlisaUser("375256257331","123456"));
        }
    };

    public static String getTokenOldAuth(String phone) {
        logger.info("getTokenOldAuth");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", "Basic bW9iaWxlX2FwcDo7S0cqOF82VWQwcUIqVXg=");
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<MissaTockenDTO> responce = restTemplate.exchange("https://missaauthtest.life.com.by/oauth/token?grant_type=password&username=" + phone + "&password=" + passwords.get(phone).password, HttpMethod.POST, entity, MissaTockenDTO.class);
        logger.info("get:"+responce.getBody().getAccess_token());
        return responce.getBody().getAccess_token();
    }

    public static JSONLightSubscriber getProfile(String token) {
        logger.info("getProfile token:"+token);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<JSONLightSubscriber> responce = restTemplate.exchange("http://srv-missa-p01:8085/api/v1/subscriber/profile", HttpMethod.GET, entity, JSONLightSubscriber.class);
        logger.info("get msisdn:"+responce.getBody().getMsisdn());
        return responce.getBody();
    }

    private static<T> T getFromMap(LinkedHashMap map, String ... path) {
        if(path.length==1){
            return (T)map.get(path[0]);
        }
        return getFromMap((LinkedHashMap)map.get(path[0]),Arrays.copyOfRange(path,1,path.length));
    }

    public static Boolean changeTariff(String token, String tariff) {
        logger.info("changeTarif token:"+token);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<LinkedHashMap> responce = restTemplate.exchange("http://srv-missa-p01:8085/api/v1/subscriber/tariff/"+tariff, HttpMethod.PUT, entity, LinkedHashMap.class);
        logger.info("get msisdn:"+getFromMap(responce.getBody(),"success"));
        return getFromMap(responce.getBody(),"success");
    }

    public static String getTokenPrivacyIdea() {
        logger.info("getTokenPrivacyIdea");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<LinkedHashMap> responce = restTemplate.exchange("https://10.17.0.46/auth?username=alice@token&password=12345A", HttpMethod.POST, entity, LinkedHashMap.class);
        LinkedHashMap responceBody = responce.getBody();
        if(getFromMap(responceBody,"result","status")){
            logger.info("get:"+getFromMap(responceBody,"result","value","token"));
            return getFromMap(responceBody,"result","value","token");
        }
        logger.info("fail");
        return null;
    }

    public static String getCodePrivacyIdea(String phone, String privacyIdeaToken) {
        logger.info("getCodePrivacyIdea phone:"+phone+" privacyIdeaToken:"+privacyIdeaToken);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", privacyIdeaToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<LinkedHashMap> responce = restTemplate.exchange("https://srv-abauth-t01/validate/check?user="+phone+"&realm=subs&pass=sms", HttpMethod.GET, entity, LinkedHashMap.class);
        LinkedHashMap responceBody = responce.getBody();
        if(getFromMap(responceBody,"result","status")){
            logger.info("get:"+getFromMap(responceBody,"detail","transaction_id"));
            return getFromMap(responceBody,"detail","transaction_id");
        }
        return null;
    }

    public static Boolean verifyPhone(String phone, String code, String privacyIdeaToken, String privacyIdeaTransactionId) {
        logger.info("verifyPhone phone:"+phone+" code:"+code+" privacyIdeaToken:"+privacyIdeaToken+" privacyIdeaTransactionId:"+privacyIdeaTransactionId);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", privacyIdeaToken);
        HttpEntity<?> entity = new HttpEntity<>(headers);
        ResponseEntity<LinkedHashMap> responce = restTemplate.exchange("https://srv-abauth-t01/validate/check?user="+phone+"&realm=subs&pass="+code+"&transaction_id="+privacyIdeaTransactionId, HttpMethod.GET, entity, LinkedHashMap.class);
        LinkedHashMap responceBody = responce.getBody();
        if(getFromMap(responceBody,"result","status")){
            return getFromMap(responceBody,"result","value");
        }
        return false;
    }

    @Data
    private static class AlisaUser {
        String phone, password, sessionId;
        JSONLightSubscriber profile;
        public AlisaUser(String phone, String password) {
            this.phone = phone;
            this.password = password;
        }
    }
}
