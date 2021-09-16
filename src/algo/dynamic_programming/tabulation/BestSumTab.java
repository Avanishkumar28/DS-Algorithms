package algo.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.List;

public class BestSumTab {

    /**
     * m - target sum
     * n - numbers.length
     * Time Complexity  => O(m*n*m) => O(m^2 * n)
     * Space Complexity => O(m)
     **/
    public static List<Integer> bestSum(int target, int[] numbers){
        List<Integer>[] table = new List[target+1];
        //base case: sum 0 can be construct without using any number for numbers
        table[0] = new ArrayList<>();

        for (int index = 0; index < table.length; index++){
            if (table[index] != null){
                for (int num : numbers){
                    if (table.length > index+num){
                        List<Integer> ways = new ArrayList<>(table[index]);
                        ways.add(num);
                        //check if list at index+num is null OR greater then the new ways
                        if (table[index+num] == null || table[index+num].size() > ways.size())
                            //replace old list of ways
                            table[index+num] = ways;
                    }
                }
            }
        }
        return table[target];
    }

    public static void main(String[] args) {
        int[] numbers1 = new int[]{2,3};
        int[] numbers2 = new int[]{2,4,5,3};
        int[] numbers3 = new int[]{2,4};
        int[] numbers4 = new int[]{2,5,3};
        int[] numbers5 = new int[]{7,14};
        int[] numbers6 = new int[]{2,4,5,3,15,30};
        System.out.println(bestSum(6, numbers1)); //[3,3]
        System.out.println(bestSum(7, numbers2)); //[3,4] or [2,5]
        System.out.println(bestSum(7, numbers3)); //null
        System.out.println(bestSum(8, numbers4)); //[3,5]
        System.out.println(bestSum(300, numbers5)); //null
        System.out.println(bestSum(300, numbers6)); //[30,30,30,30,30,30,30,30,30,30]
    }
}
