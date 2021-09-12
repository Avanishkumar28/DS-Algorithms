package algo.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class GridTraveler {

    //recursive
    public static long gridTraveler(int row, int col){
        if(row == 0 || col == 0)
            return 0;
        if (row ==1 && col == 1)
            return 1;
        return gridTraveler(row-1, col) + gridTraveler(row,col-1);
    }
    //Memorization
    public static long gridTravelerMemo(int row, int col){
        Map<String, Long> memo = new HashMap<>();
        return gridTMemo(row, col, memo);
    }
    private static long gridTMemo(int row, int col, Map<String, Long> memo){
        if (row == 0 || col == 0)
            return 0;
        if (row == 1 && col == 1)
            return 1;
        String key = row+"_"+col;
        String key2 = col+"_"+row;
        if(!memo.containsKey(key) || !memo.containsKey(key)){
            memo.put(key, gridTMemo(row-1, col, memo)+gridTMemo(row, col-1, memo));
        }
        return memo.get(key) != null ? memo.get(key) : memo.get(key2);
    }

    public static void main(String[] args) {
//        System.out.println(gridTraveler(1,1)); //1
//        System.out.println(gridTraveler(1,2)); //1
//        System.out.println(gridTraveler(2,3)); //3
//        System.out.println(gridTraveler(18,18)); //2333606220

        long start = System.currentTimeMillis();
        System.out.println(gridTraveler(18,18));
        long end = System.currentTimeMillis();
        System.out.println("Time Taken by Recursive: "+(end-start)+"ms");

        long startMemo = System.currentTimeMillis();
        System.out.println(gridTravelerMemo(18,18));
        long endMemo = System.currentTimeMillis();
        System.out.println("Time Taken by Memo Function: "+(endMemo-startMemo)+"ms");
    }
}
