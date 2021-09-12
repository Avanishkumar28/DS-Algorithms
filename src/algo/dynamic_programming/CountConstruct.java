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
