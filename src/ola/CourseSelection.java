package ola;

import java.util.*;

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

    public static boolean isPossibleToCompleteCourse(int[][] courses){
        if (courses == null)
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
        for (Integer key : courseMap.keySet()){
            if(visited.contains(key))
                continue;
            if (containsCycle(key, courseMap, visited))
                return false;
        }
        return true;
    }

    private static boolean containsCycle(Integer key, Map<Integer, List<Integer>> courseMap, Set<Integer> visited){
        if (visited.contains(key))
            return true;
        else{
            visited.add(key);
            List<Integer> preRequisite = courseMap.get(key);
            for (Integer courseId : preRequisite){
                if (courseMap.containsKey(courseId) && containsCycle(courseId, courseMap, visited)){
                    return true;
                }
            }
            //don't find cycle for this key so remove it from visited
            visited.remove(key);
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] test1Courses = {{1,0},{2,1},{3,2},{4,3},{0,4}};
        System.out.println(isPossibleToCompleteCourse(test1Courses));//false
        int[][] test2Courses = {{1,0},{0,1}};
        System.out.println(isPossibleToCompleteCourse(test2Courses));//false
        int[][] test3Courses = {{1,0},{2,1},{2,0},{3,0},{2,3}};
        System.out.println(isPossibleToCompleteCourse(test3Courses));//true
        int[][] test4Courses = {{0,1},{1,2},{3,1},{3,0},{3,2}};
        System.out.println(isPossibleToCompleteCourse(test4Courses));//true
    }
}
