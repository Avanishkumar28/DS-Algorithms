package algo.leetcode;

/**
 * 445. Add Two Numbers II (https://leetcode.com/problems/add-two-numbers-ii/)
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The most significant digit comes first and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * */

public class AddTwoNumber {

    public static int addTwoNumber(int[] num1, int[] num2){
        if (num1 == null && num1 == null)
            return 0;
        int result = 0;
        int counter = 0;
        int base = 1;
        int rem = 0;
        while (num1 != null && num1.length > counter
                && num2 != null && num2.length > counter){
            int sum = num1[counter] + num2[counter] + rem;
            int lastDigit = sum%10;
            result = (lastDigit * base) + result;
            rem = sum/10;
            base *= 10;
            counter++;
        }
        if (num1 != null && num1.length > counter ) {
            result = createNumber(num1, rem, result, counter, base);
            rem = 0;
        }
        if (num2 != null && num2.length > counter) {
            result = createNumber(num2, rem, result, counter, base);
            rem = 0;
        }
        result = (rem%10 * base) + result;
        return result;
    }

    private static int createNumber(int[] arr, int rem, int result, int counter, int base) {
        for (int i = counter; i<arr.length; i++){
            int num = arr[i] + rem;
            result = (num%10 * base) + result;
            rem = num/10;
            base *= 10;
        }
        result = (rem%10 * base) + result;
        return result;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{9,7,5}; //579
        int[] num2 = new int[]{4,3,8}; //834
        System.out.println(addTwoNumber(num1,num2)); //1413
        int[] test1num1 = new int[]{9,7,5}; //579
        System.out.println(addTwoNumber(test1num1,null)); //579
        int[] test2num2 = new int[]{4,3,8}; //834
        System.out.println(addTwoNumber(new int[]{},test2num2)); //834
    }
}
