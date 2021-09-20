package algo.leetcode.hard;

/**
 * 115. Distinct Subsequences
 *
 * Given two strings s and t, return the number of distinct subsequences of s which equals t.
 * A string's subsequence is a new string formed from the original string
 * by deleting some (can be none) of the characters without disturbing
 * the remaining characters' relative positions.
 * (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * It is guaranteed the answer fits on a 32-bit signed integer.
 *
 * Example 1:
 *
 * Input: s = "rabbbit", t = "rabbit"
 * Output: 3
 * Explanation:
 * There are 3 ways you can generate "rabbit" from S.
 * */
public class DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        if(s == null || s.length() < t.length())
            return 0;

        int n = s.length();
        int m = t.length();
        int[][] dp = new int[m+1][n+1];

        //fill dp for t-->""
        for(int col = 0; col<n; col++){
            dp[0][col] = 1;
        }

        for(int row = 1; row <= m; row++){
            for(int col = 1; col <= n; col++){
                //System.out.println("current Row: "+row +" Col: "+col);
                if(t.charAt(row-1) == s.charAt(col-1)){
                    dp[row][col] = dp[row][col-1] + dp[row-1][col-1];
                }else{
                    dp[row][col] = dp[row][col-1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String test1String = "cbabacbacab";
        String test1Target = "abb";
        System.out.println(numDistinct(test1String, test1Target));// 4

    }
}
