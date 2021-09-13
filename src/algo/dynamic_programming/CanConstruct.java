package algo.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {

    /**
     * m -> target length
     * n -> words length
     * Time Complexity  => O(n^m * m)
     * Space Complexity => O(m^2)
     **/
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

    /**
     * m -> target length
     * n -> words length
     * Time Complexity  => O(n * m^2)
     * Space Complexity => O(m^2)
     **/
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
