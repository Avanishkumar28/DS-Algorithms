package algo.dynamic_programming.tabulation;

public class CountConstructTab {

    /**
     * m - target.length
     * n - words.length
     * Time Complexity  => O(m*n*m)=> O(m^2 *n)
     * Space Complexity => O(m)
     **/
    public static int countConstruct(String target, String[] words){
        int[] table = new int[target.length()+1];
        table[0] = 1;

        for (int index = 0; index < table.length; index++){
            if (table[index] != 0){
                for (String word : words){
                    if (target.substring(index).indexOf(word) == 0){
                        table[index + word.length()] += table[index];
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

        System.out.println(countConstruct(word1, words1)); //1
        System.out.println(countConstruct(word2, words2)); //0
        System.out.println(countConstruct(word3, words3)); //2
        System.out.println(countConstruct(word4, words4)); //4
        System.out.println(countConstruct(word5, words5)); //0
    }
}
