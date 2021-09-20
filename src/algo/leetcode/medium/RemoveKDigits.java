package algo.leetcode.medium;

/**
402. Remove K Digits
        Given string num representing a non-negative integer num, and an integer k,
        return the smallest possible integer after removing k digits from num.
Example 1:
        Input: num = "1432219", k = 3
        Output: "1219"
        Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:
        Input: num = "10200", k = 1
        Output: "200"
        Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:
        Input: num = "10", k = 2
        Output: "0"
        Explanation: Remove all the digits from the number and it is left with nothing which is 0.
Constraints:
    1 <= k <= num.length <= 105
    num consists of only digits.
    num does not have any leading zeros except for the zero itself.
**/

import java.util.Stack;

public class RemoveKDigits {

    public static String removeKDigits(String num, int k) {
        if(num == null || k == 0)
            return num;

        Stack<Integer> stack = new Stack<>();
        for(int index = 0; index < num.length(); index++){
            while(!stack.isEmpty() && stack.peek() > num.charAt(index) - '0' && k != 0){
                stack.pop();
                k--;
            }
            if(stack.isEmpty() && num.charAt(index) == '0')
                continue;
            stack.push(num.charAt(index) - '0');
        }
        if(k>0){
            while(!stack.isEmpty() && k != 0){
                stack.pop();
                k--;
            }
        }
        if(stack.isEmpty())
            return "0";
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String test1 = "1432219";
        System.out.println(removeKDigits(test1, 3)); //"1219"
        String test2 = "10200";
        System.out.println(removeKDigits(test2,1)); //"200"
        String test3 = "10";
        System.out.println(removeKDigits(test3, 2)); //"0"
    }
}
