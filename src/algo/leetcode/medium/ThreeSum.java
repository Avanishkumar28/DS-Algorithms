package algo.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum (https://leetcode.com/problems/3sum/)
 * */

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for(int index = 0; index<nums.length; index++){
            if(index == 0 || (index>0 && nums[index] != nums[index-1])){
                int l = index+1;
                int h = nums.length-1;
                int sum = 0 - nums[index];

                while(l<h){
                    if(nums[l]+nums[h] == sum){
                        result.add(Arrays.asList(nums[index],nums[l],nums[h]));
                        while(l<h && (nums[l] == nums[l+1])) l++;
                        while(l<h && (nums[h] == nums[h-1])) h--;
                        l++;
                        h--;
                    }else if(nums[l]+nums[h] < sum){
                        l++;
                    }else{
                        h--;
                    }
                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] test1Array = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(test1Array));

        int[] test2Array = {};
        System.out.println(threeSum(test2Array));
    }
}
