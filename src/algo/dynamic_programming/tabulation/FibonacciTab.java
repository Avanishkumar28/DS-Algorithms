package algo.dynamic_programming.tabulation;

public class FibonacciTab {

    public static long fibTab(int n){
        long[] table = new long[n+1];
        table[0] = 0;
        table[1] = 1;
        for (int index = 2; index <= n; index++)
            table[index] = table[index - 1] + table[index - 2];

        return table[n];
    }

    public static void main(String[] args) {
        System.out.println(fibTab(6)); //8
        System.out.println(fibTab(7)); //13
        System.out.println(fibTab(8)); //21
        System.out.println(fibTab(50)); //12586269025
    }
}
