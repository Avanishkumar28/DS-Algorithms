# Data Structures and algorithms in Java

---

## An Intro to Dynamic Programming

### Memoization Recipe

- **Make it work.**
  - visualize the problem
  - implement the tree using recursion
  - test it
- **Make it efficient.**
  - add a mem object
  - add a base case to return memo values
  - store return values into the memo

---

### Fibonacci Problem

```java
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
```

---

### GridTraveler Problem

```java
package algo.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    //recursive
    public static long gridTraveler(int row, int col){
        if(row == 0 || col == 0)
            return 0;
        if (row ==1 && col == 1)
            return 1;
        return gridTraveler(row-1, col) + gridTraveler(row,col-1);
    }
    //Memorization
    public static long gridTravelerMemo(int row, int col){
        Map<String, Long> memo = new HashMap<>();
        return gridTMemo(row, col, memo);
    }
    private static long gridTMemo(int row, int col, Map<String, Long> memo){
        if (row == 0 || col == 0)
            return 0;
        if (row == 1 && col == 1)
            return 1;
        String key = row+"_"+col;
        String key2 = col+"_"+row;
        if(!memo.containsKey(key) || !memo.containsKey(key)){
            memo.put(key, gridTMemo(row-1, col, memo)+gridTMemo(row, col-1, memo));
        }
        return memo.get(key) != null ? memo.get(key) : memo.get(key2);
    }

    public static void main(String[] args) {
//        System.out.println(gridTraveler(1,1)); //1
//        System.out.println(gridTraveler(1,2)); //1
//        System.out.println(gridTraveler(2,3)); //3
//        System.out.println(gridTraveler(18,18)); //2333606220

        long start = System.currentTimeMillis();
        System.out.println(gridTraveler(18,18));
        long end = System.currentTimeMillis();
        System.out.println("Time Taken by Recursive: "+(end-start)+"ms");

        long startMemo = System.currentTimeMillis();
        System.out.println(gridTravelerMemo(18,18));
        long endMemo = System.currentTimeMillis();
        System.out.println("Time Taken by Memo Function: "+(endMemo-startMemo)+"ms");
    }
}
```

---

### canSum

- Write a function `canSum(targetSum, numbers)` that takes in a `targetSum` and an array of numbers as arguments.
- The function should return a boolean indicating whether or not it is possible to generate the `targetSum` using numbers from the array.
- You may use an element of the array as many times as needed.
- You may assume that all input numbers are non-negative.


```java
package algo.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static boolean canSum(int target, int[] numbers){
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        for (int num : numbers){
            int remainder = target - num;
            if(canSum(remainder, numbers))
                return true;
        }
        return false;
    }

    public static boolean canSumMemo(int target, int[] numbers){
        Map<Integer, Boolean> memo = new HashMap<>();
        return canSMemo(target, numbers, memo);
    }
    private static boolean canSMemo(int target, int[] numbers, Map<Integer, Boolean> memo){
        if (target == 0)
            return true;
        if (target < 0)
            return false;
        if(memo.containsKey(target))
            return memo.get(target);
        for (int num : numbers){
            int remainder = target - num;
            if(canSMemo(remainder, numbers, memo)){
                memo.put(remainder, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        int[] numbers1 = new int[]{2,3,5};
        int[] numbers2 = new int[]{7,14};
        int[] numbers3 = new int[]{2,4};
        System.out.println(canSum(8, numbers1)); //true
        System.out.println(canSum(8, numbers3)); //true
        System.out.println(canSum(7, numbers3)); //false
        System.out.println(canSum(7, numbers2)); //true
        System.out.println(canSum(300, numbers2)); //false
        System.out.println(canSumMemo(300, numbers2)); //false

    }
}
```

---

### howSum

- Write a function `howSum(targetSum, numbers)` that takes in a targetSum and an array of numbers as arguments.
- The function should return an array containing any combination of elements that add up to exactly that `targetSum`. If there is no combination that adds up to the `targetSum`, then return null.
- If there are multiple combinations possible, you may return any single one.


```java
package algo.dynamic_programming;

import java.util.*;

public class HowSum {

    public static List<Integer> howSumRecursive(int target, int[] numbers){
        if(target == 0)
            return new ArrayList<Integer>();
        if (target < 0)
            return null;
        for (int num : numbers){
            int remainder = target - num;
            List<Integer> remainderResult = howSumRecursive(remainder, numbers);
            if (remainderResult != null){
                remainderResult.add(num);
                return remainderResult;
            }
        }
        return null;
    }

    public static List<Integer> howSumMemo(int target, int[] numbers){
        Map<Integer, List<Integer>> memo = new HashMap<>();
        return howSMemo(target, numbers, memo);
    }
    private static List<Integer> howSMemo(int target, int[] numbers, Map<Integer, List<Integer>> memo){
        if (target == 0)
            return new ArrayList<>();
        if (target < 0)
            return null;
        if (memo.containsKey(target))
            return memo.get(target);

        for (int num : numbers){
            int remainder = target - num;
            List<Integer> remainderResult = howSMemo(remainder, numbers, memo);
            if (remainderResult != null){
                remainderResult.add(num);
                memo.put(remainder, remainderResult);
                return remainderResult;
            }
        }
        memo.put(target, null);
        return null;
    }


    public static void main(String[] args) {
        int[] numbers1 = new int[]{2,3,5};
        int[] numbers2 = new int[]{7,4,3};
        int[] numbers3 = new int[]{2,4};
        System.out.println(howSumRecursive(7, numbers1)); //[2,2,3] or [2,5]
        System.out.println(howSumRecursive(7, numbers3)); //null
        System.out.println(howSumRecursive(311, numbers2));
        System.out.println(howSumRecursive(87, numbers3)); //null
        System.out.println(howSumRecursive(0, numbers3)); //[]

        System.out.println(howSumMemo(147, numbers3));// null
    }
}
```

---

### bestSum

- Write a function `bestSum(targetSum, numbers)` that takes in a `targetSum` and an array of numbers as arguments.
- The function should return an array containing the `shortest` combination of numbers that add up to exactly the `targetSum`.
- If there is a tie for the shortest combination, you may return any one of the shortest.

```java
package algo.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestSum {

    //m -> target sum
    //n -> numbers.length
    //time -> O(n^m * m)
    //Space -> O(m^2)
    public static List<Integer> bestSumRecursive(int target, int[] numbers){
        if (target == 0)
            return new ArrayList<>();
        if (target < 0)
            return null;

        List<Integer> bestResult = null;
        for (int num : numbers){
            int remainder = target - num;
            List<Integer> remainderResult = bestSumRecursive(remainder, numbers);
            if (remainderResult != null){
                List<Integer> resultSum = new ArrayList<>();
                resultSum.add(num);
                resultSum.addAll(remainderResult);
                if (bestResult == null || bestResult.size() > resultSum.size()){
                    bestResult = resultSum;
                }
            }

        }
        return bestResult;
    }

    //m -> target sum
    //n -> numbers.length
    //time -> O(m * n * m) => O(m^2 * n)
    //Space -> O(m^2)
    public static List<Integer> bestSumMemo(int target, int[] numbers){
        Map<Integer, List<Integer>> memo = new HashMap<>();
        return bestSumMemo(target, numbers, memo);
    }
    private static List<Integer> bestSumMemo(int target, int[] numbers, Map<Integer, List<Integer>> memo){
        if (target == 0)
            return new ArrayList<>();
        if (target < 0)
            return null;
        if (memo.containsKey(target))
            return memo.get(target);

        List<Integer> bestResult = null;
        for (int num : numbers){
            int remainder = target - num;
            List<Integer> remainderResult = bestSumMemo(remainder, numbers, memo);
            if (remainderResult != null){
                List<Integer> resultSum = new ArrayList<>();
                resultSum.add(num);
                resultSum.addAll(remainderResult);
                if (bestResult == null || bestResult.size() > resultSum.size()){
                    bestResult = resultSum;
                }
            }
        }
        memo.put(target, bestResult);
        return bestResult;
    }

    public static void main(String[] args) {
        int[] numbers1 = new int[]{2,3,5};
        int[] numbers2 = new int[]{4,3,5,7};
        int[] numbers3 = new int[]{4,5,7,15,20,25};

        System.out.println(bestSumRecursive(7, numbers1)); //[2,5]
        System.out.println(bestSumRecursive(7, numbers2)); //[7]
        System.out.println(bestSumRecursive(15, numbers2)); //[4,4,7]

        long start = System.currentTimeMillis();
        System.out.println(bestSumRecursive(100, numbers3)); //[25,25,25,25]
        long end = System.currentTimeMillis();
        System.out.println("Time Taken by Recursive: "+(end-start)+"ms");

        long startMemo = System.currentTimeMillis();
        System.out.println(bestSumMemo(100, numbers3)); //[25,25,25,25]
        long endMemo = System.currentTimeMillis();
        System.out.println("Time Taken by Memo Function: "+(endMemo-startMemo)+"ms");
    }
}
```

---

### In a nutshell

- `canSum -> Decision Problem`
  "Can you do it? yes/no"
- `howSum -> Combinatoric Problem`
  "How will you do it?"
- `bestSum -> Optimization Problem`
  "What is the 'best' way to do it?"

---

### canConstruct

- Write a function `canConstruct(target, wordBank)` that accepts a target string and an array of strings.
- The function should return a boolean indicating whether or not the `target` can be constructed by concatenating elements of the `wordBank` array.
- You may reuse elements of `wordBank` as many times as needed.

```java
package algo.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    //m -> target length
    //n -> words length
    //Time Complexity  => O(n^m * m)
    //Space Complexity => O(m^2)
    public static boolean canConstruct(String target, String[] words){
        if (target.equals(""))
            return true;

        for (String word : words){
            if (target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                if(canConstruct(suffix, words))
                    return true;
            }
        }
        return false;
    }

    //m -> target length
    //n -> words length
    //Time Complexity  => O(n * m^2)
    //Space Complexity => O(m^2)
    public static boolean canConstructMemo(String target, String[] words){
        Map<String, Boolean> memo = new HashMap<>();
        return canConstructMemo(target, words, memo);
    }
    private static boolean canConstructMemo(String target, String[] words, Map<String, Boolean> memo){
        if (target.equals(""))
            return true;
        if (memo.containsKey(target))
            return memo.get(target);

        for (String word : words){
            if (target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                if(canConstructMemo(suffix, words, memo)){
                    memo.put(suffix, true);
                    return true;
                }
            }
        }
        memo.put(target, false);
        return false;
    }

    public static void main(String[] args) {
        String word1 = "abcdef";
        String[] words1 = new String[]{"ab", "abc", "cd", "def", "abcd"};
        String word2 = "skateboard";
        String[] words2 = new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"};
        String word3 = "eeeeeeeeeeeeeeeeeeeeeeeeeeedddf";
        String[] words3 = new String[]{"d", "dd", "f", "eee", "eeeeeeee", "eeeeeeeeeeeeeeeeee"};
        String word4 = "enterapotentpot";
        String[] words4 = new String[]{"a", "p", "ent", "enter", "ot", "o", "t"};
        String word5 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        String[] words5 = new String[]{"e", "ee", "eee", "eeeee"};

        System.out.println(canConstruct(word1, words1)); //true
        System.out.println(canConstruct(word2, words2)); //false
        System.out.println(canConstruct(word3, words3)); //true
        System.out.println(canConstruct(word4, words4)); //true

        long start = System.currentTimeMillis();
        System.out.println(canConstruct(word5, words5)); //false
        long end = System.currentTimeMillis();
        System.out.println("Time Taken by Recursive: "+(end-start)+"ms");

        long startMemo = System.currentTimeMillis();
        System.out.println(canConstructMemo(word4, words4)); //true
        System.out.println(canConstructMemo(word5, words5)); //false
        long endMemo = System.currentTimeMillis();
        System.out.println("Time Taken by Memo Function: "+(endMemo-startMemo)+"ms");
    }
}
```

---

### countConstruct

- Write a function `countConstruct(target, wordBank)` that accepts a target string and an array of strings.
- The function should return the number of ways that the `target` can be constructed by concatenating elements of the `wordBank` array.
- You may reuse elements of `wordBank` as many times as needed.


canCount Tree

```java
package algo.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {

    //m -> target length
    //n -> words length
    //Time Complexity  => O(n^m * m)
    //Space Complexity => O(m^2)
    public static int countConstruct(String target, String[] words){
        if(target.equals(""))
            return 1;

        int count = 0;
        for (String word : words){
            if (target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                int numWaysForRest = countConstruct(suffix, words);
                count += numWaysForRest;
            }
        }
        return count;
    }

    //m -> target length
    //n -> words length
    //Time Complexity  => O(n * m^2)
    //Space Complexity => O(m^2)
    public static int countConstructMemo(String target, String[] words){
        Map<String, Integer> memo = new HashMap<>();
        return countConstructMemo(target, words, memo);
    }
    private static int countConstructMemo(String target, String[] words, Map<String, Integer> memo){
        if (target.equals(""))
            return 1;
        if (memo.containsKey(target))
            return memo.get(target);

        int count = 0;
        for (String word : words){
            if (target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                int numWaysForRest = countConstructMemo(suffix, words, memo);
                memo.put(suffix, numWaysForRest);
                count += numWaysForRest;
            }
        }
        memo.put(target, count);
        return count;
    }

    public static void main(String[] args) {
        String word1 = "abcdef";
        String[] words1 = new String[]{"ab", "abc", "cd", "def", "abcd"};
        String word2 = "skateboard";
        String[] words2 = new String[]{"bo", "rd", "ate", "t", "ska", "sk", "boar"};
        String word3 = "purple";
        String[] words3 = new String[]{"purp", "p", "ur", "le", "purpl"};
        String word4 = "enterapotentpot";
        String[] words4 = new String[]{"a", "p", "ent", "enter", "ot", "o", "t"};
        String word5 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        String[] words5 = new String[]{"e", "ee", "eee", "eeeee"};

        System.out.println(countConstruct(word1, words1)); //1
        System.out.println(countConstruct(word2, words2)); //0
        System.out.println(countConstruct(word3, words3)); //2
        System.out.println(countConstruct(word4, words4)); //4

        long start = System.currentTimeMillis();
        System.out.println(countConstruct(word5, words5)); //0
        long end = System.currentTimeMillis();
        System.out.println("Time Taken by Recursive: "+(end-start)+"ms");

        long startMemo = System.currentTimeMillis();
        System.out.println(countConstructMemo(word4, words4)); //4
        System.out.println(countConstructMemo(word5, words5)); //0
        long endMemo = System.currentTimeMillis();
        System.out.println("Time Taken by Memo Function: "+(endMemo-startMemo)+"ms");
    }
}
```

time-space complexity

---

### allConstruct

- Write a function `allConstruct(target, wordBank)` that accepts a target string and an array of strings.
- The function should return a 2D array containing all of the ways that the `target` can be constructed by concatenating elements of the `wordBank` array. Each element of the 2D array should represent one combination that constructs the `target`.

allConstruct Tree


time-space complexity

---

### fibTab


---

### gridTravelerTab


---

### Tabulation Recipe

- visualize the problem as a table
- size the table based on the inputs
- initialize the table with default values
- seed the trivial answer into the table
- iterate through the table
- fill further positions based on the current position

---

### canSumTab


---

### howSumTab


---

### bestSumTab

---

### canConstructTab

---

### countConstructTab


---

### allConstructTab

---

### Dynamic Programming

- notice any overlapping subproblems
- decide what is the trivially smallest input
- think recursively to use Memoization
- think iteratively to use Tabulation
- draw a strategy first!!!

---