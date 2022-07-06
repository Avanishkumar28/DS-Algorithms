package algo.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 *         https://leetcode.com/problems/permutations/
 */

public class Permutations {
    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, nums.length-1, result);
        return result;
    }
    private static void permute(int[] nums, int s, int e, List<List<Integer>> result){
        if (s == e){
            List<Integer> list = new ArrayList<>();
            for(int num : nums)
                list.add(num);
            result.add(list);
        }else{   
            for (int i = s; i <= e; i++){   
                //calling user-defined swapping method  
                swapNum(nums, s, i);   
                //calling permutation() method  
                permute(nums, s+1, e, result);
                swapNum(nums, s, i);   
            }   
        }   
    }   
    //user-defined method to swap characters  
    private static void swapNum(int[] nums, int i, int j){
        int temp = nums[i] ;   
        nums[i] = nums[j];   
        nums[j] = temp;     
    }

    public static void main(String[] args) {
        int[] test1 = {1,2,3};
        System.out.println(permutations(test1));
    }
}