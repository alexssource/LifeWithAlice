package by.com.life.alice.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;


public class TemplateParserTest {

    @Test
    public void testParseSimpleTemplate() {
        final String template = "[Text][argument1]+";
        List<String> params = TemplateParser.parse(template);

        Assert.assertNotNull(params);
        Assert.assertEquals(3, params.size());
        Assert.assertEquals("[Text]", params.get(0));
        Assert.assertEquals("[argument1]", params.get(1));
        Assert.assertEquals("+", params.get(2));
    }


    @Test
    public void testComplexTemplate() {
        final String template = "[Text][argument1]+[Text][argument2]-&[Text][argument3]-?";
        List<String> params = TemplateParser.parse(template);

        Assert.assertNotNull(params);
        Assert.assertEquals(11, params.size());
        Assert.assertEquals("[Text]", params.get(0));
        Assert.assertEquals("[argument1]", params.get(1));
        Assert.assertEquals("+", params.get(2));
        Assert.assertEquals("[Text]", params.get(3));
        Assert.assertEquals("[argument2]", params.get(4));
        Assert.assertEquals("-", params.get(5));
        Assert.assertEquals("&", params.get(6));
        Assert.assertEquals("[Text]", params.get(7));
        Assert.assertEquals("[argument3]", params.get(8));
        Assert.assertEquals("-", params.get(9));
        Assert.assertEquals("?", params.get(10));
    }

}
