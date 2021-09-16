package algo.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.List;

public class HowConstructTab {

    /**
     * m - target.length
     * n - words.length
     * Time Complexity  => O(m^2 * n)
     * Space Complexity => O(m)
     **/
    public static List<String> howConstructTab(String target, String[] words){
        List<String>[] table = new List[target.length()+1];
        table[0] = new ArrayList<>();

        for (int index = 0; index < table.length; index++){
            if (table[index] != null){
                for (String word : words){
                    if (target.substring(index).indexOf(word) == 0){
                        List<String> oldWays = table[index];
                        List<String> ways = new ArrayList<>(oldWays);
                        ways.add(word);
                        table[index+word.length()] = ways;
                    }
                }
            }
        }
        return table[target.length()];
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

        System.out.println(howConstructTab(word1, words1));
        /*[
          [abc, def]
        ]*/
        System.out.println(howConstructTab(word2, words2)); //null
        System.out.println(howConstructTab(word3, words3));
        /*[
         [purp, le]
         OR
         [p, ur, p, le]
        ]*/
        System.out.println(howConstructTab(word4, words4));
        /*[
         [enter, a, p, ot, ent, p, ot]
         OR
         [enter, a, p, ot, ent, p, o, t]
         OR
         [enter, a, p, o, t, ent, p, ot]
         OR
         [enter, a, p, o, t, ent, p, o, t]
        ]*/
        System.out.println(howConstructTab(word5, words5)); //null
    }
}
