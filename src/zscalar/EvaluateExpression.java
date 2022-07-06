package zscalar;

/**
 * input = "1+2-3+78+9" => [1, +, 2, -, 3, +, 7, 8, +, 9]
 * output(int) = 87
 * */

public class EvaluateExpression {

    public static int calculate(String input){
        if(input == null || "".equals(input))
            return 0;
        int num1 = 0;
        int num2 = 0;
        int base = 10;
        String ops = "";
        for (char c : input.toCharArray()){
            if(!Character.isDigit(c)){
                num1 = doOps(num1 , num2, ops);
                num2 = 0;
                ops = c+"";
            }else {
                if (ops.equals("")){
                    num1 = num1 * base + Integer.valueOf(c+"");
                }else{
                    num2 = num2 * base + Integer.valueOf(c+"");
                }
            }
        }
        return doOps(num1 , num2, ops);
    }
    private static int doOps(int num1, int num2, String ops){
        switch (ops){
            case "+":
                return num1+num2;
            case "-":
                return num1-num2;
            default:
                System.out.println("Invalid Operation");
                return num1;
        }
    }

    public static void main(String[] args) {
        String input = "1+2-3+78+9";
        System.out.println(calculate(input)); //87
    }
}
