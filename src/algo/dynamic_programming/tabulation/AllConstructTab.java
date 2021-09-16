package algo.dynamic_programming.tabulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllConstructTab {

    /**
     * m - target.length
     * n - words.length
     * Time Complexity  => ~O(n^m)
     * Space Complexity => ~O(n^m)
     **/
    public static List<List<String>> allConstructTab(String target, String[] words){
        List<List<String>>[] table = new List[target.length() + 1];
        table[0] = new ArrayList<>(Arrays.asList(new ArrayList<>()));

        for (int index = 0; index < table.length; index++){
            if (table[index] != null){
                for (String word : words){
                    if (target.substring(index).indexOf(word) == 0){
                        List<List<String>> waysWithWord = new ArrayList<>();
                        for (List<String> subArray : table[index]){
                            List<String> subArrayTemp = new ArrayList<>(subArray);
                            subArrayTemp.add(word);
                            waysWithWord.add(subArrayTemp);
                        }

                        //get old list at table[index + word.length()] and updated with new ways
                        if (table[index + word.length()] != null){
                            List<List<String>> oldWays = table[index + word.length()];
                            waysWithWord.addAll(oldWays);
                        }
                        table[index + word.length()] = waysWithWord;
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
        String[] words5 = new String[]{"ad", "brf", "eee", "eeeee"};

        System.out.println(allConstructTab(word1, words1));
        /*[
          [abc, def]
        ]*/
        System.out.println(allConstructTab(word2, words2)); //null
        System.out.println(allConstructTab(word3, words3));
        /*[
         [purp, le],
         [p, ur, p, le]
        ]*/
        System.out.println(allConstructTab(word4, words4));
        /*[
         [enter, a, p, ot, ent, p, ot],
         [enter, a, p, ot, ent, p, o, t],
         [enter, a, p, o, t, ent, p, ot],
         [enter, a, p, o, t, ent, p, o, t]
        ]*/
        System.out.println(allConstructTab(word5, words5)); //null
    }
}
