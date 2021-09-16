package algo.dynamic_programming.tabulation;

public class CanConstructTab {

    /**
     * m - target.length
     * n - words.length
     * Time Complexity  => O(m*n*m)=> O(m^2 *n)
     * Space Complexity => O(m)
     **/
    public static boolean canConstructTab(String target, String[] words){
        boolean[] table = new boolean[target.length()+1];
        //base case: "" (blank string) can be construct without using any word from the words
        table[0] = true;

        for (int index = 0; index < table.length; index ++){
            if (table[index]){
                for (String word : words){
                    //if the word match starting chars of remaining target at current index of target
                    if (target.substring(index).indexOf(word) == 0) {
                        table[index + word.length()] = true;
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
        String word3 = "eeeeeeeeeeeeeeeeeeeeeeeeeeedddf";
        String[] words3 = new String[]{"d", "dd", "f", "eee", "eeeeeeee", "eeeeeeeeeeeeeeeeee"};
        String word4 = "enterapotentpot";
        String[] words4 = new String[]{"a", "p", "ent", "enter", "ot", "o", "t"};
        String word5 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";
        String[] words5 = new String[]{"e", "ee", "eee", "eeeee"};

        System.out.println(canConstructTab(word1, words1)); //true
        System.out.println(canConstructTab(word2, words2)); //false
        System.out.println(canConstructTab(word3, words3)); //true
        System.out.println(canConstructTab(word4, words4)); //true
        System.out.println(canConstructTab(word5, words5)); //false
    }
}
