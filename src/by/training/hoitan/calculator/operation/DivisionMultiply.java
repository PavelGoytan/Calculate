package by.training.hoitan.calculator.operation;

public class DivisionMultiply {

    public String divideMultiply(String s) {
        double res;
        String[] split = s.split("[*/]");
        res = Double.parseDouble(split[0]);
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                res *= Double.parseDouble(split[count]);
                count++;
            } else if (s.charAt(i) == '/') {
                if(Double.parseDouble(split[count])==0){
                    throw new RuntimeException("DENOMINATOR IS ZERO");
                }
                res /= Double.parseDouble(split[count]);
                count++;
            }
        }
        return String.valueOf(res);
    }
}
