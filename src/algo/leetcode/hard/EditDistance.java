package algo.leetcode.hard;


/**
 * 72. Edit Distance (https://leetcode.com/problems/edit-distance/)
 * */
public class EditDistance {

    public static int minDistance(String word1, String word2) {
        if(word1 == null || word2 == null)
            return 0;
        if(word1.length() == 0 || word2.length() == 0)
            return Math.max(word1.length(), word2.length());

        int[][] dp = new int[word2.length()+1][word1.length()+1];
        for(int word2Index = 0; word2Index < dp.length; word2Index++){
            for(int word1Index = 0; word1Index < dp[0].length; word1Index++){
                //base case 1: if word1 is ""
                if(word1Index == 0)
                    dp[word2Index][word1Index] = word2Index;
                    //base case 2: if word2 is ""
                else if(word2Index == 0)
                    dp[word2Index][word1Index] = word1Index;
                    //if last char match in both word
                else if(word1.charAt(word1Index-1) == word2.charAt(word2Index-1))
                    dp[word2Index][word1Index] = dp[word2Index-1][word1Index-1];
                else //if char doesn't match
                    dp[word2Index][word1Index] = 1 +
                            Math.min(dp[word2Index][word1Index-1], //insert
                                    Math.min(dp[word2Index-1][word1Index], //delete
                                            dp[word2Index-1][word1Index-1]) //replace
                            );
            }
        }
        return dp[word2.length()][word1.length()];
    }

    public static void main(String[] args) {
        String test1Word1 = "sunday";
        String test1Word2 = "saturday";
        System.out.println(minDistance(test1Word1, test1Word2)); //3
        String test2Word1 = "intention";
        String test2Word2 = "execution";
        System.out.println(minDistance(test2Word1, test2Word2)); //5
    }
}
