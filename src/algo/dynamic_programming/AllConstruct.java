package algo.dynamic_programming;

import java.util.*;

public class AllConstruct {

    public static List<List<String>>  allConstruct(String target, String[] words){
        if(target.equals(""))
            return new ArrayList<>(Arrays.asList(new ArrayList<>()));

        List<List<String>>  result = new ArrayList<>();
        for (String word : words){
            if (target.indexOf(word) == 0) {
                String suffix = target.substring(word.length());

                List<List<String>> suffixWays = allConstruct(suffix, words);
                List<List<String>> targetWays = new ArrayList<>();

                for (List<String> ways : suffixWays) {
                    List<String> temp = new ArrayList<>();
                    temp.add(word);
                    temp.addAll(ways);
                    targetWays.add(temp);
                }

                for (List<String> targetWay : targetWays) {
                    result.add(targetWay);
                }
            }
        }
        return result;
    }

    /**
     * m -> target length
     * n -> words length
     * Time Complexity  => O(n^m)
     * Space Complexity => O(m)
     */
    public static List<List<String>> allConstructMemo(String target, String[] words){
        Map<String, List<List<String>>> memo = new HashMap<>();
        return allConstructMemo(target, words, memo);
    }
    private static List<List<String>> allConstructMemo(String target, String[] words, Map<String, List<List<String>>> memo){
        if (target.equals(""))
            return new ArrayList<>(Arrays.asList(new ArrayList<>()));
        if (memo.containsKey(target))
            memo.get(target);

        List<List<String>> result = new ArrayList<>();
        for (String word : words){
            if (target.indexOf(word) == 0){
                String suffix = target.substring(word.length());
                List<List<String>> suffixWays = allConstructMemo(suffix, words, memo);
                memo.put(suffix, suffixWays);

                List<List<String>> targetWays = new ArrayList<>();
                for (List<String> ways : suffixWays){
                    List<String> temp = new ArrayList<>();
                    temp.add(word);
                    temp.addAll(ways);
                    targetWays.add(temp);
                }
                for (List<String> targetWay : targetWays){
                    result.add(targetWay);
                }

            }
        }
        memo.put(target, result);
        return result;
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
        String word5 = "eeeeeeeeeeeeeeeeaaeeeeeeeeeeeeeeeef";
        String[] words5 = new String[]{"e", "ee", "eee", "eeeee", "eeeaaeee"};

        System.out.println(allConstruct(word1, words1));
        /*[
          [abc, def]
        ]*/
        System.out.println(allConstruct(word2, words2));
        /* []*/
        System.out.println(allConstruct(word3, words3));
        /*[
         [purp, le],
         [p, ur, p, le]
        ]*/

        long start = System.currentTimeMillis();
        System.out.println(allConstruct(word4, words4));
        /*[
         [enter, a, p, ot, ent, p, ot],
         [enter, a, p, ot, ent, p, o, t],
         [enter, a, p, o, t, ent, p, ot],
         [enter, a, p, o, t, ent, p, o, t]
        ]*/
        System.out.println(allConstruct(word5, words5));
        /*[]*/
        long end = System.currentTimeMillis();
        System.out.println("Time Taken by Recursive: "+(end-start)+"ms");

        long startMemo = System.currentTimeMillis();
        System.out.println(allConstructMemo(word4, words4));
        /*[
         [enter, a, p, ot, ent, p, ot],
         [enter, a, p, ot, ent, p, o, t],
         [enter, a, p, o, t, ent, p, ot],
         [enter, a, p, o, t, ent, p, o, t]
        ]*/
        System.out.println(allConstructMemo(word5, words5));
        /*[]*/
        long endMemo = System.currentTimeMillis();
        System.out.println("Time Taken by Memo Function: "+(endMemo-startMemo)+"ms");
    }
}
