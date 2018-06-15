package by.com.life.alice;

import by.com.life.alice.domain.PendingCommandType;
import by.com.life.alice.service.impl.CommandRecognizerServiceImpl;
import by.com.life.alice.utils.TemplateChecker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CommandRecognizerServiceTest {

    @Autowired
    private CommandRecognizerServiceImpl recognizerService;


    @Test
    public void testInit() {
        List<TemplateChecker> templateCheckers = (List<TemplateChecker>) ReflectionTestUtils.getField(recognizerService,"templateCheckers");
        Assert.assertNotNull(templateCheckers);
        Assert.assertTrue(!templateCheckers.isEmpty());
    }


    @Test
    public void testAboutCommand() {
        final String positiveText1 = "Алиса, ты кто?";
        final String positiveText2 = "Расскажи, что умеешь делать?";
        final String positiveText3 = "На шаг назад";
        final String positiveText4 = "Все сначала";
        final String positiveText5 = "Расскажи о себе";
        final String negativeText1 = "Алиса, вчера было завтра?";
        final String negativeText2 = "Пряник?";
        final String negativeText3 = "Алиса, ты умеешь делать план?";
        final String negativeText4 = "Алиса, ты кто, расскажи о своем тарифе";
        final String negativeText5 = "Алиса, твой баланс составляет ноль рублей?";

        PendingCommandType resultPositive1 = recognizerService.recognize(positiveText1);
        PendingCommandType resultPositive2 = recognizerService.recognize(positiveText2);
        PendingCommandType resultPositive3 = recognizerService.recognize(positiveText3);
        PendingCommandType resultPositive4 = recognizerService.recognize(positiveText4);
        PendingCommandType resultPositive5 = recognizerService.recognize(positiveText5);
        PendingCommandType resultNegative1 = recognizerService.recognize(negativeText1);
        PendingCommandType resultNegative2 = recognizerService.recognize(negativeText2);
        PendingCommandType resultNegative3 = recognizerService.recognize(negativeText3);
        PendingCommandType resultNegative4 = recognizerService.recognize(negativeText4);
        PendingCommandType resultNegative5 = recognizerService.recognize(negativeText5);

        Assert.assertEquals(PendingCommandType.ABOUT, resultPositive1);
        Assert.assertEquals(PendingCommandType.ABOUT, resultPositive2);
        Assert.assertEquals(PendingCommandType.ABOUT, resultPositive3);
        Assert.assertEquals(PendingCommandType.ABOUT, resultPositive4);
        Assert.assertEquals(PendingCommandType.ABOUT, resultPositive5);
        Assert.assertEquals(PendingCommandType.UNKNOWN_COMMAND, resultNegative1);
        Assert.assertEquals(PendingCommandType.UNKNOWN_COMMAND, resultNegative2);
        Assert.assertEquals(PendingCommandType.UNKNOWN_COMMAND, resultNegative3);
        Assert.assertEquals(PendingCommandType.UNKNOWN_COMMAND, resultNegative4);
        Assert.assertEquals(PendingCommandType.UNKNOWN_COMMAND, resultNegative5);
    }
}
