package by.training.hoitan.calculator;

import by.training.hoitan.calculator.constant.RegularExp;
import by.training.hoitan.calculator.operation.AdditionSubtraction;
import by.training.hoitan.calculator.operation.DivisionMultiply;
import by.training.hoitan.calculator.service.ArithmeticExp;
import by.training.hoitan.calculator.service.Converter;
import by.training.hoitan.calculator.service.Validator;

import java.util.regex.Matcher;

public class Calculate {
    private final ArithmeticExp arithmeticExp;
    private final Validator validator;

    public Calculate() {
        Converter converter = new Converter();
        DivisionMultiply div = new DivisionMultiply();
        AdditionSubtraction add = new AdditionSubtraction(converter);
        this.arithmeticExp = new ArithmeticExp(add, div, converter);
        this.validator = new Validator();
    }

    public String solveExpression(String expression) {
        validator.setExpression(expression);
        StringBuilder stringBuilder = validator.wrightExpression();
        Matcher matcher = RegularExp.expressionInBracket.matcher(stringBuilder);
        while (stringBuilder.toString().contains("(")) {
            while (matcher.find()) {
                int start = matcher.start();
                int end = matcher.end();
                stringBuilder.replace(start, end, arithmeticExp
                        .resultComplexExpression(matcher.group()
                                .replaceAll("[()]", "")));
                matcher.reset();
            }
        }
        return arithmeticExp.resultComplexExpression(stringBuilder.toString());
    }
}

