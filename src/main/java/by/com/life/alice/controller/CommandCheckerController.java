package by.com.life.alice.controller;


import by.com.life.alice.domain.PendingCommandType;
import by.com.life.alice.service.CommandRecognizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/checker")
public class CommandCheckerController {

    @Autowired
    private CommandRecognizerService recognizerService;


    @RequestMapping(method = RequestMethod.POST)
    public PendingCommandType checkCommand(@RequestBody String text) {
        return recognizerService.recognize(text);
    }

}
