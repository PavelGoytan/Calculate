package by.training.hoitan.calculator.constant;

import java.util.regex.Pattern;

public class RegularExp {
    public static Pattern number = Pattern.compile("[+-]?[0-9]+(\\.[0-9]+)?");
    public static Pattern badSing = Pattern.compile("-\\*|\\*-|-/|/-|(\\d+(\\.\\d+)?)?[*/]\\)|\\([*/](\\d+(\\.\\d+)?)?");
    public static Pattern letter = Pattern.compile("[^./*\\-+()\\d]");
    public static Pattern bracket = Pattern.compile("\\(\\)");
    public static Pattern expressionInBracket = Pattern.compile("\\((([-+/*]+)?[0-9]+(\\.[0-9]+)?)+\\)");
    public static Pattern signMultSub = Pattern.compile("[0-9]+(\\.[0-9]+)?[*/]-[0-9]+(\\.[0-9]+)?");
}
