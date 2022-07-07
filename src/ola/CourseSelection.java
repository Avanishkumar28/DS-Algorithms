package ola;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule/
        207. Course Schedule
 **/

/**
 * There are a total n number of courses you have to take from  0 to n - 1.
 * Given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
 * you must take course bi first if you want to take course ai.
        Return true if you can finish all courses. Otherwise, return false.

        For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

        I/P : [[1,0],[2,1],[3,2],[4,3],[0,4]]
        returns false

        I/P : [[1,0], [0,1]]
        return false

        I/P: [[1,0],[2,1],[2,0],[3,0]]
        return true
 **/

public class CourseSelection {

    public static boolean isPossibleToCompleteCourse(int n, int[][] courses){
        if (courses == null || n == 0)
            return false;
        if (courses.length == 1)
            return true;
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int[] course : courses){
            List<Integer> requiredCourses;
            if (courseMap.containsKey(course[0])){
                requiredCourses = courseMap.get(course[0]);
            }else {
                requiredCourses = new ArrayList<>();
            }
            requiredCourses.add(course[1]);
            courseMap.put(course[0],requiredCourses);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> seen = new HashSet<>();
        for (Integer key : courseMap.keySet()){
            if(seen.contains(key))
                continue;
            if (containsCycle(key, courseMap, visited, seen))
                return false;
            seen.add(key);
        }
        return true;
    }

    private static boolean containsCycle(Integer key, Map<Integer, List<Integer>> courseMap, Set<Integer> visited, Set<Integer> seen){
        if (visited.contains(key))
            return true;
        if(seen.contains(key))
            return false;
        visited.add(key);
        List<Integer> preRequisite = courseMap.get(key);
        for (Integer courseId : preRequisite){
            if (courseMap.containsKey(courseId) && containsCycle(courseId, courseMap, visited, seen))
                return true;
        }
        //don't find cycle for this key so remove it from visited
        visited.remove(key);
        seen.add(key);
        return false;
    }

    public static void main(String[] args) {
        int[][] test1Courses = {{1,0},{2,1},{3,2},{4,3},{0,4}};
        System.out.println(isPossibleToCompleteCourse(5, test1Courses));//false
        int[][] test2Courses = {{1,0},{0,1}};
        System.out.println(isPossibleToCompleteCourse(2, test2Courses));//false
        int[][] test3Courses = {{1,0},{2,1},{2,0},{3,0},{2,3}};
        System.out.println(isPossibleToCompleteCourse(4, test3Courses));//true
        int[][] test4Courses = {{0,1},{1,2},{3,1},{3,0},{3,2}};
        System.out.println(isPossibleToCompleteCourse(4, test4Courses));//true
        int[][] test5Courses = {{1,4},{2,4},{3,1},{3,2}};
        System.out.println(isPossibleToCompleteCourse(5, test5Courses));//true
        int[][] test6Courses = {{1,0},{2,0},{2,1},{3,1},{3,2},{4,2},{4,3},
                {5,3},{5,4},{6,4},{6,5},{7,5},{7,6},{8,6},{8,7},{9,7},
                {9,8},{10,8},{10,9},{11,9},{11,10},{12,10},{12,11},{13,11},
                {13,12},{14,12},{14,13},{15,13},{15,14},{16,14},{16,15},
                {17,15},{17,16},{18,16},{18,17},{19,17},{19,18},{20,18},
                {20,19},{21,19},{21,20},{22,20},{22,21},{23,21},{23,22},
                {24,22},{24,23},{25,23},{25,24},{26,24},{26,25},{27,25},
                {27,26},{28,26},{28,27},{29,27},{29,28},{30,28},{30,29},
                {31,29},{31,30},{32,30},{32,31},{33,31},{33,32},{34,32},
                {34,33},{35,33},{35,34},{36,34},{36,35},{37,35},{37,36},
                {38,36},{38,37},{39,37},{39,38},{40,38},{40,39},{41,39},
                {41,40},{42,40},{42,41},{43,41},{43,42},{44,42},{44,43},
                {45,43},{45,44},{46,44},{46,45},{47,45},{47,46},{48,46},
                {48,47},{49,47},{49,48},{50,48},{50,49},{51,49},{51,50},
                {52,50},{52,51},{53,51},{53,52},{54,52},{54,53},{55,53},
                {55,54},{56,54},{56,55},{57,55},{57,56},{58,56},{58,57},
                {59,57},{59,58},{60,58},{60,59},{61,59},{61,60},{62,60},
                {62,61},{63,61},{63,62},{64,62},{64,63},{65,63},{65,64},
                {66,64},{66,65},{67,65},{67,66},{68,66},{68,67},{69,67},
                {69,68},{70,68},{70,69},{71,69},{71,70},{72,70},{72,71},
                {73,71},{73,72},{74,72},{74,73},{75,73},{75,74},{76,74},
                {76,75},{77,75},{77,76},{78,76},{78,77},{79,77},{79,78},
                {80,78},{80,79},{81,79},{81,80},{82,80},{82,81},{83,81},
                {83,82},{84,82},{84,83},{85,83},{85,84},{86,84},{86,85},
                {87,85},{87,86},{88,86},{88,87},{89,87},{89,88},{90,88},
                {90,89},{91,89},{91,90},{92,90},{92,91},{93,91},{93,92},
                {94,92},{94,93},{95,93},{95,94},{96,94},{96,95},{97,95},
                {97,96},{98,96},{98,97},{99,97}};
        long start = System.currentTimeMillis();
        System.out.println(isPossibleToCompleteCourse(100, test6Courses));//true
        long end = System.currentTimeMillis();
        System.out.println("Time taken: "+(end-start));
    }
}
