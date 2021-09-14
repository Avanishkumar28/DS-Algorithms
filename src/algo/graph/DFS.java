package algo.graph;

import java.util.*;

public class DFS {

    public static List<String> dfs(Node<String> start){
        if(start == null)
            return new ArrayList<>();
        Stack<Node<String>> stack = new Stack<>();
        stack.push(start);

        List<String> resultList = new ArrayList<>();
        Set<Node<String>> visited = new HashSet<>();
        visited.add(start);
        while(!stack.isEmpty()){
            Node<String> current = stack.pop();
            resultList.add(current.getData());

            for (Node<String> neighbor : current.getNeighbours()){
                if(visited.add(neighbor))
                    stack.push(neighbor);
            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        Node<String> graph = GraphUtils.graphBuilder();
        System.out.println(dfs(graph));
    }
}
