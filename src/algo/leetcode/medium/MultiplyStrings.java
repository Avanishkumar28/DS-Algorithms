package algo.leetcode.medium;

import java.util.Arrays;

/**
 * 43. Multiply Strings (https://leetcode.com/problems/multiply-strings/)
 **/

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        if("0".equals(num1) || "0".equals(num2))
            return "0";

        int[] arr = new int[num1.length()+num2.length()-1];
        for(int p2 = num2.length()-1; p2>=0; p2--){
            int n2 = num2.charAt(p2)-'0';
            for(int p1 = num1.length()-1; p1 >=0; p1--){
                int n1 = num1.charAt(p1)-'0';
                arr[p1+p2] += n1*n2;
            }
        }

        StringBuilder sb = new StringBuilder("");
        int carry = 0;
        for(int index = arr.length-1; index >= 0; index--){
            int n = arr[index]+carry;
            sb.append(n%10);
            carry = n/10;
        }
        if(carry > 0)
            sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String test1num1 = "2";
        String test1num2 = "3";
        //System.out.println(multiply(test1num1, test1num2)); //"6"

        String test2num1 = "123";
        String test2num2 = "456";
        //System.out.println(multiply(test2num1, test2num2)); //"56088"

        String test3num1 = "9";
        String test3num2 = "99";
        System.out.println(multiply(test3num1, test3num2)); //"891"
    }
}
