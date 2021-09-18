package algo.leetcode;

import java.util.*;

/**
350. Intersection of Two Arrays II
        Given two integer arrays nums1 and nums2,
        return an array of their intersection.
        Each element in the result must appear as many times as it shows in both arrays
        and you may return the result in any order.

Constraints:
        1 <= nums1.length, nums2.length <= 1000
        0 <= nums1[i], nums2[i] <= 1000
Example:
        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2,2]

        Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        Output: [4,9]
        Explanation: [9,4] is also accepted.
**/



public class IntersectionOfTwoArrays {

    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length < 1 ||nums2.length < 1)
            return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = 0, p2 = 0;
        List<Integer> resultList = new ArrayList<>();
        while(p1 < nums1.length || p2 < nums2.length){
            if(nums1[p1] == nums2[p2]){
                resultList.add(nums1[p1]);
                p1++;
                p2++;
            }else if(nums1[p1] > nums2[p2])
                p2++;
            else
                p1++;

        }

        return resultList.stream().mapToInt(i -> i).toArray();
    }

    //TODO: Not working for all test cases, need to fix code
    public static int[] intersectWithSet(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1)
            return null;
        List<Integer> resultList = new ArrayList<>();
        Set<Integer> arrSet = new HashSet<>();
        for (int n : nums1){
            arrSet.add(n);
        }

        for(int index = 0; index < nums2.length; index++){
            if(!arrSet.add(nums2[index])){
                resultList.add(nums2[index]);
            }
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,2,1};
        int[] b1 = new int[]{2,2};
        System.out.println(Arrays.toString(intersect(a1,b1)));
        //System.out.println(Arrays.toString(intersectWithSet(a1,b1)));
    }
}
