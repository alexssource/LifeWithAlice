package by.com.life.alice.web;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping("/test")
    String test(@RequestParam String q) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        HttpEntity<?> entity = new HttpEntity<>(headers);
//        ResponseEntity<String> responce = restTemplate.exchange("http://srv-missa-p01:8085/api/v1/subscriber/bundles/colors", HttpMethod.GET, entity, String.class);
        ResponseEntity<String> responce1 = restTemplate.exchange(" https://missaauthtest.life.com.by/oauth/token?grant_type=password&username=375256257211&password=73165752",HttpMethod.POST, entity, String.class);
        headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Authorization", "Bearer 7f804704-dd0c-493d-a6c4-20491a0317d7");
        entity = new HttpEntity<>(headers);
        ResponseEntity<String> responce2 = restTemplate.exchange("http://srv-missa-p01:8085/api/v1/subscriber/profile",HttpMethod.GET, entity, String.class);

        return "Ok! "+q;
    }
}
