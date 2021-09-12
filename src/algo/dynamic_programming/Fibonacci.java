package algo.dynamic_programming;

public class Fibonacci {

    public static long fib(int position){
        if(position <= 2)
            return 1;
        return fib(position-1)+fib(position-2);
    }
    public static long fibMemorization(int position){
        long[] memo = new long[position+1];
        return fibMemo(position, memo);
    }

    private static long fibMemo(int position, long[] memo) {
        if (position <=2 )
            return 1;
        if (memo[position] == 0)
            memo[position] = fibMemo(position-1, memo)+fibMemo(position-2, memo);
        return memo[position];
    }

    public static void main(String[] args) {
        int position = 50;
        long start = System.currentTimeMillis();
        System.out.println("Fibonacci number at "+position+"th is: "+fib(position));
        long end = System.currentTimeMillis();
        System.out.println("Time Taken: "+(end-start)+"ms");

        long startMemo = System.currentTimeMillis();
        System.out.println("Fibonacci number at "+position+"th is: "+fibMemorization(position));
        long endMemo = System.currentTimeMillis();
        System.out.println("Time Taken by Memo Function: "+(endMemo-startMemo)+"ms");

//        IntStream.rangeClosed(1,10)
//                .forEach(n -> {System.out.println("Fibonacci number at "+n+"th is: "+fib(n));});
    }
}
