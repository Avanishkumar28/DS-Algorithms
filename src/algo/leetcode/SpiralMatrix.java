package algo.leetcode;

import java.util.ArrayList;
import java.util.List;
/**

54. Spiral Matrix (https://leetcode.com/problems/spiral-matrix/)
        -- Given an m x n matrix, return all elements of the matrix in spiral order.
Example:
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [1,2,3,6,9,8,7,4,5]

        Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        Output: [1,2,3,4,8,12,11,10,9,5,6,7]
**/


public class SpiralMatrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null)
            return null;
        List<Integer> result = new ArrayList<>();

        int srow = 0, scol = 0; //start of row and col
        int lrow = matrix.length-1, lcol = matrix[0].length-1; //last of row and col

        int tracker = matrix.length*matrix[0].length;
        while(tracker > 0){
            //left ---> right
            for(int col = scol; col <= lcol; col++){
                if(tracker == 0)
                    return result;
                result.add(matrix[srow][col]);
                tracker --;
            }
            //top ---> bottom
            for(int row = srow+1; row <= lrow; row++){
                if(tracker == 0)
                    return result;
                result.add(matrix[row][lcol]);
                tracker --;
            }
            //right ---> left
            for(int col = lcol-1; col >= scol; col--){
                if(tracker == 0)
                    return result;
                result.add(matrix[lrow][col]);
                tracker --;
            }
            //bottom ---> top
            for(int row = lrow-1; row >= srow+1; row--){
                if(tracker == 0)
                    return result;
                result.add(matrix[row][scol]);
                tracker --;
            }
            //shrink the matrix boundary
            scol++; srow++; lcol--; lrow--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] test1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(test1)); //[1,2,3,6,9,8,7,4,5]

        int[][] test2 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(test2)); //[1,2,3,4,8,12,11,10,9,5,6,7]
    }
}
