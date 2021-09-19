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
        int maxV = 0;
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[row].length; col++){
                String key = row+"_"+col;
                //current row/col or current element is '0' just add as 0 do nothing
                if(row == 0 || col == 0 || matrix[row][col]-'0' == 0){
                    memo.put(key, matrix[row][col]-'0');
                }else { //chek up, left and diagonal(up-left) if all > 0
                    //then add diagonal+current
                    memo.put(key, (matrix[row][col]-'0')+getPrevious(row, col, memo));
                }
                maxV = Math.max(maxV, memo.get(key));
            }
        }

        return maxV*maxV;

    }

    private static int getPrevious(int row, int col, Map<String, Integer> memo){
        return Math.min(
                Math.min(memo.get((row-1)+"_"+(col-1)), memo.get((row-1)+"_"+col))
                , memo.get((row)+"_"+(col-1)));
    }

    private static int maximalSquareTabular(char[][] matrix){
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] table = new int[row+1][col+1];
        int maxV = 0;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(matrix[i-1][j-1] == '1'){
                    table[i][j] = 1 + Math.min(table[i-1][j-1], Math.min(table[i-1][j], table[i][j-1]));
                    maxV = Math.max(maxV, table[i][j]);
                }
            }
        }
        return maxV*maxV;
    }

    public static void main(String[] args) {
        char[][] test1Matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
        System.out.println(maximalSquare(test1Matrix)); //4
        System.out.println(maximalSquareTabular(test1Matrix)); //4
        System.out.println("--------------------");
        char[][] test2Matrix = new char[][]{
                {'0','1'},
                {'1','0'}
        };
        System.out.println(maximalSquare(test2Matrix)); //1
        System.out.println(maximalSquareTabular(test2Matrix)); //1
        System.out.println("--------------------");
        char[][] test3Matrix = new char[][]{ {'0'}  };
        System.out.println(maximalSquare(test3Matrix)); //0
        System.out.println(maximalSquareTabular(test3Matrix)); //0
        System.out.println("--------------------");
        char[][] test4Matrix = new char[][]{
                {'1','1','1','1','0'},
                {'1','1','1','1','0'},
                {'1','1','1','1','1'},
                {'1','1','1','1','1'},
                {'0','0','1','1','1'}
        };
        System.out.println(maximalSquare(test4Matrix)); //16
        System.out.println(maximalSquareTabular(test4Matrix)); //16
        System.out.println("--------------------");
        char[][] test5Matrix = new char[][]{
                {'1','0','1','1','0','1'},
                {'1','1','1','1','1','1'},
                {'0','1','1','0','1','1'},
                {'1','1','1','0','1','0'},
                {'0','1','1','1','1','1'},
                {'1','1','0','1','1','1'}
        };
        System.out.println(maximalSquare(test5Matrix)); //4
        System.out.println(maximalSquareTabular(test5Matrix)); //4
        System.out.println("--------------------");
    }
}
