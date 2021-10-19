package algo.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. Find All Anagrams in a String (https://leetcode.com/problems/find-all-anagrams-in-a-string/)
 * */
public class AllAnagramsInString {

    public static List<Integer> findAnagrams(String s, String p) {
        if(s == null || p == null || p.length() > s.length())
            return new ArrayList<Integer>();;
        int[] pHash = new int[26];
        for(char c : p.toCharArray()){
            pHash[c - 'a'] += 1;
        }
        List<Integer> result = new ArrayList<>();
        for(int index = 0; index <= s.length()-p.length(); index++){
            int[] sHash = new int[26];
            int left = index;
            while(left < index+p.length()){
                sHash[s.charAt(left++) - 'a'] += 1;
            }
            if(Arrays.toString(pHash).equals(Arrays.toString(sHash)))
                result.add(index);
        }
        return result;
    }

    public static void main(String[] args) {
        String test1S = "cbaebabacd", test1P = "abc";
        System.out.println(findAnagrams(test1S, test1P)); //[0,6]
        String test2S = "abab", test2P = "ab";
        System.out.println(findAnagrams(test2S, test2P)); //[0,1,2]

    }
}
