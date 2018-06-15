package by.com.life.alice.utils;


import by.com.life.alice.domain.CommandPattern;

import java.util.List;
import java.util.Stack;


public class TemplateChecker {
    private final CommandPattern commandPattern;
    private final List<String> parameters;


    public TemplateChecker(CommandPattern commandPattern) {
        this.commandPattern = commandPattern;
        this.parameters = TemplateParser.parse(commandPattern.getPattern());
    }


    public boolean checkText(String text) {
        text = text.toLowerCase().trim();
        Stack<Object> stack = new Stack<>();

        for(String param : parameters) {
            if (!isBinaryOperator(param)) {
                stack.push(param);
            } else {
                boolean opResult = processBinaryOperation(param.toCharArray()[0], stack.pop(), stack.pop(), text);
                stack.push(opResult);
            }
        }

        return (boolean) stack.pop();
    }


    public CommandPattern getCommandPattern() {
        return commandPattern;
    }


    private boolean processBinaryOperation(char operation, Object operand1, Object operand2, final String text) {
        switch (operation) {
            case '+':
            case '-':
                String arg1 = prepareArgumentString(text, (String) operand2);
                String arg2 = prepareArgumentString(text, (String) operand1);
                return checkBinaryStringExpression(arg1, arg2, operation);
            case '?':
            case '&':
                return checkBinaryBooleanExpression((boolean) operand1, (boolean) operand2, operation);
            default:
                throw new IllegalArgumentException(String.format("Could not recognize operation [%s] with operands [%s] and [%s]",
                        operation, operand1, operand2));
        }
    }


    private boolean isBinaryOperator(final String el) {
        switch (el) {
            case "+":
            case "-":
            case "?":
            case "&":
                return true;
        }
        return false;
    }


    private String prepareArgumentString(final String text, String argument) {
        if ("[Text]".equalsIgnoreCase(argument)) {
            return text;
        }

        if (argument.startsWith("[")) {
            return argument.substring(1, argument.length() - 1).toLowerCase();
        }

        return argument.toLowerCase();
    }


    private boolean checkBinaryStringExpression(String arg1, String arg2, char operation) {
        switch (operation) {
            case '+':
                return arg1.contains(arg2);
            case '-':
                return !arg1.contains(arg2);
            default:
                throw new IllegalArgumentException(String.format("Unknown operation [%c]", operation));
        }
    }


    private boolean checkBinaryBooleanExpression(boolean arg1, boolean arg2, char operation) {
        switch (operation) {
            case '?':
                return arg1 || arg2;
            case '&':
                return arg1 && arg2;
            default:
                throw new IllegalArgumentException(String.format("Unknown operation [%c]", operation));
        }
    }
}
