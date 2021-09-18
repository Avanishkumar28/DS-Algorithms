package algo.leetcode.hard;

/**
282. Expression Add Operators
        Given a string num that contains only digits and an integer target,
        return all possibilities to add the binary operators '+', '-', or '*' between the digits of num
        so that the resultant expression evaluates to the target value.
Constraints:
        Binary Operators ['+', '-', '*']
        1 <= num.length <= 10
        num consists of only digits.
        -231 <= target <= 231 - 1
Example:
        Input: num = "123", target = 6
        Output: ["1*2*3","1+2+3"]
**/


import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        addOperators(num, target, result, 0, 0, 0, "");
        return result;
    }

    private static void addOperators(String num, int target, List<String> result, int index, long value, long previous, String current) {
        if(index == num.length()) {
            if(value + previous == target) {
                result.add(current);
            }
            return;
        }

        int end = num.length();
        if(num.charAt(index) == '0') {
            end = index + 1;
        }

        for(int i = index + 1; i <= end; i ++) {
            long currentValue = Long.valueOf(num.substring(index, i));

            if(index == 0) {
                addOperators(num, target, result, i, 0, currentValue, String.valueOf(currentValue));
                continue;
            }

            // Add +
            addOperators(num, target, result, i, value + previous, currentValue, current + "+" + currentValue);
            // Add -
            addOperators(num, target, result, i, value + previous, -currentValue, current + "-" + currentValue);
            // Add *
            addOperators(num, target, result, i, value, previous * currentValue, current + "*" + currentValue);
        }
    }

    public static void main(String[] args) {
        int target = 6;
        String num = "123";
        System.out.println(addOperators(num, 6));
    }
}
