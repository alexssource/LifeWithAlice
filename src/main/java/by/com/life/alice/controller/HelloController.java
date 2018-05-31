package by.com.life.alice.controller;

import by.com.life.alice.dto.v1.JSONBalance;
import by.com.life.alice.dto.v1.JSONLightSubscriber;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    @RequestMapping("/test")
    String test(@RequestParam String q) {
        switch (q) {
            case "getBalance":
                JSONLightSubscriber profile = MissaUtils.getProfile("375256257211");
                StringBuilder sb = new StringBuilder();
                for (JSONBalance balance : profile.getBalances()) {
                    sb.append("{Balance ").append(balance.getName()).append("=")
                            .append(balance.getTotal()).append(" ").append(balance.getUnit()).append("},");
                }
                return sb.toString();
            case "sendSms":
                return MissaUtils.sendSms("375256257211").toString();
            case "verifyPhone":
                return MissaUtils.verifyPhone("code").toString();
        }
        return "No case for " + q;
    }
}
