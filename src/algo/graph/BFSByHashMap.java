package algo.graph;

import java.util.*;

public class BFSByHashMap {

    public static List<String> bfs(String start, Map<String , List<String>> graph){
        if (graph == null)
            return null;
        List<String> result = new ArrayList<>();
        Set<String> nodeSet = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()){
            String node = q.remove();
            result.add(node);
            if (graph.get(node) != null){
                for (String neighbour : graph.get(node)){
                    if (nodeSet.add(neighbour))
                        q.add(neighbour);
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

        System.out.println(bfs("A", graph)); //[A, B, C, D, F, E, H, G, I]
    }
}
