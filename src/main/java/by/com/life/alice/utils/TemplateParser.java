package by.com.life.alice.utils;

import java.util.ArrayList;
import java.util.List;


public class TemplateParser {
    public static List<String> parse(String template) {
        List<String> list = new ArrayList<>();
        int operandStartIdx = -1;

        for (int i = 0; i < template.length(); i++) {
            if (operandStartIdx > -1) {
                if (']' != template.charAt(i)) {
                    // waiting for the end bracket ]
                    continue;
                } else {
                    list.add(template.substring(operandStartIdx, i + 1));
                    operandStartIdx = -1;
                    continue;
                }
            }

            if ('[' == template.charAt(i)) {
                operandStartIdx = i;
            } else {
                // there is should be an operation symbol
                list.add(template.substring(i, i + 1));
            }
        }

        return list;
    }
}
