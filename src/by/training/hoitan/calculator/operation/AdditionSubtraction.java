package by.training.hoitan.calculator.operation;

import by.training.hoitan.calculator.service.Converter;

import java.util.List;

public class AdditionSubtraction {
    private final Converter converter;

    public AdditionSubtraction(Converter converter) {
        this.converter = converter;
    }

    public String plusMinus(String s) {
        double result = 0;
        List<String> component = converter.componentAddSub(s);
        for (String number : component) {
            result += Double.parseDouble(number);
        }
        return String.valueOf(result);
    }
}


