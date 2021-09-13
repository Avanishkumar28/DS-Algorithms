package algo.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    /**
     * m -> target sum
     * n -> numbers.length
     * time -> O(n^m)
     * Space -> O(m)
     **/
    public static boolean canSum(int target, int[] numbers){
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        for (int num : numbers){
            int remainder = target - num;
            if(canSum(remainder, numbers))
                return true;
        }
        return false;
    }

    /**
     * m -> target sum
     * n -> numbers.length
     * time -> O(m * n)
     * Space -> O(m)
     **/
    public static boolean canSumMemo(int target, int[] numbers){
        Map<Integer, Boolean> memo = new HashMap<>();
        return canSMemo(target, numbers, memo);
    }
    private static boolean canSMemo(int target, int[] numbers, Map<Integer, Boolean> memo){
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        if(memo.containsKey(target))
            return memo.get(target);
        for (int num : numbers){
            int remainder = target - num;
            if(canSMemo(remainder, numbers, memo)){
                memo.put(remainder, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        int[] numbers1 = new int[]{2,3,5};
        int[] numbers2 = new int[]{7,14};
        int[] numbers3 = new int[]{2,4};
        System.out.println(canSum(8, numbers1)); //true
        System.out.println(canSum(8, numbers3)); //true
        System.out.println(canSum(7, numbers3)); //false
        System.out.println(canSum(7, numbers2)); //true
        System.out.println(canSum(300, numbers2)); //false
        System.out.println(canSumMemo(300, numbers2)); //false

    }
}
