package algo.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
221. Maximal Square
        Given an m x n binary matrix filled with 0's and 1's,
        find the largest square containing only 1's and return its area.
Example:
        Input:
        matrix = [
            ["1","0","1","0","0"],
            ["1","0","1","1","1"],
            ["1","1","1","1","1"],
            ["1","0","0","1","0"]
        ]
        Output: 4

Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 300
        matrix[i][j] is '0' or '1'
**/


public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        if(matrix == null)
            return 0;
        Map<String, Integer> memo = new HashMap<>();
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                String key = row+"_"+col;
                if(row == 0 || col == 0){
                    memo.put(key, matrix[row][col]-'0');
                    continue;
                }else { //chek up, left and diagonal(up-left) if all > 0
                    //then add diagonal+current
                    memo.put(key, (matrix[row][col]-'0')+getPrevious(row, col, memo));

                }


            }
        }
        int maxV = 0;
        for(String key : memo.keySet()){
            if(memo.get(key) > maxV)
                maxV = memo.get(key);
        }

        return maxV*maxV;

    }

    private static int getPrevious(int row, int col, Map<String, Integer> memo){
        return Math.min(
                Math.min(memo.get((row-1)+"_"+(col-1)), memo.get((row-1)+"_"+col))
                , memo.get((row)+"_"+(col-1)));
    }

    public static void main(String[] args) {
        char[][] test1Matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
        System.out.println(maximalSquare(test1Matrix)); //4
        char[][] test2Matrix = new char[][]{
                {'0','1'},
                {'1','0'}
        };
        System.out.println(maximalSquare(test2Matrix)); //1
        char[][] test3Matrix = new char[][]{ {'0'}  };
        System.out.println(maximalSquare(test3Matrix)); //0
        char[][] test4Matrix = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'0','0','1','1','1'}
        };
        System.out.println(maximalSquare(test4Matrix)); //16
    }
}
