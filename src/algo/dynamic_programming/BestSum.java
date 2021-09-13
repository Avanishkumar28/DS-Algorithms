package algo.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {

    /**
     * m -> target sum
     * n -> numbers.length
     * time -> O(n^m * m)
     * Space -> O(m^2)
     **/
    public static List<Integer> bestSumRecursive(int target, int[] numbers){
        if (target == 0)
            return new ArrayList<>();
        if (target < 0)
            return null;

        List<Integer> bestResult = null;
        for (int num : numbers){
            int remainder = target - num;
            List<Integer> remainderResult = bestSumRecursive(remainder, numbers);
            if (remainderResult != null){
                List<Integer> resultSum = new ArrayList<>();
                resultSum.add(num);
                resultSum.addAll(remainderResult);
                if (bestResult == null || bestResult.size() > resultSum.size()){
                    bestResult = resultSum;
                }
            }

        }
        return bestResult;
    }

    /**
     * m -> target sum
     * n -> numbers.length
     * time -> O(m * n * m) => O(m^2 * n)
     * Space -> O(m^2)
    **/
    public static List<Integer> bestSumMemo(int target, int[] numbers){
        Map<Integer, List<Integer>> memo = new HashMap<>();
        return bestSumMemo(target, numbers, memo);
    }
    private static List<Integer> bestSumMemo(int target, int[] numbers, Map<Integer, List<Integer>> memo){
        if (target == 0)
            return new ArrayList<>();
        if (target < 0)
            return null;
        if (memo.containsKey(target))
            return memo.get(target);

        List<Integer> bestResult = null;
        for (int num : numbers){
            int remainder = target - num;
            List<Integer> remainderResult = bestSumMemo(remainder, numbers, memo);
            if (remainderResult != null){
                List<Integer> resultSum = new ArrayList<>();
                resultSum.add(num);
                resultSum.addAll(remainderResult);
                if (bestResult == null || bestResult.size() > resultSum.size()){
                    bestResult = resultSum;
                }
            }
        }
        memo.put(target, bestResult);
        return bestResult;
    }

    public static void main(String[] args) {
        int[] numbers1 = new int[]{2,3,5};
        int[] numbers2 = new int[]{4,3,5,7};
        int[] numbers3 = new int[]{4,5,7,15,20,25};

        System.out.println(bestSumRecursive(7, numbers1)); //[2,5]
        System.out.println(bestSumRecursive(7, numbers2)); //[7]
        System.out.println(bestSumRecursive(15, numbers2)); //[4,4,7]

        long start = System.currentTimeMillis();
        System.out.println(bestSumRecursive(100, numbers3)); //[25,25,25,25]
        long end = System.currentTimeMillis();
        System.out.println("Time Taken by Recursive: "+(end-start)+"ms");

        long startMemo = System.currentTimeMillis();
        System.out.println(bestSumMemo(100, numbers3)); //[25,25,25,25]
        long endMemo = System.currentTimeMillis();
        System.out.println("Time Taken by Memo Function: "+(endMemo-startMemo)+"ms");
    }
}
