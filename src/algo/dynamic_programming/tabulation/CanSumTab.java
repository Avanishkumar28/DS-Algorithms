package algo.dynamic_programming.tabulation;

public class CanSumTab {

    /**
     * m - target sum
     * n - numbers.length
     * Time Complexity  => O(m*n)
     * Space Complexity => O(m)
     **/
    public static boolean canSum(int target, int[] numbers){
        boolean[] table = new boolean[target+1];
        //base case 0 can be created without using any number from the numbers
        table[0] = true;

        for (int index = 0; index <= target; index++){
            if (table[index]){
                for (int num : numbers){
                    if ((index + num) <= target)
                        table[(index + num)] = table[index];
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
        System.out.println(canSum(7, numbers1)); //true
        System.out.println(canSum(7, numbers2)); //true
        System.out.println(canSum(7, numbers3)); //false
        System.out.println(canSum(8, numbers4)); //true
        System.out.println(canSum(300, numbers5)); //false
    }
}
