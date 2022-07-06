package algo.leetcode.medium;

import java.util.*;

/**
 * Problem-286: https://leetcode.com/problems/walls-and-gates/
 * https://www.lintcode.com/problem/663/
 *
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room.
 **/

public class WallsAndGates {

    //directions for look-up:  up, down, left, right
    private static int[][] directions = {{-1, 0},{1,0},{0,-1},{0,1}};
    public static void nearestGate(int[][] rooms){
        if (rooms == null || rooms.length == 0)
            return;
        Queue<Point> queue = new LinkedList<>();
        Set<Point> visited = new HashSet<>();
        //Add all get to queue
        for (int row = 0; row < rooms.length; row++){
            for (int col = 0; col < rooms[0].length; col++){
                if (rooms[row][col] == 0){
                    queue.offer(new Point(row, col));
                    visited.add(new Point(row, col));
                }
            }
        }
        //all gates have level 0
        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++){
                Point point = queue.remove();
                int x = point.x;
                int y = point.y;
                rooms[x][y] = level;
                //look all direction
                //up
                nearestGateHelper(rooms, x-1, y, queue, visited);
                //down
                nearestGateHelper(rooms, x+1, y, queue, visited);
                //left
                nearestGateHelper(rooms, x, y-1, queue, visited);
                //right
                nearestGateHelper(rooms, x, y+1, queue, visited);

            }
            level++;
        }
    }

    private static void nearestGateHelper(int[][] rooms, int row, int col, Queue<Point> queue, Set<Point> visited) {
        if(isOutOfGrid(rooms, row, col) || visited.contains(new Point(row, col)) || rooms[row][col] == -1)
            return;
        queue.add(new Point(row, col));
        visited.add(new Point(row,col));
    }

    private static boolean isOutOfGrid(int[][] rooms, int row, int col) {
        return row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point("+ x + "," + y +")";
        }
    }

    public static void main(String[] args) {
        int[][] rooms = new int[][]{
                {2147483647,-1,0,2147483647},
                {2147483647,2147483647,2147483647,-1},
                {2147483647,-1,2147483647,-1},
                {0,-1,2147483647,2147483647}
        };
        nearestGate(rooms);

        System.out.println(Arrays.deepToString(rooms));
    }
}
