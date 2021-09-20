package algo.graph;

import java.util.*;

public class BFS {

    public static List<String> bfs(Node<String> start){
        if(start == null)
            return null;
        List<String> result = new ArrayList<>();
        Queue<Node<String>> q = new LinkedList<>();
        q.add(start);

        Set<Node<String>> nodeSet = new HashSet<>();
        while (!q.isEmpty()){
            Node<String> current = q.remove();
            result.add(current.getData());
            for (Node<String> neighbour : current.getNeighbours()){
                if (nodeSet.add(neighbour)) {
                    q.add(neighbour);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Node<String> start = GraphUtils.graphBuilderWithoutCycle();
        System.out.println(bfs(start)); //[A, B, C, D, F, E, H, G, I]
    }
}
