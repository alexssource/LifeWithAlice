package by.com.life.alice.controller;

import by.com.life.alice.command.AliceRequestCommand;
import by.com.life.alice.domain.TariffDescription;
import by.com.life.alice.dto.AliceButtonDTO;
import by.com.life.alice.dto.AliceResponseDTO;
import by.com.life.alice.dto.AliceResponsePayloadDTO;
import by.com.life.alice.dto.AliceSessionDTO;
import com.opencsv.CSVReader;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/alice")
public class AliceController {

    private final List<TariffDescription> tariffs = new ArrayList<>(13);

    @PostConstruct
    public void init() throws IOException {
        String csvFile = "src/main/resources/tariffs.csv";
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFile), ';', '"', 1);
            String[] line;
            while ((line = reader.readNext()) != null) {
                TariffDescription tariffDescription = new TariffDescription(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
                tariffs.add(tariffDescription);
            }
        }  catch (IOException e) {
            String file = "/opt/alice-prerelease/tariffs.csv";
            reader = new CSVReader(new FileReader(file), ';', '"', 1);
            String[] line;
            while ((line = reader.readNext()) != null) {
                TariffDescription tariffDescription = new TariffDescription(line[0], line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]);
                tariffs.add(tariffDescription);
            }
        }
    }


    @RequestMapping(method = RequestMethod.POST)
    public AliceResponseDTO processCommand(@RequestBody AliceRequestCommand request) {
        System.out.println(request);

        return processText(request.getRequest().getCommand(), request);
    }

    private AliceResponseDTO processText(String command, AliceRequestCommand request) {
        String responseText = null;
        List<AliceButtonDTO> buttons = null;

        if (!StringUtils.isEmpty(command)) {
            command = command.toLowerCase();
                if (command.toLowerCase().contains("тарифные планы")) {
                    if (command.toLowerCase().contains("все") || command.toLowerCase().contains("какие")) {
                        responseText = "У нас есть линейки тарифных планов Шейк, Голос, Семья, а также тарифные план Старт, йо1200 и Интернет";
                        buttons = new ArrayList<>(tariffs.size());

                        for (TariffDescription tariff : tariffs) {
                            buttons.add(new AliceButtonDTO(tariff.getPlan(), tariff.getDescription(), tariff.getLink(), false));
                        }
                    }
                } else if (command.contains("тарифный план"))  {
                    for (TariffDescription tariff : tariffs) {
                        if (command.contains(tariff.getPlan().toLowerCase())) {

                            if (command.contains("цен")) {
                                responseText = "Тарифный план " + tariff.getPlan() + " стоит " + tariff.getPrice() +" " + tariff.getPriceUnit();
                            }
                            else if (command.contains("минут")) {
                                responseText = "Тарифный план " + tariff.getPlan() + " включает в себя " + tariff.getMinutes() + " " + tariff.getMinutesUnit();
                            }
                            else if (command.contains("мегабайт")) {
                                responseText = "Тарифный план " + tariff.getPlan() + " включает в себя " + tariff.getInternetTraffic() +" "+ tariff.getInternetTrafficUnit();
                            } else {

                                responseText = String.format("Тарифный план %s стоит %s %s и включает в себя %s %s и %s %s",
                                        tariff.getPlan(), tariff.getPrice(), tariff.getPriceUnit(),
                                        tariff.getMinutes(), tariff.getMinutesUnit(),
                                        tariff.getInternetTraffic(), tariff.getInternetTrafficUnit());

                            }

                            break;
                        }
                    }
                }

        }

        if (StringUtils.isEmpty(responseText)) {
            responseText = "Я могу помочь рассказать про наши услуги, а также работать с ними, если вы являетесь наши абонентом.";
        }


        return new AliceResponseDTO(
            new AliceResponsePayloadDTO(responseText, responseText, buttons, false),
            new AliceSessionDTO(request.getSession().getSessionId(), request.getSession().getMessageId(), request.getSession().getUserId()),
            request.getVersion()
        );
    }

}
