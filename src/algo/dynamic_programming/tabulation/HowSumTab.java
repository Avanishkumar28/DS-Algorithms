package algo.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.List;

public class HowSumTab {

    /**
     * m - target sum
     * n - numbers.length
     * Time Complexity  => O(m*n*m) => O(m^2 * n)
     * Space Complexity => O(m)
     **/
    public static List<Integer> howSum(int target, int[] numbers){
        List<Integer>[] table = new List[target+1];
        //base case 0 can be created without using any number from the numbers
        table[0] = new ArrayList<>();

        for (int index = 0; index < table.length; index++){
            if (table[index] != null){
                for (int num : numbers){
                    if ((index + num) < table.length){
                        //create a new list from
                        List<Integer> ways = new ArrayList<>(table[index]);
                        //add current num
                        ways.add(num);
                        //replace old list with new one
                        table[index+num] = ways;
                    }
                }
            }
        }

        return table[target];
    }

    public static void main(String[] args) {
        int[] numbers1 = new int[]{2,3};
        int[] numbers2 = new int[]{4,5,3};
        int[] numbers3 = new int[]{2,4};
        int[] numbers4 = new int[]{2,5,3};
        int[] numbers5 = new int[]{7,14};
        System.out.println(howSum(7, numbers1)); //[2,2,3]
        System.out.println(howSum(7, numbers2)); //[3,4]
        System.out.println(howSum(7, numbers3)); //null
        System.out.println(howSum(8, numbers4)); //[3,5] or [2,2,2,2] or [2,3,3]
        System.out.println(howSum(300, numbers5)); //null
    }
}
