package algo.leetcode.medium;

import java.util.Arrays;

/**
 * 567. Permutation in String (https://leetcode.com/problems/permutation-in-string/)
 * */
public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() > s2.length())
            return false;
        int[] s1Hash = new int[26];
        for(char c : s1.toCharArray()){
            s1Hash[c - 'a'] += 1;
        }

        int[] s2Hash = new int[26];
        int window = s1.length();
        for(int index = window-1; index < s2.length(); index++){
            int right = index;
            int tmpWindow = window;

            while(tmpWindow-- > 0){
                s2Hash[s2.charAt(right--) - 'a'] += 1;
            }
            if(Arrays.toString(s1Hash).equals(Arrays.toString(s2Hash)))
                return true;
            else{ // optional: if not want to use new array for s2
                tmpWindow = window;
                right = index;
                while(tmpWindow-- > 0){
                    s2Hash[s2.charAt(right--) - 'a'] -= 1;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1,s2)); //true
        String test1S1 = "ab", test1S2 = "eidboaoo";
        System.out.println(checkInclusion(test1S1, test1S2)); //false
    }
}
