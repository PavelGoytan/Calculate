package by.training.hoitan.calculator.service;

import by.training.hoitan.calculator.operation.AdditionSubtraction;
import by.training.hoitan.calculator.operation.DivisionMultiply;
import java.util.List;

public class ArithmeticExp {
    private final AdditionSubtraction add;
    private final DivisionMultiply div;
    private final Converter converter;

    public ArithmeticExp(AdditionSubtraction add, DivisionMultiply div, Converter converter) {
        this.add = add;
        this.div = div;
        this.converter = converter;
    }

    public String resultComplexExpression(String s) {
        List<String> component = converter.componentDivAddMulSub(s);
        StringBuilder stringBuilder = new StringBuilder();
        int count = converter.getCount();
        int end = count;
        for (String s1 : component) {
            if (end < component.size() + 1) {
                stringBuilder.append(div.divideMultiply(s1));
            }
            if (count < component.size()) {
                stringBuilder.append(component.get(count));
                count++;
            }
            end++;
        }
        return add.plusMinus(stringBuilder.toString());
    }
}