package algo.leetcode.medium;

public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length < 1)
            return 0;
        int result = 1;
        int maxSoFar = result;
        int firstMax = nums[0];
        int secondMax = firstMax;
        for(int index=1; index<nums.length; index++){
            if(firstMax < nums[index]){
                secondMax = firstMax;
                firstMax = nums[index];
                maxSoFar++;
                result = Math.max(result+(maxSoFar-1), result);
            }else if(secondMax < nums[index]){
                firstMax = nums[index];
            }else{
                result = Math.max(maxSoFar, result);
                maxSoFar = 1;
                firstMax = nums[index];
                secondMax = firstMax;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1nums = {10,9,2,5,3,7,101,18};
        //System.out.println(lengthOfLIS(test1nums)); //4
        int[] test2nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(test2nums)); //4
        int[] test3nums = {7,7,7,7,7,7,7};
        //System.out.println(lengthOfLIS(test3nums)); //1
    }
}
