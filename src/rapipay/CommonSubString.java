package rapipay;

import java.util.Arrays;

public class CommonSubString {

    public static void main(String[] args) {
        String[] words = {"That", "Their", "Them", "They"};
        System.out.println(longestCommonSubString(words)); //Th
        String[] arr = {"mint", "mini", "mineral"};
        System.out.println(longestCommonSubString(arr)); //min
    }

    public static String longestCommonSubString(String[] words) {
        if (words == null || words.length < 1)
            return "";
        if (words.length == 1)
            return words[0];
        StringBuilder sb = new StringBuilder();
        // Sort the array
        Arrays.sort(words);
        int length = words[0].length();
        // Comapre the first and the last strings character
        // by character.
        for(int i = 0; i < length; i++){
            // If the characters match, append the character to the result.
            if(words[0].charAt(i) == words[words.length - 1].charAt(i)){
                sb.append(words[0].charAt(i));
            }
            // Else, stop the comparison.
            else{
                break;
            }
        }

        return sb.toString();
    }
}
