package ola;

import java.util.Arrays;

/**
 * 1) Given a word and an array of strings arr, find if the word can be broken into a sequence of one or more words from the given array.
        Return true if it can be broken, else false.
        Same word in the dictionary may be reused multiple times in the segmentation.

        eg :  word = "olacabs", arr = ["ola","cabs"]
        return true
        word = "olacabsandolafoods", arr = ["ola","cabs","uber", "ads"]
        return false
        word - "olacabsola", arr = ["olacabs", "cabsola"]
        return false
        word - "olacabandfoods", arr = ["ola", "olacab", "andfoods"]
        return true;

 **/


public class WordBreak {

    public static boolean wordBreak(String word, String[] arr){
        boolean[] dp = new boolean[word.length()+1];
        dp[dp.length-1] = true;
        int endAt = dp.length-1;
        for(int index = word.length()-1; index >= 0; index--){
            String subWord = word.substring(index, endAt);
            for (String dWord : arr){
                if (dWord.equals(subWord) && dp[endAt]){
                    dp[index] = true;
                    endAt = index;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
        String test1Word = "olacabandfoods";
        String[] test1Arr = {"ola", "olacab", "andfoods"};
        System.out.println(wordBreak(test1Word, test1Arr)); //true

        String test2Word = "olacabs";
        String[] test2Arr = {"ola","cabs", "uber"};
        System.out.println(wordBreak(test2Word, test2Arr)); //true

        String test3Word = "olacabsandolafoods";
        String[] test3Arr = {"ola","cabs","uber", "ads"};
        System.out.println(wordBreak(test3Word, test3Arr)); //false
    }

}
