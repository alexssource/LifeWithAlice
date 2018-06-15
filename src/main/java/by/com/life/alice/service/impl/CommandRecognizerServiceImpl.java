package by.com.life.alice.service.impl;

import by.com.life.alice.domain.CommandPattern;
import by.com.life.alice.domain.PendingCommandType;
import by.com.life.alice.service.CommandRecognizerService;
import by.com.life.alice.utils.TemplateChecker;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Slf4j
public class CommandRecognizerServiceImpl implements CommandRecognizerService {
    private final List<TemplateChecker> templateCheckers;


    public CommandRecognizerServiceImpl() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CommandPattern>> mapType = new TypeReference<List<CommandPattern>>() {};
        InputStream is = TypeReference.class.getResourceAsStream("/commands.json");

        try {
            List<CommandPattern> commandPatterns = objectMapper.readValue(is, mapType);
            templateCheckers = new ArrayList<>(commandPatterns.size());
            commandPatterns.forEach(commandPattern -> templateCheckers.add(new TemplateChecker(commandPattern)));
        } catch (IOException e) {
            log.error("Error loading command patters", e);
            throw new RuntimeException(e);
        }
    }


    @Override
    public PendingCommandType recognize(String text) {
        Optional<TemplateChecker> commandType = templateCheckers.stream()
                .filter(templateChecker -> templateChecker.checkText(text)).findAny();
        return commandType.isPresent() ? commandType.get().getCommandPattern().getCommand() : PendingCommandType.UNKNOWN_COMMAND;
    }
}
