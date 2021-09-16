package algo.leetcode;
/**
978. Longest Turbulent Subarray (https://leetcode.com/problems/longest-turbulent-subarray/)
        Given an integer array arr, return the length of a maximum size turbulent subarray of arr
        A subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:

        For i <= k < j:
        arr[k] > arr[k + 1] when k is odd, and
        arr[k] < arr[k + 1] when k is even.
        Or, for i <= k < j:
        arr[k] > arr[k + 1] when k is even, and
        arr[k] < arr[k + 1] when k is odd.
Example:
        Input: arr = [9,4,2,10,7,8,8,1,9]
        Output: 5
        Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]

        Input: arr = [4,8,12,16]
        Output: 2
**/

public class MaxTurbulentSubarray {

    public static int maxTurbulenceSize(int[] arr) {
        if(arr == null || arr.length == 0)
            return 0;
        if(arr.length == 1)
            return 1;
        int[] memo = new int[2];
        memo[0] = 1;
        memo[1] = (arr[0] == arr[1]) ? 1 : 2;
        int turbule = memo[1];
        for(int index = 2; index < arr.length; index++){
            if(arr[index-2] < arr[index-1] && arr[index-1] > arr[index])
                memo[1] = memo[1] + 1;
            else if(arr[index-2] > arr[index-1] && arr[index-1] < arr[index])
                memo[1] = memo[1] + 1;
            else if(arr[index-1] != arr[index])
                memo[1] = 2;

            turbule = Math.max(turbule, memo[1]);
        }

        return turbule;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{9,4,2,10,7,8,8,1,9};
        int[] test2 = new int[]{4,8,12,16};
        int[] test3 = new int[]{900};

        System.out.println(maxTurbulenceSize(test1)); //5
        System.out.println(maxTurbulenceSize(test2)); //2
        System.out.println(maxTurbulenceSize(test3)); //1
    }
}
