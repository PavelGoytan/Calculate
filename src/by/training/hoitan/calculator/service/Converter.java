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

    //-2+3*2-4
    public List<String> componentDivAddMulSub(String s) {
        String s2 = s.replaceAll("--", "+").replaceAll("\\+-", "-");
        String[] split = s2.split("[+-]");
        if (s2.startsWith("+") || s2.startsWith("-")) {
            split[0] = "0";
        }
        List<String> component = new ArrayList<>(Arrays.asList(split));
        this.count = component.size();
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '+' || s2.charAt(i) == '-') {
                component.add(String.valueOf(s2.charAt(i)));
            }
        }
        return component;
    }
}
