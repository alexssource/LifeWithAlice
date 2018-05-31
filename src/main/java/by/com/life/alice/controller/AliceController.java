package by.com.life.alice.controller;

import by.com.life.alice.command.AliceRequestCommand;
import by.com.life.alice.domain.*;
import by.com.life.alice.dto.AliceButtonDTO;
import by.com.life.alice.dto.AliceResponseDTO;
import by.com.life.alice.dto.AliceResponsePayloadDTO;
import by.com.life.alice.dto.AliceSessionDTO;
import by.com.life.alice.dto.v1.JSONLightSubscriber;
import com.opencsv.CSVReader;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@RestController
@RequestMapping(value = "/alice")
public class AliceController {

    private final List<TariffDescription> tariffs = new ArrayList<>(13);
    private final static Stack<PendingCommand> pendingCommands = new Stack<>();
//    private final static AliceKnowledge knowledge = new AliceKnowledge(sessionId);


    @PostConstruct
    public void init() throws IOException {
        String csvFile = "src/main/resources/tariffs.csv";
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile), ';', '"', 1);
            String[] line;
            while ((line = reader.readNext()) != null) {
                TariffDescription tariffDescription = new TariffDescription(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
                mapTiriff(line[0], tariffDescription);
                tariffs.add(tariffDescription);
            }
        }  catch (IOException e) {
            String file = "/opt/alice-prerelease/tariffs.csv";
            reader = new CSVReader(new FileReader(file), ';', '"', 1);
            String[] line;
            while ((line = reader.readNext()) != null) {
                TariffDescription tariffDescription = new TariffDescription(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
                mapTiriff(line[0], tariffDescription);
                tariffs.add(tariffDescription);
            }
        }
    }

    private void mapTiriff(String s, TariffDescription tariffDescription) {
        switch (s){
            case "Шейк 1":
                tariffDescription.setCode("SHK1");
                break;
            case "Шейк 2":
                tariffDescription.setCode("SHK2");
                break;
            case "Шейк 3":
                tariffDescription.setCode("SHK3");
                break;
            case "Шейк 4":
                tariffDescription.setCode("SHK4");
                break;
            case "Старт":
                tariffDescription.setCode("CRTBL");
                break;
            case "Семья 1":
                tariffDescription.setCode("SMP1");
                break;
            case "Семья 2":
                tariffDescription.setCode("SMP2");
                break;
            case "Семья 3":
                tariffDescription.setCode("SMP3");
                break;
            case "Мультинет":
                tariffDescription.setCode("SMPN");
                break;
            case "йо1200":
                tariffDescription.setCode("DL012");
                break;
            case "Голос 1":
                tariffDescription.setCode("XS");
                break;
            case "Голос 2":
                tariffDescription.setCode("V2");
                break;
            case "Интернет":
                tariffDescription.setCode("3GM");
                break;
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public AliceResponseDTO processCommand(@RequestBody AliceRequestCommand request) {
        System.out.println(request);

        return processText(request.getRequest().getCommand(), request);
    }

    private AliceResponseDTO processText(String command, AliceRequestCommand request) {
        if (!StringUtils.isEmpty(command)) {
            command = command.toLowerCase();
                if (command.toLowerCase().contains("тарифные планы") || command.toLowerCase().contains("тарифы")) {
                    if (command.toLowerCase().contains("все") || command.toLowerCase().contains("какие")) {
                        PendingCommand pendingCommand = new PendingCommand(PendingCommandType.SHOW_ALL_PLANS, null);
                        pendingCommands.add(pendingCommand);
                        return processStackCommand(request);
                    }
                } else if (command.contains("какой у меня тарифный план")) {
                    PendingCommand pendingCommand = new PendingCommand(PendingCommandType.SHOW_MY_PLAN, null);
                    pendingCommands.add(pendingCommand);
                    return processStackCommand(request);
                } else if (command.contains("смени тарифный план")) {
                    PendingCommand pendingCommand = new PendingCommand(PendingCommandType.CHANGE_PLAN, new Object[] { command });
                    pendingCommands.add(pendingCommand);
                    return processStackCommand(request);
                } else if (command.contains("тарифный план"))  {
                    for (TariffDescription tariff : tariffs) {
                        if (command.contains(tariff.getPlan().toLowerCase())) {
                            if (command.contains("цен")) {
                                PendingCommand pendingCommand = new PendingCommand(PendingCommandType.SHOW_PLAN_PRICE_INFO, new Object[] { tariff });
                                pendingCommands.add(pendingCommand);
                                return processStackCommand(request);
                            }
                            else if (command.contains("минут")) {
                                PendingCommand pendingCommand = new PendingCommand(PendingCommandType.SHOW_PLAN_MINUTES_INFO, new Object[] { tariff });
                                pendingCommands.add(pendingCommand);
                                return processStackCommand(request);
                            }
                            else if (command.contains("мегабайт")) {
                                PendingCommand pendingCommand = new PendingCommand(PendingCommandType.SHOW_PLAN_MEGABYTES_INFO, new Object[] { tariff });
                                pendingCommands.add(pendingCommand);
                                return processStackCommand(request);
                            } else {
                                PendingCommand pendingCommand = new PendingCommand(PendingCommandType.SHOW_PLAN_ALL_INFO, new Object[] { tariff });
                                pendingCommands.add(pendingCommand);
                                return processStackCommand(request);
                            }
                        }
                    }
                } else if (command.contains("375")) {
                    PendingCommand pendingCommand = new PendingCommand(PendingCommandType.REMEMBER_MSISDN, new Object[] { command });
                    pendingCommands.add(pendingCommand);
                    return processStackCommand(request);
                } else if ("да".equalsIgnoreCase(command.trim())) {
                    PendingCommand pendingCommand = new PendingCommand(PendingCommandType.LISTEN_YES, new Object[] { command });
                    pendingCommands.add(pendingCommand);
                    return processStackCommand(request);
                }

        }

        PendingCommand pendingCommand = new PendingCommand(PendingCommandType.UNKNOWN_COMMAND, null);
        pendingCommands.add(pendingCommand);
        return processStackCommand(request);
    }


    private AliceResponseDTO createResponse(String text, List<AliceButtonDTO> buttons, AliceRequestCommand request) {
        return new AliceResponseDTO(
                new AliceResponsePayloadDTO(text, text, buttons, false),
                new AliceSessionDTO(request.getSession().getSessionId(), request.getSession().getMessageId(), request.getSession().getUserId()),
                request.getVersion()
        );
    }


    public AliceResponseDTO processStackCommand(AliceRequestCommand request) {
        PendingCommand pendingCommand = pendingCommands.pop();

        switch (pendingCommand.getType()) {
            case SHOW_ALL_PLANS:
                return showAllPlans(pendingCommand, request);
            case SHOW_PLAN_PRICE_INFO:
                return showPlanPrice(pendingCommand, request);
            case SHOW_PLAN_MINUTES_INFO:
                return showPlanMinutes(pendingCommand, request);
            case SHOW_PLAN_MEGABYTES_INFO:
                return showPlanMegabytes(pendingCommand, request);
            case SHOW_PLAN_ALL_INFO:
                return showPlanAll(pendingCommand, request);
            case SHOW_MY_PLAN:
                return showMyPlan(pendingCommand, request);
            case ASK_MSISDN:
                return askMsisdn(pendingCommand, request);
            case REMEMBER_MSISDN:
                return rememberMsisdnAndProcessStack(pendingCommand, request);
            case CONFIRM_YOUR_PHONE:
                return confirmYourPhone(pendingCommand, request);
            case LISTEN_YES:
                return listenYes(pendingCommand, request);
            case CHANGE_PLAN:
                getKnowledge(request).setChanged(false);
                return changePlan(pendingCommand, request);
            case UNKNOWN_COMMAND:
                default:
                    return unknownCommand(pendingCommand, request);
        }

    }

    private AliceResponseDTO listenYes(PendingCommand pendingCommand, AliceRequestCommand request) {
        return processStackCommand(request);
    }

    private AliceKnowledge getKnowledge(AliceRequestCommand request) {
        return AliceKnowledgeHolder.getKnowledge(request.getSession().getSessionId());
    }

    private AliceResponseDTO changePlan(PendingCommand pendingCommand, AliceRequestCommand request) {
        if (!getKnowledge(request).hasMsisdn()) {
            pendingCommands.push(pendingCommand);
            PendingCommand askMsisdnCommand = new PendingCommand(PendingCommandType.ASK_MSISDN, null);
            pendingCommands.push(askMsisdnCommand);
            return processStackCommand(request);
        }

        String tokenOldAuth = MissaUtils.getTokenOldAuth(getKnowledge(request).getMsisdn());

        if (!getKnowledge(request).isChanged()) {
            FutureTask<Boolean> getProfileTask = new FutureTask<Boolean>(new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    System.out.println("Loading a profile...");
                    String[] command = ((String)pendingCommand.getArgs()[0]).split(" ");
                    boolean result = MissaUtils.changeTariff(tokenOldAuth,command[command.length]);
                    if(result) {
                        JSONLightSubscriber profile = MissaUtils.getProfile(tokenOldAuth);
                        getKnowledge(request).setProfile(profile);
                        getKnowledge(request).setChanged(true);
                        System.out.println("Profile is loaded: " + profile);
                    }
                    return result;
                }
            });
            Thread profileThread = new Thread(getProfileTask);
            profileThread.start();

            // TODO: ask about phonne
            pendingCommands.push(pendingCommand);

            PendingCommand confirmPhoneCommand = new PendingCommand(PendingCommandType.CONFIRM_YOUR_PHONE, null);
            pendingCommands.push(confirmPhoneCommand);
            return processStackCommand(request);
        } else {
            String codePlan = getKnowledge(request).getProfile().getTariff().getCode();
            String responseText = String.format("Ваш тарифный план изменен на %s", codePlan);
            return createResponse(responseText, null, request);
        }
    }

    private AliceResponseDTO confirmYourPhone(PendingCommand pendingCommand, AliceRequestCommand request) {
        String responseText = "Твой номер " + getKnowledge(request).getMsisdn() + ". Верно?";
        return createResponse(responseText, null, request);
    }

    private AliceResponseDTO rememberMsisdnAndProcessStack(PendingCommand pendingCommand, AliceRequestCommand request) {
        String msisdn = (String) pendingCommand.getArgs()[0];
        getKnowledge(request).setMsisdn(msisdn);
        return processStackCommand(request);
    }

    private AliceResponseDTO askMsisdn(PendingCommand pendingCommand, AliceRequestCommand request) {
        String responseText = "Какой у тебя номер телефона?";
        return createResponse(responseText, null, request);
    }

    private AliceResponseDTO showMyPlan(PendingCommand pendingCommand, AliceRequestCommand request) {
        if (!getKnowledge(request).hasMsisdn()) {
            pendingCommands.push(pendingCommand);
            PendingCommand askMsisdnCommand = new PendingCommand(PendingCommandType.ASK_MSISDN, null);
            pendingCommands.push(askMsisdnCommand);
            return processStackCommand(request);
        }

        String tokenOldAuth = MissaUtils.getTokenOldAuth(getKnowledge(request).getMsisdn());

        if (!getKnowledge(request).hasProfile()) {
            FutureTask<JSONLightSubscriber> getProfileTask = new FutureTask<JSONLightSubscriber>(new Callable<JSONLightSubscriber>() {
                @Override
                public JSONLightSubscriber call() throws Exception {
                    System.out.println("Loading a profile...");
                    JSONLightSubscriber profile = MissaUtils.getProfile(tokenOldAuth);
                    getKnowledge(request).setProfile(profile);
                    System.out.println("Profile is loaded: " + profile);
                    return profile;
                }
            });
//        JSONLightSubscriber profile = MissaUtils.getProfile(tokenOldAuth);
            System.out.println("Before future");
            Thread profileThread = new Thread(getProfileTask);
            profileThread.start();
            System.out.println("After future");

            // TODO: ask about phonne
            pendingCommands.push(pendingCommand);

            PendingCommand confirmPhoneCommand = new PendingCommand(PendingCommandType.CONFIRM_YOUR_PHONE, null);
            pendingCommands.push(confirmPhoneCommand);
            return processStackCommand(request);
        } else {
            String codePlan = getKnowledge(request).getProfile().getTariff().getCode();
            String responseText = String.format("Ваш тарифный план: %s на номер %s", codePlan, getKnowledge(request).getMsisdn());
            return createResponse(responseText, null, request);
        }
    }

    private AliceResponseDTO unknownCommand(PendingCommand pendingCommand, AliceRequestCommand request) {
        String responseText = "Я могу помочь рассказать про наши услуги, а также работать с ними, если вы являетесь наши абонентом. Примеры запросов: 'Какие есть тарифные планы?', 'Расскажи про тарифный план шейк 1', 'Сколько тарифный план голос 2 включает минут?' ";
        return createResponse(responseText, null, request);
    }

    private AliceResponseDTO showPlanAll(PendingCommand pendingCommand, AliceRequestCommand request) {
        TariffDescription tariff = (TariffDescription) pendingCommand.getArgs()[0];
        String responseText = String.format("Тарифный план %s стоит %s %s и включает в себя %s %s и %s %s",
                tariff.getPlan(), tariff.getPrice(), tariff.getPriceUnit(),
                tariff.getMinutes(), tariff.getMinutesUnit(),
                tariff.getInternetTraffic(), tariff.getInternetTrafficUnit());
        return createResponse(responseText, null, request);
    }

    private AliceResponseDTO showPlanMegabytes(PendingCommand pendingCommand, AliceRequestCommand request) {
        TariffDescription tariff = (TariffDescription) pendingCommand.getArgs()[0];
        String responseText = "Тарифный план " + tariff.getPlan() + " включает в себя " + tariff.getInternetTraffic() +" "+ tariff.getInternetTrafficUnit();
        return createResponse(responseText, null, request);
    }

    private AliceResponseDTO showPlanMinutes(PendingCommand pendingCommand, AliceRequestCommand request) {
        TariffDescription tariff = (TariffDescription) pendingCommand.getArgs()[0];
        String responseText = "Тарифный план " + tariff.getPlan() + " включает в себя " + tariff.getMinutes() + " " + tariff.getMinutesUnit();
        return createResponse(responseText, null, request);
    }

    private AliceResponseDTO showPlanPrice(PendingCommand pendingCommand, AliceRequestCommand request) {
        TariffDescription tariff = (TariffDescription) pendingCommand.getArgs()[0];
        String responseText = "Тарифный план " + tariff.getPlan() + " стоит " + tariff.getPrice() +" " + tariff.getPriceUnit();
        return createResponse(responseText, null, request);
    }


    private AliceResponseDTO showAllPlans(PendingCommand pendingCommand, AliceRequestCommand request) {
        String responseText = "У нас есть линейки тарифных планов Шейк, Голос, Семья, а также тарифные план Старт, йо1200 и Интернет";
        List<AliceButtonDTO> buttons = new ArrayList<>(tariffs.size());

        for (TariffDescription tariff : tariffs) {
            buttons.add(new AliceButtonDTO(tariff.getPlan(), tariff.getDescription(), tariff.getLink(), false));
        }

        return createResponse(responseText, buttons, request);
    }

}
