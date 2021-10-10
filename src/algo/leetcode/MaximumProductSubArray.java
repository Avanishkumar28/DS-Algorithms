package algo.leetcode;

import java.util.Arrays;

/**
 * 152. Maximum Product SubArray (https://leetcode.com/problems/maximum-product-subarray/)
**/

public class MaximumProductSubArray {

    public static int maxProduct(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length < 2)
            return nums[0];

        int result = nums[0];
        int currMin = 1, currMax = 1;
        for(int num : nums){
            int temp = currMax * num;
            currMax = Math.max(Math.max(currMin * num, currMax * num), num);
            currMin = Math.min(Math.min(currMin * num, temp), num);

            result = Math.max(result, currMax);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test1Array = {2,3,-2,4};
        System.out.println("MaximumProductSubArray of array "+ Arrays.toString(test1Array) +" >> "+maxProduct(test1Array));

        int[] test2Array = {-2,0,-1};
        System.out.println("MaximumProductSubArray of array "+ Arrays.toString(test2Array) +" >> "+maxProduct(test2Array));
    }
}
