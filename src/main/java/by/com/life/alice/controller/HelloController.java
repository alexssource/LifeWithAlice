package by.com.life.alice.controller;

import by.com.life.alice.dto.v1.JSONBalance;
import by.com.life.alice.dto.v1.JSONLightSubscriber;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {
    Logger logger = Logger.getLogger(HelloController.class.getName());

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    String privacyIdeaToken, privacyIdeaTransactionId, missaToken;

    @RequestMapping("/test")
    String test(@RequestParam String q,@RequestParam String ... param) {
        logger.info("test, q:"+q+" param:"+String.join(", ",param));
        switch (q) {
            case "getBalance":
                missaToken = MissaUtils.getTokenOldAuth(param[0]);
                JSONLightSubscriber profile = MissaUtils.getProfile(missaToken);
                StringBuilder sb = new StringBuilder();
                for (JSONBalance balance : profile.getBalances()) {
                    sb.append("{Balance ").append(balance.getName()).append("=")
                            .append(balance.getTotal()).append(" ").append(balance.getUnit()).append("},");
                }
                return profile.getTariff().getCode()+sb.toString();
            case "changeTariff":
                missaToken = MissaUtils.getTokenOldAuth(param[0]);
                return MissaUtils.changeTariff(missaToken,param[1]).toString();
            case "getCode":
                privacyIdeaToken = MissaUtils.getTokenPrivacyIdea();
                privacyIdeaTransactionId = MissaUtils.getCodePrivacyIdea(param[0],privacyIdeaToken);
                return "Sended";
            case "verifyPhone":
                return MissaUtils.verifyPhone(param[0],param[1],privacyIdeaToken,privacyIdeaTransactionId).toString();
        }
        return "No case for " + q;
    }
}
