package by.training.hoitan.calculator.service;

import by.training.hoitan.calculator.constant.RegularExp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class Converter {
    private int count;

    public int getCount() {
        return count;
    }

    public List<String> componentAddSub(String s) {
        List<String> component = new ArrayList<>();
        Matcher matcher = RegularExp.number.matcher(s);
        while (matcher.find()) {
            component.add(matcher.group());
        }
        return component;
    }

    public String multiplyByMinus(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        Matcher matcher = RegularExp.signMultSub.matcher(stringBuilder);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            stringBuilder.replace(start, end, "-" + matcher.group()
                    .replaceAll("\\*-", "*")
                    .replaceAll("/-", "/"));
            matcher.reset();
        }
        return stringBuilder.toString();
    }

    //-2+3*-2-4
    public List<String> componentDivAddMulSub(String s) {
        String multiplyByMinus = multiplyByMinus(s);
        String expression = multiplyByMinus
                .replaceAll("--", "+")
                .replaceAll("\\+-", "-");
        String[] split = expression.split("[+-]");
        if (expression.startsWith("+") || expression.startsWith("-")) {
            split[0] = "0";
        }
        List<String> component = new ArrayList<>(Arrays.asList(split));
        this.count = component.size();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                component.add(String.valueOf(expression.charAt(i)));
            }
        }
        return component;
    }
}
