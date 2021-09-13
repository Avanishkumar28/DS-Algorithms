package algo.dynamic_programming;

import java.util.*;

public class HowSum {

    /**
     * m -> target sum
     * n -> numbers.length
     * time -> O(n^m * m)
     * Space -> O(m)
     **/
    public static List<Integer> howSumRecursive(int target, int[] numbers){
        if(target == 0)
            return new ArrayList<Integer>();
        if (target < 0)
            return null;
        for (int num : numbers){
            int remainder = target - num;
            List<Integer> remainderResult = howSumRecursive(remainder, numbers);
            if (remainderResult != null){
                remainderResult.add(num);
                return remainderResult;
            }
        }
        return null;
    }

    /**
     * m -> target sum
     * n -> numbers.length
     * time -> O(m * n * m) => O(n * m^2)
     * Space -> O(m^2)
     **/
    public static List<Integer> howSumMemo(int target, int[] numbers){
        Map<Integer, List<Integer>> memo = new HashMap<>();
        return howSMemo(target, numbers, memo);
    }
    private static List<Integer> howSMemo(int target, int[] numbers, Map<Integer, List<Integer>> memo){
        if (target == 0)
            return new ArrayList<>();
        if (target < 0)
            return null;
        if (memo.containsKey(target))
            return memo.get(target);

        for (int num : numbers){
            int remainder = target - num;
            List<Integer> remainderResult = howSMemo(remainder, numbers, memo);
            if (remainderResult != null){
                remainderResult.add(num);
                memo.put(remainder, remainderResult);
                return remainderResult;
            }
        }
        memo.put(target, null);
        return null;
    }


    public static void main(String[] args) {
        int[] numbers1 = new int[]{2,3,5};
        int[] numbers2 = new int[]{7,4,3};
        int[] numbers3 = new int[]{2,4};
        System.out.println(howSumRecursive(7, numbers1)); //[2,2,3] or [2,5]
        System.out.println(howSumRecursive(7, numbers3)); //null
        System.out.println(howSumRecursive(311, numbers2));
        System.out.println(howSumRecursive(87, numbers3)); //null
        System.out.println(howSumRecursive(0, numbers3)); //[]

        System.out.println(howSumMemo(147, numbers3));// null
    }
}
