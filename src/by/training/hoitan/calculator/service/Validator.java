package by.training.hoitan.calculator.service;

import by.training.hoitan.calculator.constant.RegularExp;
import java.util.regex.Matcher;

public class Validator {
    private final String expression;

    public Validator(String expression) {
        this.expression = expression;
    }

    public boolean checkHaveLetter() {
        String s = expression.replaceAll("\\s+", "");
        Matcher matcher = RegularExp.letter.matcher(s);
        return !matcher.find();
    }

    public boolean checkHavePunkt() {
        Matcher matcher = RegularExp.badSing.matcher(expression);
        return !matcher.find();
    }

    public boolean checkBracket() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(' || expression.charAt(i) == ')') {
                stringBuilder.append(expression.charAt(i));
            }
        }
        Matcher matcher = RegularExp.bracket.matcher(stringBuilder);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            stringBuilder.replace(start, end, "");
            matcher.reset();
        }
        return stringBuilder.length() == 0;
    }

    public StringBuilder wrightExpression() {
        String s;
        StringBuilder stringBuilder = new StringBuilder();
        if (checkHaveLetter() && checkHavePunkt() && checkBracket()) {
            s = expression.replaceAll("\\(\\)", "")
                    .replaceAll("--", "+")
                    .replaceAll("\\+-", "-")
                    .replaceAll("-\\+", "-")
                    .replaceAll("\\+\\+", "+");
            stringBuilder.append(s);

        } else {
            throw new RuntimeException("UNCORRECTED EXPRESSION");
        }
        return stringBuilder;
    }
}