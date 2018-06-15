package by.com.life.alice.utils;


import by.com.life.alice.domain.CommandPattern;
import by.com.life.alice.domain.PendingCommandType;
import org.junit.Assert;
import org.junit.Test;


public class TemplateCheckerTest {

    @Test
    public void testCheckSimpleTemplate() {
        final String template = "[Text][асфальт]+";
        final String text = "Солнце светило так ярко, что на асфальте была видна каждая трещина";
        TemplateChecker checker = new TemplateChecker(new CommandPattern(PendingCommandType.ABOUT, template));

        boolean result = checker.checkText(text);
        Assert.assertTrue(result);
    }


    @Test
    public void testCheckTemplateWithSimpleLogic() {
        final String template = "[Text][асфальт]+[Text][трещин]+&";
        final String text = "Солнце светило так ярко, что на асфальте была видна каждая трещина";
        TemplateChecker checker = new TemplateChecker(new CommandPattern(PendingCommandType.ABOUT, template));

        boolean result = checker.checkText(text);
        Assert.assertTrue(result);
    }


    @Test
    public void testCheckTemplateWithComplex() {
        final String template = "[Text][асфальт]+[Text][трещин]+&[Text][кажд]+?[Text][не был]-&[Text][единая]-&";
        final String positiveText1 = "Солнце светило так ярко, что на асфальте была видна каждая трещина";
        final String positiveText2 = "Солнце светило так ярко, что каждая трещина сияла на асфальте";
        final String negativeText1 = "Солнце светило так ярко, что трещин нет";
        final String negativeText2 = "Солнце светило так ярко, что на асфальте была видна ни единая трещина";
        final String negativeText3 = "Солнце закрыло затмение так, что на каждом асфальте за горизонтом не было видно трещин";
        TemplateChecker checker = new TemplateChecker(new CommandPattern(PendingCommandType.ABOUT, template));

        boolean resultPositive1 = checker.checkText(positiveText1);
        boolean resultPositive2 = checker.checkText(positiveText2);
        boolean resultNegative1 = checker.checkText(negativeText1);
        boolean resultNegative2 = checker.checkText(negativeText2);
        boolean resultNegative3 = checker.checkText(negativeText3);

        Assert.assertTrue(resultPositive1);
        Assert.assertTrue(resultPositive2);
        Assert.assertFalse(resultNegative1);
        Assert.assertFalse(resultNegative2);
        Assert.assertFalse(resultNegative3);
    }


    @Test
    public void testAliceIntoQuestions() {
        final String template = "[Text][ты]+[Text][кто]+?[Text][что]+?[Text][сначала]+?[Text][умеешь]+?[Text][назад]+?[Text][себ]+?[Text][тариф]-&[Text][план]-&[Text][баланс]-&";
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
        TemplateChecker checker = new TemplateChecker(new CommandPattern(PendingCommandType.ABOUT, template));

        boolean resultPositive1 = checker.checkText(positiveText1);
        boolean resultPositive2 = checker.checkText(positiveText2);
        boolean resultPositive3 = checker.checkText(positiveText3);
        boolean resultPositive4 = checker.checkText(positiveText4);
        boolean resultPositive5 = checker.checkText(positiveText5);
        boolean resultNegative1 = checker.checkText(negativeText1);
        boolean resultNegative2 = checker.checkText(negativeText2);
        boolean resultNegative3 = checker.checkText(negativeText3);
        boolean resultNegative4 = checker.checkText(negativeText4);
        boolean resultNegative5 = checker.checkText(negativeText5);

        Assert.assertTrue(resultPositive1);
        Assert.assertTrue(resultPositive2);
        Assert.assertTrue(resultPositive3);
        Assert.assertTrue(resultPositive4);
        Assert.assertTrue(resultPositive5);
        Assert.assertFalse(resultNegative1);
        Assert.assertFalse(resultNegative2);
        Assert.assertFalse(resultNegative3);
        Assert.assertFalse(resultNegative4);
        Assert.assertFalse(resultNegative5);
    }

}
