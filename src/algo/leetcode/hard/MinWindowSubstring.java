package algo.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {

    public static String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        int minLength = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        int right = 0;
        int left = 0;
        int targetCount = t.length();
        Map<Character, Integer> targetMap = new HashMap<>();
        for(char c : t.toCharArray()){
            if(targetMap.containsKey(c))
                targetMap.put(c, targetMap.get(c)+1);
            else
                targetMap.put(c, 1);
        }
        Map<Character, Integer> currentMap = new HashMap<>();
        int matchCount = 0;
        while(left < s.length()){
            char c = s.charAt(left);
            if(targetMap.containsKey(c)){
                matchCount++;
                if(currentMap.containsKey(c))
                    currentMap.put(c, currentMap.get(c)+1);
                else
                    currentMap.put(c, 1);

                while(matchCount > targetCount){
                    char rightC = s.charAt(right);
                    if(currentMap.containsKey(rightC)){
                        currentMap.put(rightC, currentMap.get(rightC)-1);
                        matchCount--;
                    }
                    right++;
                }

                System.out.println(currentMap +"  -- "+targetMap);
                if(currentMap.equals(targetMap)){
                    System.out.println("equal...."+ minLength +" < "+ left+ " : " +right);
                    if(minLength < left-right+1){
                        start = right;
                        end = left;
                        minLength = end-start+1;
                    }
                }

            }
            left++;

        }
        if(start >= 0 && end >= 0)
            return s.substring(start, end+1);
        else
            return "";
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t)); //BANC

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        map1.put('A', 1);
        map1.put('B', 2);
        map1.put('C', 3);
        map1.put('D', 4);

        map2.put('A', 1);
        map2.put('B', 2);
        map2.put('C', 3);
        map2.put('D', 4);
        //System.out.println(map1 +"  --  "+map2);
        //System.out.println(map1.equals(map2));
    }
}
