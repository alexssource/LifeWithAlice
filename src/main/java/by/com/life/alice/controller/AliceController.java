package by.com.life.alice.controller;

import by.com.life.alice.command.AliceRequestCommand;
import by.com.life.alice.dto.AliceButtonDTO;
import by.com.life.alice.dto.AliceResponseDTO;
import by.com.life.alice.dto.AliceResponsePayloadDTO;
import by.com.life.alice.dto.AliceSessionDTO;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/alice")
public class AliceController {

    @RequestMapping(method = RequestMethod.POST)
    public AliceResponseDTO processCommand(@RequestBody AliceRequestCommand request) {
        System.out.println(request);

        return processText(request.getRequest().getCommand(), request);
    }

    private AliceResponseDTO processText(String command, AliceRequestCommand request) {
        String responseText = null;
        List<AliceButtonDTO> buttons = null;

        if (!StringUtils.isEmpty(command) && command.toLowerCase().contains("тарифные планы")) {
            if (command.toLowerCase().contains("все") || command.toLowerCase().contains("какие")) {
                responseText = "наши тарифные планы";
                buttons = new ArrayList<>(13);
                buttons.add(new AliceButtonDTO("Шейк 1", "Безлимит на соцсети и мессенджеры, 1 ГБ в роуминге", "http://life.com.by/shake/", false));
                buttons.add(new AliceButtonDTO("Шейк 2", "Безлимит на соцсети и мессенджеры, 1 ГБ в роуминге", "http://life.com.by/shake/", false));
                buttons.add(new AliceButtonDTO("Шейк 3", "Безлимит на соцсети и мессенджеры, 1 ГБ в роуминге", "http://life.com.by/shake/", false));
                buttons.add(new AliceButtonDTO("Шейк 4", "Безлимит на соцсети и мессенджеры, 1 ГБ в роуминге", "http://life.com.by/shake/", false));
                buttons.add(new AliceButtonDTO("Старт", "", "http://life.com.by/private/voice/start_yo_life/", false));
                buttons.add(new AliceButtonDTO("Семья 1", "Безлимит звонков  и смс внутри группы, Безлимит на BiP, Viber, WhatsApp", "https://family.life.com.by/", false));
                buttons.add(new AliceButtonDTO("Семья 2", "Безлимит звонков  и смс внутри группы, Безлимит на BiP, Viber, WhatsApp", "https://family.life.com.by/", false));
                buttons.add(new AliceButtonDTO("Семья 3", "Безлимит звонков  и смс внутри группы, Безлимит на BiP, Viber, WhatsApp", "https://family.life.com.by/", false));
                buttons.add(new AliceButtonDTO("Мультинет", "Безлимит минут и смс внутри сети", "https://family.life.com.by/", false));
                buttons.add(new AliceButtonDTO("Голос 1", "Безлимит минут внутри сети", "http://life.com.by/golos/", false));
                buttons.add(new AliceButtonDTO("Голос 2", "Безлимит минут внутри сети", "http://life.com.by/golos/", false));
                buttons.add(new AliceButtonDTO("йо1200", "Безлимит на соцсети и мессенджеры, 1 ГБ в роуминге", "http://life.com.by/private/voice/yo1200/", false));
                buttons.add(new AliceButtonDTO("Интернет", "", "http://life.com.by/x3/", false));
            }
        }

        if (StringUtils.isEmpty(responseText)) {
            responseText = "не понимаю о чем вы. могу рассказать про все наши тарифные планы";
        }


        return new AliceResponseDTO(
            new AliceResponsePayloadDTO(responseText, responseText, buttons, false),
            new AliceSessionDTO(request.getSession().getSessionId(), request.getSession().getMessageId(), request.getSession().getUserId()),
            request.getVersion()
        );
    }

}
