package algo.leetcode.medium;

/**
494. Target Sum
        You are given an integer array nums and an integer target.

        You want to build an expression out of nums by adding one of
        the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

        * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
        and concatenate them to build the expression "+2-1".

        Return the number of different expressions that you can build, which evaluates to target.
Example:
        Input: nums = [1,1,1,1,1], target = 3
        Output: 5
        Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
        -1 + 1 + 1 + 1 + 1 = 3
        +1 - 1 + 1 + 1 + 1 = 3
        +1 + 1 - 1 + 1 + 1 = 3
        +1 + 1 + 1 - 1 + 1 = 3
        +1 + 1 + 1 + 1 - 1 = 3
**/


import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public static int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> memo = new HashMap<>();
        return findTargetSumWays(nums, target, 0, memo);
    }

    private static int findTargetSumWays(int[] nums, int target, int currIdx, Map<String, Integer> memo){
        if(target == 0 && currIdx == nums.length)
            return 1;
        if(currIdx >=  nums.length )
            return 0;
        String key = target +"_"+currIdx;
        if(memo.containsKey(key))
            return memo.get(key);

        int result1 = findTargetSumWays(nums, target-nums[currIdx], currIdx+1, memo);
        int result2 = findTargetSumWays(nums, target+nums[currIdx], currIdx+1, memo);

        int ways = result1 + result2;
        memo.put(key, ways);
        return ways;
    }

    public static void main(String[] args) {
        int[] test1Nums = new int[]{1,1,1,1,1};
        int test1Target = 3;
        System.out.println(findTargetSumWays(test1Nums,test1Target)); //5

        int[] test2Nums = new int[]{1};
        int test2Target = 1;
        System.out.println(findTargetSumWays(test2Nums,test2Target)); //1
    }
}
