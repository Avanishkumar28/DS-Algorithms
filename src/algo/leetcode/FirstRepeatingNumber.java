package algo.leetcode;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatingNumber {

    //With extra space: Using Set
    public static int firstRepeatingNumber(int[] arr){
        if (arr == null)
            return -1;
        if (arr.length < 2)
            return arr[0];
        Set<Integer> seen = new HashSet<>();
        for (int num : arr){
            if (seen.add(num))
                continue;
            return num;
        }

        return -1;
    }

    //With extra space: Using Array
    public static int firstRepeatingNumberByArr(int[] arr){
        if (arr == null)
            return -1;
        if (arr.length < 2)
            return arr[0];
        int[] seen = new int[arr.length];
        for (int num : arr){
            if (seen[num-1] == 0) {
                seen[num-1] += 1;
                continue;
            }
            return num;
        }

        return -1;
    }

    //Without extra space
    public static int firstRepeatingNumberWithoutSpace(int[] arr){
        if (arr == null)
            return -1;
        if (arr.length < 2)
            return arr[0];
        for (int index = 0; index < arr.length; index++){
            int indexToUpdate = Math.abs(arr[index]);
            if (arr[indexToUpdate - 1] < 0)
                return Math.abs(arr[index]);
            else
                arr[indexToUpdate - 1] *=  -1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] test1Array = {1,3,4,5,1};
        System.out.println(firstRepeatingNumber(test1Array));
        System.out.println(firstRepeatingNumberByArr(test1Array));
        System.out.println(firstRepeatingNumberWithoutSpace(test1Array));
        int[] test2Array = {1,2,3,4,5};
        System.out.println(firstRepeatingNumber(test2Array));
        System.out.println(firstRepeatingNumberByArr(test2Array));
        System.out.println(firstRepeatingNumberWithoutSpace(test2Array));
        int[] test3Array = {1,2,3,4,5,3,2,1};
        System.out.println(firstRepeatingNumber(test3Array));
        System.out.println(firstRepeatingNumberByArr(test3Array));
        System.out.println(firstRepeatingNumberWithoutSpace(test3Array));
    }
}
