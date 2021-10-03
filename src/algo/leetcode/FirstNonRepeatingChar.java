package algo.leetcode;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    //Using inbuilt function: indexOf(), lastIndexOf()
    public static char firstNonRepeatingChar(String s){
        if (baseCase(s))
            return '_';
        for (int index = 0; index < s.length(); index++){
            if (s.indexOf(s.charAt(index)) == s.lastIndexOf(s.charAt(index)))
                return s.charAt(index);
        }
        return '_';
    }

    //Using extra space arr[26]
    public static char firstNonRepeatingCharByArr(String s){
        if (baseCase(s))
            return '_';
        int[] arr = new int[26];
        for (char c : s.toCharArray()){
            arr[c - 'a'] += 1;
        }
        for (int index = 0; index < arr.length; index++){
            if (arr[index] == 1)
                return (char) ('a' + index);
        }
        return '_';
    }

    //Using Extra Space: LinkedHashMap
    public static char firstNonRepeatingCharByMap(String s){
        if (baseCase(s))
            return '_';
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()){
            if (map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        for (Character c : map.keySet()){
            if (map.get(c) == 1)
                return c;
        }
        return '_';
    }

    //Using two loop (two pointer)
    public static char firstNonRepeatingCharByTwoPointer(String s){
        if (baseCase(s))
            return '_';
        for (int outer = 0; outer < s.length(); outer++){
            for (int inner = 0; inner < s.length(); inner++){
                if (s.charAt(outer) == s.charAt(inner) && outer != inner)
                    break;
                if (inner == s.length()-1)
                    return s.charAt(outer);
            }
        }
        return '_';
    }

    private static boolean baseCase(String s) {
        return s == null || "".equals(s) || s.length() < 2;
    }

    public static void main(String[] args) {
        String test1S = "aabacdbaadd";
        String test2S = "aaabbcddaaddcc";
        String test3S = "";
        String test4S = "a";
        String test5S = "zaaabbcccdddrrrhhhsjjjss";

        System.out.println("******Using inbuilt function********");
        System.out.println(firstNonRepeatingChar(test1S));
        System.out.println(firstNonRepeatingChar(test2S));
        System.out.println(firstNonRepeatingChar(test3S));
        System.out.println(firstNonRepeatingChar(test4S));
        System.out.println(firstNonRepeatingChar(test5S));
        System.out.println(firstNonRepeatingChar(null));

        System.out.println("******Using Array[26] function********");
        System.out.println(firstNonRepeatingCharByArr(test1S));
        System.out.println(firstNonRepeatingCharByArr(test2S));
        System.out.println(firstNonRepeatingCharByArr(test3S));
        System.out.println(firstNonRepeatingCharByArr(test4S));
        System.out.println(firstNonRepeatingCharByArr(test5S));
        System.out.println(firstNonRepeatingCharByArr(null));

        System.out.println("******Using Map function********");
        System.out.println(firstNonRepeatingCharByMap(test1S));
        System.out.println(firstNonRepeatingCharByMap(test2S));
        System.out.println(firstNonRepeatingCharByMap(test3S));
        System.out.println(firstNonRepeatingCharByMap(test4S));
        System.out.println(firstNonRepeatingCharByMap(test5S));
        System.out.println(firstNonRepeatingCharByMap(null));

        System.out.println("******Using two pointer function********");
        System.out.println(firstNonRepeatingCharByTwoPointer(test1S));
        System.out.println(firstNonRepeatingCharByTwoPointer(test2S));
        System.out.println(firstNonRepeatingCharByTwoPointer(test3S));
        System.out.println(firstNonRepeatingCharByTwoPointer(test4S));
        System.out.println(firstNonRepeatingCharByTwoPointer(test5S));
        System.out.println(firstNonRepeatingCharByTwoPointer(null));

    }
}
