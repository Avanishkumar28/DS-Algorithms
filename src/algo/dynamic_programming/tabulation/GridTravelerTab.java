package algo.dynamic_programming.tabulation;

public class GridTravelerTab {

    /**
     * m - number of rows in grid
     * n - number of columns in grid
     * Time Complexity  => O(m*n)
     * Space Complexity => O(m*n)
     **/
    public static long gridTraveler(int m, int n){
        long[][] table = new long[m+1][n+1];
        table[1][1] = 1;
        for (int row = 0; row <= m; row++){
            for (int col = 0; col <= n; col++){
                long current = table[row][col];
                if(col+1 <= n) table[row][col+1] += current;
                if(row+1 <= m) table[row+1][col] += current;
            }
        }

        return table[m][n];
    }

    public static void main(String[] args) {
        System.out.println(gridTraveler(1,1)); //1
        System.out.println(gridTraveler(2,3)); //3
        System.out.println(gridTraveler(3,2)); //3
        System.out.println(gridTraveler(3,3)); //6
        System.out.println(gridTraveler(18,18)); //233606220
    }
}
