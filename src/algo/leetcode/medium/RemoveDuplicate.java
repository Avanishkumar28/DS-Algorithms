package algo.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicate {

    public static String removeDuplicateLetters(String s) {
        if(s == null || s.length() < 2)
            return s;
        int[] cache = new int[26];
        for(char c : s.toCharArray()){
            cache[c - 'a'] += 1;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] isVisited = new boolean[26];

        for(int index = 0; index<s.length(); index++){
            char c = s.charAt(index);
            if(isVisited[c - 'a']) continue;

            while(!stack.isEmpty() && stack.peek() > c && cache[stack.peek() - 'a'] > 1){
                cache[stack.peek() - 'a'] -= 1;
                isVisited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            isVisited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        String test1 = "bcabc";
        //System.out.println(removeDuplicateLetters(test1)); //abc
        String test2 = "cbacdcbc";
        //System.out.println(removeDuplicateLetters(test2)); //acdb
        String test3 = "bbcaac";
        System.out.println(removeDuplicateLetters(test3)); //bac
    }
}
