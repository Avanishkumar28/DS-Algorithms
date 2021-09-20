package algo.graph;

import java.util.*;

public class DFSByHashMap {

    public  static List<String> dfs(String start, Map<String, List<String>> graph){
        if (graph == null)
            return null;
        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        Set<String> nodeSet = new HashSet<>();
        stack.push(start);
        while (!stack.isEmpty()){
            String current = stack.pop();
            result.add(current);
            if (graph.get(current) != null){
                for(String neighbour : graph.get(current)){
                    if (nodeSet.add(neighbour))
                        stack.push(neighbour);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph  = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C", "D"));
        graph.put("B", Arrays.asList("F"));
        graph.put("C", Arrays.asList("E"));
        graph.put("D", Arrays.asList("E", "H"));
        graph.put("E", null);
        graph.put("F", Arrays.asList("G"));
        graph.put("G", Arrays.asList("I"));
        graph.put("H", Arrays.asList("G"));
        graph.put("I", null);

        System.out.println(dfs("A", graph)); //[A, B, F, G, I, C, E, D, H] OR [A, D, H, G, I, E, C, B, F]
    }
}
